package com.aladdin.demo.crawler.dao;

import com.aladdin.demo.crawler.entity.ZhihuQuestion;

import java.util.List;

/**
 * Created by zkx on 2017/4/7.
 */
public interface ZhihuQuestionMapper {
    ZhihuQuestion getQuestion(Integer questionId);

    List<ZhihuQuestion> getQuestionAll();

    void insertQuestion(ZhihuQuestion question);

    void deleteQuestion(ZhihuQuestion question);

    void updateQuestion(ZhihuQuestion question);

}