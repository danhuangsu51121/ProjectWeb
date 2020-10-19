package qf.edu.dao;

import qf.edu.entity.Address;
import qf.edu.entity.User;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class AddressDao extends BaseDao {

    /**
     * 添加地址信息
     * @param address 参数是Address对象
     */
    public void addAddress(Address address) {
        String sql = "insert into projectweb.web_address(detail, name, phone, uid, level) VALUES (?, ?, ?, ?, ?)";

        Object[] params = {address.getDetail(),address.getName(),address.getPhone(),address.getUid(),address.getLevel()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示数据库内所有地址
     * @return 返回值为Address的List集合
     */
    public List<Address> findAll() {
        List<Address> list = null;
        try {
            list = super.queryBeanList("select * from projectweb.web_address", Address.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 根据地址序号删除指定地址
     * @param id  参数为地址序号，唯一
     */
    public void deleteAddress(String id) {
        String sql = "delete from projectweb.web_address where id = " + id;

        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据地址序号查找到指定地址
     * @param id 参数为地址序号，唯一
     * @return 返回值为Address对象
     */
    public Address findById(String id) {
        String sql = "select * from projectweb.web_address where id = " + id;
        Address address  = null;

        try {
            address = super.queryBean(sql, Address.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }

    /**
     * 根据用户序号查找到该用户设置的所有地址
     * @param uid 参数为用户序号，唯一
     * @return 返回值为Address对象的List集合
     */
    public List<Address> findByUId(String uid) {
        String sql = "select * from projectweb.web_address where uid = " + uid;
        List<Address> list = null;

        try {
            list = super.queryBeanList(sql, Address.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 写入数据库一个地址信息
     * @param address 参数为一个Address对象
     */
    public void updateAddress(Address address) {
        String sql = "update projectweb.web_address set uid = ?, detail = ?, name = ?, phone = ?, level = ? where id = ?";

        Object[] params = {address.getUid(), address.getDetail(), address.getName(), address.getPhone(),
                address.getLevel(), address.getId()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
