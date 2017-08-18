package com.zkx.bbs.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by zkx on 2017/3/22.
 */
public class BaseDao<E> extends SqlSessionDaoSupport {
    public BaseDao() {
    }

    public void insertList(String sql, Object parameter) {
        getSqlSession().insert(sql, parameter);
    }

    public void insert(String sql, Object parameter) {
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

    public E selectOne(String sql, Map<String, Object> params) {
        return getSqlSession().selectOne(sql, params);
    }

    public List<E> selectList(String sql, Object params) {
        return getSqlSession().selectList(sql, params);
    }

    public List<E> selectList(String sql) {
        return getSqlSession().selectList(sql);
    }

    public Map<Object, E> selectMap(String sql, Object params, String key) {
        return getSqlSession().selectMap(sql, params, key);
    }

    public int update(String sql, Object params) {
        return getSqlSession().update(sql, params);
    }
}
