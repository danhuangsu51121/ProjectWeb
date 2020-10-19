package qf.edu.servlet;

import org.apache.commons.beanutils.BeanUtils;
import qf.edu.dao.UserDao;
import qf.edu.entity.User;
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

@WebServlet("/user.action")
public class UserServlet extends BaseServlet {

    /**
     * 类内使用StudentDao层对象，用于操作数据库Student相关内容
     */
    private UserDao userDao = new UserDao();

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        userDao.addUser(user);

        // 重定向到indexServlet
        // req.getRequestDispatcher()
        response.sendRedirect("userLogin.jsp");
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        userDao.deleteUser(id);

        response.sendRedirect("user.action?method=listUser");
    }

    public void modifyUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        User user = new UserDao().findById(id);

        // 转发到一个JSP页面
        request.setAttribute("user", user);
        request.getRequestDispatcher("modifyUser.jsp").forward(request, response);
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> list = new UserDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
//        request.getParameter()
//        request.getParameterValues()
//        request.getParameterNames()
//        request.getParameterMap()
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        new UserDao().updateUser(user);

        response.sendRedirect("user.action?method=listUser");
    }
}
