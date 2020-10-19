package qf.edu.servlet;

import org.apache.commons.beanutils.BeanUtils;
import qf.edu.dao.AddressDao;
import qf.edu.dao.ShoppingCartDao;
import qf.edu.dao.UserDao;
import qf.edu.entity.Address;
import qf.edu.entity.ShoppingCart;
import qf.edu.entity.User;
import util.BaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 登录操作，并且注册Session信息
 *
 * @author MI 2020/4/1 16:08
 */
@WebServlet("/cart.action")
public class CartServlet extends BaseServlet {
    /**
     * 类内使用ShoppingCartDao层对象，用于操作数据库ShoppingCar相关内容
     */
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDao();

    /**
     * 从商品页跳转用于传递相关参数来进行添加商品
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void linkCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String pid = req.getParameter("pid");
        String uid = req.getParameter("uid");
        String price = req.getParameter("price");
        String name = req.getParameter("name");

        req.setAttribute("pid",pid);
        req.setAttribute("uid",uid);
        req.setAttribute("price",price);
        req.setAttribute("name",name);

        req.getRequestDispatcher("addCart.jsp").forward(req,resp);
    }

    /**
     * 用于接受前台提交的商品信息，添加到购物车
     * @param request
     * @param response
     * @throws IOException
     */
    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        ShoppingCart cart = new ShoppingCart();

        try {
            BeanUtils.populate(cart, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        shoppingCartDao.addCart(cart);

        int id = cart.getId();

        // 重定向到indexServlet
        // req.getRequestDispatcher()
        response.sendRedirect("cart.action?method=listCartById&id=" + id);
    }

    /**
     * 用于展示所有ShoppingCart信息，没用上
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ShoppingCart> list = new ShoppingCartDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listCart.jsp").forward(request, response);
    }

    /**
     * 用于展示用户购物车信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listCartById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");

        List<ShoppingCart> list = new ShoppingCartDao().findById(id);

        request.setAttribute("list", list);

        request.getRequestDispatcher("listCart.jsp").forward(request, response);
    }

    /**
     * 用于展示所有ShoppingCart信息，没用上
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void findCartAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ShoppingCart> list = new ShoppingCartDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listCart.jsp").forward(request, response);
    }

    /**
     * 根据用户序号及商品序号锁定指定购物车商品并删除
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteCartOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        String id = request.getParameter("id");

        shoppingCartDao.deleteCartOne(pid,id);

        response.sendRedirect("cart.action?method=listCartById&id=" + id);
    }

    /**
     * 删除指定用户购物车内的商品信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteCartAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        shoppingCartDao.deleteCartAll(id);

        response.sendRedirect("cart.action?method=listCartById&id=" + id);
    }

    /**
     * 根据用户序号及商品序号锁定指定购物车商品并修改
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void modifyCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String pid = request.getParameter("pid");
        ShoppingCart cart = new ShoppingCartDao().findCart(pid, id);

        // 转发到一个JSP页面
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("modifyCart.jsp").forward(request, response);
    }

    /**
     * 将从前台接收到的指定购物商品写入数据库
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
//        request.getParameter()
//        request.getParameterValues()
//        request.getParameterNames()
//        request.getParameterMap()
        ShoppingCart cart = new ShoppingCart();

        try {
            BeanUtils.populate(cart, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        new ShoppingCartDao().updateNumber(cart);
        int id = cart.getId();

        response.sendRedirect("cart.action?method=listCartById&id=" + id);
    }
}
