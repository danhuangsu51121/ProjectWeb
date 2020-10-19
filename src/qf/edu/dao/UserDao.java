package qf.edu.dao;

import qf.edu.entity.User;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class UserDao extends BaseDao {

    /**
     * 注册普通用户
     * @param user 用户对象
     */
    public void addUser(User user) {
        String sql = "insert into projectweb.web_user(username, password, email, gender, flag, role) VALUES (?, ?, ?, ?, ?, ?)";

        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册管理员用户
     * @param user 用户对象
     */
    public void addManager(User user) {
        String sql = "insert into projectweb.web_user(username, password, email, gender, role) VALUES (?, ?, ?, ?, ?)";

        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getRole()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示所有User对象
     * @return 返回值为User对象的List集合
     */
    public List<User> findAll() {
        List<User> list = null;
        try {
            list = super.queryBeanList("select * from projectweb.web_user", User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据用户序号删除指定用户
     * @param id 用户序号，唯一
     */
    public void deleteUser(String id) {
        String sql = "delete from projectweb.web_user where id = " + id;

        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户序号找到指定User对象
     * @param id 用户序号，唯一
     * @return 返回值为用户对象
     */
    public User findById(String id) {
        String sql = "select * from projectweb.web_user where id = " + id;
        User user = null;

        try {
            user = super.queryBean(sql, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 根据用户名找到指定用户对象，用户名唯一
     * @param username 用户名，唯一
     * @return 返回值为User对象
     */
    public User findByName(String username) {
        String sql = "select * from projectweb.web_user where username = " + username;
        User user = null;
        try {
            user = super.queryBean(sql, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 将一个User对象信息写入数据库
     * @param user 用户对象
     */
    public void updateUser(User user) {
        String sql = "update projectweb.web_user set username = ?, password = ?, email = ?, gender = ? where id = ?";

        Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getId()};

        try {
            super.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
