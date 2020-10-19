package qf.edu.dao;

import qf.edu.entity.Good;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class GoodDao extends BaseDao {
    /**
     * 添加商品信息
     * @param good 参数是Good对象
     */
    public void addGood(Good good) {
        String sql = "insert into projectweb.web_goods(name, pubdate, picture, price, star, info, typeid) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Object[] params = {good.getName(), good.getPubdate(), good.getPicture(), good.getPrice(),
                good.getStar(), good.getInfo(), good.getTypeid()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 示数据库内所有商品信息
     * @return 返回值为Good的List集合
     */
    public List<Good> findAll() {
        List<Good> list = null;
        try {
            list = super.queryBeanList("select * from projectweb.web_goods", Good.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据商品序号删除指定商品
     * @param id 参数为商品序号，唯一
     */
    public void deleteGood(String id) {
        String sql = "delete from projectweb.web_goods where id = " + id;

        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据商品序号找到指定商品
     * @param id 参数为商品序号，唯一
     * @return 返回值类型为Good对象
     */
    public Good findById(String id) {
        String sql = "select * from projectweb.web_goods where id = " + id;
        Good good = null;

        try {
            good = super.queryBean(sql, Good.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return good;
    }

    /**
     * 根据商品类型序号找到该类型下的所有商品
     * @param typeid 商品类型序号，唯一
     * @return 返回值为商品Good对象的List集合
     */
    public List<Good> findByTypeid(String typeid) {
        String sql = "select * from projectweb.web_goods where typeid = " + typeid;
        List<Good> list = null;

        try {
            list = super.queryBeanList(sql, Good.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 写入数据库一个商品信息
     * @param good 参数是一个Good对象
     */
    public void updateGood(Good good) {
        String sql = "update projectweb.web_goods set name = ?, pubdate = ?, picture = ?, price = ?, star = ?," +
                " info = ?, typeid = ? where id = ?";

        Object[] params = {good.getName(), good.getPubdate(), good.getPicture(), good.getPrice(),
                good.getStar(), good.getInfo(), good.getTypeid(), good.getId()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
