package com.aladdin.demo.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

/**
 * Created by zkx on 2017/3/22.
 */
@Component
public class BaseDao<E> extends SqlSessionDaoSupport {
    public BaseDao() {
    }

    public void insertList(String sql, Object parameter) {
        getSqlSession().insert(sql, parameter);
    }

    public void delete(String sql) {
        getSqlSession().delete(sql);
    }

    public void delete(String sql, Object parameter) {
        getSqlSession().delete(sql, parameter);
    }

    public E selectOne(String sql) {
        return getSqlSession().selectOne(sql);
    }
}
