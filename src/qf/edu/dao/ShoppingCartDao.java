package qf.edu.dao;

import qf.edu.entity.Good;
import qf.edu.entity.ShoppingCart;
import qf.edu.entity.User;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartDao extends BaseDao {
    /**
     * 用户添加一个商品到购物车
     * @param cart 参数为一个ShoppingCart对象
     */
    public void addCart(ShoppingCart cart) {
        String sql = "insert into projectweb.web_shopping_cart(id, pid, num, money) VALUES (?, ?, ?, ?)";

        Object[] params = {cart.getId(), cart.getPid(), cart.getNum(), cart.getMoney()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 找到所有的ShoppingCart对象
     * @return 返回值为ShoppingCart对象对象的List集合
     */
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> list = null;
        try {
            list = super.queryBeanList("select * from projectweb.web_shopping_cart", ShoppingCart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据指定商品序号，用户序号删除指定ShoppingCart对象
     * @param pid 商品序号
     * @param id 用户序号
     */
    public void deleteCartOne(String pid, String id) {
        String sql = "delete from projectweb.web_shopping_cart where pid = " + pid + " && id = " + id;
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定商品序号，用户序号找到指定ShoppingCart对象
     * @param pid
     * @param id
     * @return 返回值为ShoppingCart对象
     */
    public ShoppingCart findCart(String pid, String id) {
        String sql = "select * from projectweb.web_shopping_cart where pid = " + pid + " && id = " + id;
        ShoppingCart cart = new ShoppingCart();
        try {
            cart = super.queryBean(sql, ShoppingCart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    /**
     * 根据用户序号删除所有的 ShoppingCart 对象
     * @param id 参数为用户id
     */
    public void deleteCartAll(String id) {

        String sql = "delete from projectweb.web_shopping_cart where id = " + id;

        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过用户序号找到其所有ShoppingCart对象
     * @param id 用户序号
     * @return ShoppingCart对象的List集合
     */
    public List<ShoppingCart> findById(String id) {
        String sql = "select * from projectweb.web_shopping_cart where id = " + id;
        List<ShoppingCart> list = null;

        try {
            list = super.queryBeanList(sql, ShoppingCart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 用于用户修改指定ShoppingCart对象，并写入数据库
     * @param cart ShoppingCart对象
     */
    public void updateNumber(ShoppingCart cart) {
        String sql = "update projectweb.web_shopping_cart set num = ?, money = ? where id = ? && pid = ?";

        Object[] params = {cart.getNum(),cart.getMoney(),cart.getId(),cart.getPid()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
