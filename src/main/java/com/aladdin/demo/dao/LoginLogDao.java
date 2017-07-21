package com.aladdin.demo.dao;

import com.aladdin.demo.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zkx on 2017/3/20.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "insert into t_login_log(userId,ip,login_datetime) values(?,?,?)";
        jdbcTemplate.update(sqlStr, new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
    }
}
