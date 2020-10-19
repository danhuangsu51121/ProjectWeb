package qf.edu.servlet;

import org.apache.commons.beanutils.BeanUtils;
import qf.edu.dao.AddressDao;
import qf.edu.dao.OrderDao;
import qf.edu.dao.ShoppingCartDao;
import qf.edu.dao.UserDao;
import qf.edu.entity.Address;
import qf.edu.entity.Order;
import qf.edu.entity.ShoppingCart;
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

/**
 * 登录操作，并且注册Session信息
 *
 * @author MI 2020/4/1 16:08
 */
@WebServlet("/order.action")
public class OrderServlet extends BaseServlet {

    private OrderDao orderDao  = new OrderDao();

    public void linkOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String uid = req.getParameter("uid");

        List<Address> list2 = new AddressDao().findByUId(uid);

        List<ShoppingCart> list1 = new ShoppingCartDao().findById(uid);

        double money = 0;
        for (ShoppingCart cart : list1) {
            money += cart.getMoney();
        }

        req.setAttribute("money",money);
        req.setAttribute("list2",list2);


        req.getRequestDispatcher("addOrder.jsp").forward(req,resp);
    }

    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        Order order = new Order();

        try {
            BeanUtils.populate(order, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        orderDao.addOrder(order);

        response.sendRedirect("order.action?method=listOrderByUid&uid=" + order.getUid());

//        int id = order.getId();
//
//        // 重定向到indexServlet
//        // req.getRequestDispatcher()
//        response.sendRedirect("order.action?method=listOrderById&id=" + id);
    }

    //展示所有订单
    public void listOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Order> list = new OrderDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listOrder.jsp").forward(request, response);
    }

    public void listOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");

        Order order = new OrderDao().findOrderById(id);

        request.setAttribute("order", order);

        request.getRequestDispatcher("listOrder.jsp").forward(request, response);
    }

    public void listOrderByUid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uid = request.getParameter("uid");

        List<Order> list = new OrderDao().findOrderByUid(uid);

        request.setAttribute("list", list);

        request.getRequestDispatcher("listOrder.jsp").forward(request, response);
    }

    public void findOrderAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Order> list = new OrderDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listOrder.jsp").forward(request, response);
    }


    public void deleteOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        orderDao.deleteOrderById(id);

        response.sendRedirect("order.action?method=listOrder");
    }

    public void deleteOrderAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        orderDao.deleteOrderAll(id);

        response.sendRedirect("order.action?method=listOrderById&id=" + id);
    }

    public void modifyOrderStatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Order order = new OrderDao().findOrderById(id);

        // 转发到一个JSP页面
        request.setAttribute("order", order);
        request.getRequestDispatcher("modifyOrder.jsp").forward(request, response);
    }

    public void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
//        request.getParameter()
//        request.getParameterValues()
//        request.getParameterNames()
//        request.getParameterMap()

        Order order = new Order();
        try {
            BeanUtils.populate(order, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        new OrderDao().updateOrder(order);

        response.sendRedirect("order.action?method=listOrder");
    }
}
