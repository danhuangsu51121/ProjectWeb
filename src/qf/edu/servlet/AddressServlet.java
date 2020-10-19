package qf.edu.servlet;

import org.apache.commons.beanutils.BeanUtils;
import qf.edu.dao.AddressDao;
import qf.edu.entity.Address;
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

@WebServlet("/address.action")
public class AddressServlet extends BaseServlet {

    /**
     * 类内使用AddressDao层对象，用于操作数据库Address相关内容
     */
    private AddressDao addressDao = new AddressDao();

    /**
     * 用于增加地址信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        Address address = new Address();

        try {
            BeanUtils.populate(address, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        addressDao.addAddress(address);

        int uid = address.getUid();

        // 重定向到indexServlet
        // req.getRequestDispatcher()
        response.sendRedirect("address.action?method=listAddressByUid&uid=" + uid);
    }

    /**
     * 用于删除地址信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        Address address = addressDao.findById(id);

        addressDao.deleteAddress(id);

        response.sendRedirect("address.action?method=listAddressByUid&uid=" + address.getUid());
    }

    /**
     * 用于修改地址信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void modifyAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Address address = new AddressDao().findById(id);

        // 转发到一个JSP页面
        request.setAttribute("address", address);
        request.getRequestDispatcher("modifyAddress.jsp").forward(request, response);
    }

    /**
     * 用于展示地址信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Address> list = new AddressDao().findAll();
        request.setAttribute("list", list);

        request.getRequestDispatcher("listAddress.jsp").forward(request, response);
    }

    /**
     * 用于更新地址信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
//        request.getParameter()
//        request.getParameterValues()
//        request.getParameterNames()
//        request.getParameterMap()
        Address address = new Address();
        try {
            BeanUtils.populate(address, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        new AddressDao().updateAddress(address);

        response.sendRedirect("address.action?method=listAddressByUid&uid=" + address.getUid());
    }

    /**
     * 根据用户序号展示地址信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void listAddressByUid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uid = request.getParameter("uid");
        List<Address> list = new AddressDao().findByUId(uid);
        request.setAttribute("list", list);

        request.getRequestDispatcher("listAddress.jsp").forward(request, response);
    }
}
