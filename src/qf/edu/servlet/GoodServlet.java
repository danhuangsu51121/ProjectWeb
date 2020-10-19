package qf.edu.servlet;

import org.apache.commons.beanutils.BeanUtils;
import qf.edu.dao.GoodDao;
import qf.edu.entity.Good;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

// http://localhost:8080/Day40_BaseServlet/student.action?method=addStudent
// http://localhost:8080/Day40_BaseServlet/student.action?method=listStudent

@WebServlet("/good.action")
public class GoodServlet extends BaseServlet {

    /**
     * 类内使用GoodDao层对象，用于操作数据库Good相关内容
     */

    private GoodDao goodDao = new GoodDao();

    /**
     * 添加一个商品信息到数据库
     * @param request
     * @param response
     * @throws IOException
     */
    public void addGood(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        Good good = new Good();

        try {
            BeanUtils.populate(good, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        goodDao.addGood(good);

        // 重定向到indexServlet
        // req.getRequestDispatcher()
        response.sendRedirect("good.action?method=listGood");
    }

    /**
     * 根据商品序号删除指定商品
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteGood(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        goodDao.deleteGood(id);

        response.sendRedirect("good.action?method=listGood");
    }

    /**
     * 根据指定商品序号，找到该商品进行信息修改
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void modifyGood(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Good good = new GoodDao().findById(id);

        // 转发到一个JSP页面
        request.setAttribute("good", good);
        request.getRequestDispatcher("modifyGood.jsp").forward(request, response);
    }

    /**
     * 展示所有商品信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listGood(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Good> list = new GoodDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listGoodManager.jsp").forward(request, response);
    }

    /**
     * 将从前台传来的商品信息写入数据库
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateGood(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
//        request.getParameter()
//        request.getParameterValues()
//        request.getParameterNames()
//        request.getParameterMap()
        Good good = new Good();
        try {
            BeanUtils.populate(good, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        new GoodDao().updateGood(good);

        response.sendRedirect("good.action?method=listGood");
    }

    /**
     * 根据指定商品类型序号，展示该类型所有商品
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listGoodByTypeid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String typeid = request.getParameter("typeid");
        List<Good> list = new GoodDao().findByTypeid(typeid);

        request.setAttribute("list", list);

        request.getRequestDispatcher("listGoodUser.jsp").forward(request, response);
    }

    /**
     * 根据指定商品序号，展示其信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listGoodByid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Good good = new GoodDao().findById(id);
        request.setAttribute("good", good);

        request.getRequestDispatcher("listGoodDetail.jsp").forward(request, response);
    }
}
