package com.zkx.bbs.crawler.dao;

import com.zkx.bbs.dao.BaseDao;
import com.zkx.bbs.crawler.entity.ZhihuQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zkx on 2017/3/22.
 */
@Repository
public class ZhihuQuestionDao {
    private static final String NAMESPACE_ZHIHUQUESTION = "com.aladdin.demo.crawler.dao.ZhihuQuestionDao";

    @Autowired
    private BaseDao<ZhihuQuestion> questionDao;

    public void insertQuestions(List<ZhihuQuestion> list) {
        questionDao.insertList(NAMESPACE_ZHIHUQUESTION + ".insertQuestions", list);
    }

    public ZhihuQuestion q(String sql) {
        return questionDao.selectOne(sql);
    }
}
