package com.aladdin.demo.crawler.service;

import com.aladdin.demo.common.CrawlerConstant;
import com.aladdin.demo.crawler.MyCrawler;
import com.aladdin.demo.crawler.dao.ZhihuQuestionDao;
import com.aladdin.demo.crawler.entity.ZhihuQuestion;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zkx on 2017/3/22.
 */
@Service
public class CrawlerService {
    @Autowired
    private ZhihuQuestionDao zhihuQuestionDao;

    public void startCrawl(int start, int end, int threads) throws Exception {
        CrawlConfig crawlConfig = new CrawlConfig();

        PageFetcher pageFetcher = new PageFetcher(crawlConfig);
        RobotstxtConfig config = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(config, pageFetcher);
        CrawlController crawlController = new CrawlController(crawlConfig, pageFetcher, robotstxtServer);

        for (int i = start; i < end; i++) {
            String suffix = String.format("%08d", i);
            crawlController.addSeed(CrawlerConstant.URL_ZHIHU_PREFIX + "/" + suffix);
        }
        crawlController.start(MyCrawler.class, threads);

        List<ZhihuQuestion> zhihuQuestionList = new ArrayList<ZhihuQuestion>();
        List<Object> questionList = crawlController.getCrawlersLocalData();
        for (Object question : questionList) {
            if (!(question instanceof ZhihuQuestion)) {
                continue;
            }
            ZhihuQuestion zhihuQuestion = (ZhihuQuestion) question;
            zhihuQuestionList.add(zhihuQuestion);
        }

        zhihuQuestionDao.insertQuestions(zhihuQuestionList);
    }

}
