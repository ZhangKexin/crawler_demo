package com.zkx.crawler_demo;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by zkx on 2017/3/16.
 */
public class Controller {
    public static void main(String[] args) throws Exception {
        String crawlerStorageFolder = "/data/crawl/root";
        int numOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlerStorageFolder);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        for (int i = 0; i < 100; i++) {
            String s = String.format("%02d", i);
            controller.addSeed("https://www.zhihu.com/question/314278" + s);
        }
//        controller.addSeed("https://www.zhihu.com/question/31427895" );
        Long startTime = System.currentTimeMillis();
        controller.start(MyCrawler.class, numOfCrawlers);
        System.out.println(controller.isFinished());
        Long endTime = System.currentTimeMillis();
        System.out.println(startTime + "~" + endTime + "---" + (endTime - startTime));
    }
}
