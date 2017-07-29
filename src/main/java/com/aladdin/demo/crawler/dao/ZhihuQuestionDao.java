package com.aladdin.demo.crawler.dao;

import com.aladdin.demo.dao.BaseDao;
import com.aladdin.demo.crawler.entity.ZhihuQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zkx on 2017/3/22.
 */
@Component
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
