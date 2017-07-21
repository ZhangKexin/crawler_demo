package com.aladdin.demo.dao;

import com.aladdin.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zkx on 2017/3/20.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*根据用户名密码获取匹配用户数*/
    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(*) from t_user where user_name=? and password=?";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
    }

    /*根据用户名获取user对象*/
    public User findUserByUserName(final String userName) {
        String sqlStr = "select * from t_user where user_name=?";
        final User user = new User();
//        user = jdbcTemplate.queryForObject(sqlStr, new Object[]{userName}, User.class);
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits") + 5);
            }
        });
        return user;
    }

    /*更新积分、最后登录IP、时间*/
    public void updateLoginInfo(User user) {
        String sqlStr = "update t_user set credits=?,last_visit=?,last_ip=? where user_id=?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getCredits(), user.getLastVisit(), user.getLastIp(), user.getUserId()});
    }
}
