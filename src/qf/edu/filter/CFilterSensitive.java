package qf.edu.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
敏感词汇过滤器
 */
@WebFilter("/*")
@SuppressWarnings("all")
public class CFilterSensitive implements Filter {
    private List<String> list;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // init方法读取对应文件内容，保存到list集合中
        String realPath = filterConfig.getServletContext().getRealPath("WEB-INF/Sensitive.txt");

        File file = new File(realPath);
        list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpServletRequest proxyRequest = (HttpServletRequest) Proxy.newProxyInstance(
                // 通过对象方式获取ClassLoader和对应Interface
                req.getClass().getClassLoader(),
                req.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("getParameter".equals(method.getName())) {
                            // 获取原数据
                            String str = (String) method.invoke(req, args);

                            // 遍历整个敏感词汇List集合
                            str = sensitiveHandler(str);

                            return str;

                        } else if ("getParameterValues".equals(method.getName())) {
                            String[] param = (String[]) method.invoke(req, args);

                            for (int i = 0; i < param.length; i++) {
                                // 数据处理从哪里来，回哪里去，采用数组+下标方式
                                param[i] = sensitiveHandler(param[i]);
                            }

                            return param;

                        } else if ("getParameterMap".equals(method.getName())) {
                            // Map<String, String[]>;

                            // 获取Map双边队列，数据是键值对形式内容，
                            // String对应的是前端name属性 String[] 对应value属性
                            Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);

                            // 获取键值对对象 Set集合
                            Set<Map.Entry<String, String[]>> entries = map.entrySet();

                            // 遍历Entry Set集合，从entry中取出value ==> String[]
                            for (Map.Entry<String, String[]> entry : entries) {
                                String[] value = entry.getValue();

                                // 替换
                                for (int i = 0; i < value.length; i++) {
                                    // 数据处理从哪里来，回哪里去，采用数组+下标方式
                                    value[i] = sensitiveHandler(value[i]);
                                }
                            }

                            return map;
                        } else {
                            return method.invoke(req, args);
                        }
                    }
                });

        // 放行代理对象，和 response对象
        chain.doFilter(proxyRequest, resp);
    }

    private String sensitiveHandler(String str) {
        for (String sensitive : list) {
            // 发现当前str中包含敏感词汇
            if (str.contains(sensitive)) {
                str = str.replaceAll(sensitive, "**");
            }
        }
        return str;
    }

    @Override
    public void destroy() {

    }
}
