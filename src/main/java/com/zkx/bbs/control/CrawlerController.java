package com.zkx.bbs.control;

import com.zkx.bbs.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zkx on 2017/3/22.
 */
@Controller
@RequestMapping("v1/crawler")
public class CrawlerController {
    @Autowired
    private CrawlerService crawlerService;

    @RequestMapping("")
    @ResponseBody
    public Object start(int start, int end, @RequestParam(required = false, defaultValue = "7") int threads) {
        Map result = new HashMap();
        try {
            crawlerService.startCrawl(start, end, threads);
        } catch (Exception e) {
            result.put("status", "failed");
            e.printStackTrace();
        }
        result.put("status", "OK");
        return result;
    }
}
