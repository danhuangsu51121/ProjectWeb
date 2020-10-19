package qf.edu.servlet;

import qf.edu.dao.GoodDao;
import qf.edu.dao.UserDao;
import qf.edu.entity.Good;
import qf.edu.entity.User;
import util.BaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录操作，并且注册Session信息
 *
 * @author MI 2020/4/1 16:08
 */
@WebServlet("/userLogin.action")
public class LoginServlet extends BaseServlet {

    /**
     * 用于接收前台提交的用户名，密码来决定能否登录成功，成功则设置cookie，session方便用户登录
     * @param req
     * @param resp
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");

        UserDao userDao = new UserDao();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDao.findByName(username);
        if (null == user) {
            // 用户名不存在，登录失败
            PrintWriter writer = resp.getWriter();
            String html = "<script type=\"text/javascript\">";
            html += "alert(\"用户名,密码错误,请重新输入\")";
            html += ";window.location.href='userLogin.jsp';";
            html += "</script>";
            writer.append(html);
        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            // 登录成功

            //服务器端有session了就可以在浏览器添加cookie以实现下次自动登录了
            HttpSession session = req.getSession(true);
            session.setMaxInactiveInterval(60 * 60);
            session.setAttribute("username", username);


            ServletContext servletContext = this.getServletContext();

            servletContext.setAttribute("user",user);

            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 60);

            resp.addCookie(cookie);

            //获取用户role，来进行界面分类
            int id = user.getRole();

            if (0 == id) {
                resp.sendRedirect("userLogin.action?method=userLink");
            } else {
                resp.sendRedirect("userLogin.action?method=managerLink");
            }



        } else {
            // 用户名存在，密码不对
            PrintWriter writer = resp.getWriter();
            String html = "<script type=\"text/javascript\">";
            html += "alert(\"密码错误,请重新输入\")";
            html += ";window.location.href='userLogin.jsp';";
            html += "</script>";
            writer.append(html);


            //"<script>alert('这里写提示内容');window.location.href='这里写需要跳转的页面';</script>");
        }
    }

    /**
     * 用于用户注销登录（销毁服务器端session信息）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void userLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        this.getServletContext().removeAttribute("user");

        resp.sendRedirect("index.jsp");
    }

    /**
     * 用于决定普通用户的跳转方向
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void userLink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);

        if (null == session) {
            resp.sendRedirect("userLogin.jsp");
        } else {
            resp.sendRedirect("userIndex.jsp");
        }
    }

    /**
     * 用于决定管理员的跳转方向
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void managerLink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);

        if (null == session) {
            resp.sendRedirect("userLogin.jsp");
        } else {
            resp.sendRedirect("managerIndex.jsp");

        }
    }

}
