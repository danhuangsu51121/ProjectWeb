package qf.edu.dao;

import qf.edu.entity.Address;
import qf.edu.entity.Order;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class OrderDao extends BaseDao {

    /**
     * 增加一个订单信息
     * @param order 参数为Order对象
     */
    public void addOrder(Order order) {
        String sql = "insert into projectweb.web_order(uid, money, status, time, aid) VALUES (?, ?, ?, ?, ?)";

        Object[] params = {order.getUid(), order.getMoney(), order.getStatus(), order.getTime(), order.getAid()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于管理员用于显示所有订单信息
     * @return 返回值是Order的List集合
     */
    //用于管理员查找所有订单
    public List<Order> findAll() {
        List<Order> list = null;
        try {
            list = super.queryBeanList("select * from projectweb.web_order", Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 用户删除自己某个订单
     * @param id 参数为订单序号，唯一
     */
    //用户删除自己某个订单
    public void deleteOrderById(String id) {
        String sql = "delete from projectweb.web_order where id = " + id;
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据订单编号查找指定订单
     * @param id 参数为订单序号，唯一
     * @return
     */
    //根据订单编号查找订单
    public Order findOrderById(String id) {
        String sql = "select * from projectweb.web_order where id = " + id;
        Order order = new Order();
        try {
            order = super.queryBean(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    /**
     * 查找用户自身所有订单
     * @param uid 参数为用户序号，唯一
     * @return 返回值为Order的List集合
     */
    //查找用户自身所有订单
    public List<Order> findOrderByUid(String uid) {
        String sql = "select * from projectweb.web_order where uid = " + uid;
        List<Order> list = null;
        try {
            list = super.queryBeanList(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据订单序号找到指定订单
     * @param id 参数为订单序号，唯一
     * @return 返回值为Order对象
     */
    public Order findOrder(String id) {
        String sql = "select * from projectweb.web_order where id = " + id;
        Order order = new Order();
        try {
            order = super.queryBean(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    //删除用户自己所有订单

    /**
     * 用于删除用户自己所有订单
     * @param uid 参数为用户序号，唯一
     */
    public void deleteOrderAll(String uid) {

        String sql = "delete from projectweb.web_order where uid = " + uid;

        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //找到用户自己所有订单

    /**
     * 找到用户自己所有订单
     * @param uid 参数为用户序号，唯一
     * @return 返回值为Order的List集合
     */
    public List<Order> findByUId(String uid) {
        String sql = "select * from projectweb.web_order where uid = " + uid;
        List<Order> list = null;

        try {
            list = super.queryBeanList(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    //写入数据库

    /**
     * 将一个订单信息写入数据库
     * @param order 参数为Order对象
     */
    public void updateOrder(Order order) {
        String sql = "update projectweb.web_order set uid = ?, money = ?, status = ?, time = ?, aid = ? where id = ?";

        Object[] params = {order.getUid(), order.getMoney(), order.getStatus(), order.getTime(), order.getAid(), order.getId()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
