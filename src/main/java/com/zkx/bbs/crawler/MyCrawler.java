package com.zkx.bbs.crawler;

import com.zkx.bbs.crawler.entity.ZhihuQuestion;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zkx on 2017/3/16.
 */
@Component
public class MyCrawler extends WebCrawler {
    private static final Pattern FILTERS = Pattern.compile(".*(\\\\.(css|js|gif|jpg|png|mp3|mp3|zip|gz))$");

    ZhihuQuestion zhihuQuestion;

    public MyCrawler() {
        zhihuQuestion = new ZhihuQuestion();
    }

    @Override
    public Object getMyLocalData() {
        return zhihuQuestion;
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        boolean shouldVisit = !FILTERS.matcher(href).matches() && href.startsWith("http://www.ics.uci.edu");
        LoggerFactory.getLogger(MyCrawler.class).info(shouldVisit + "");
        return shouldVisit;
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println(url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            String title = "未找到";
            Pattern titlePattern;
            Matcher matcher;
            titlePattern = Pattern.compile("(<title>\\n*)([\\w\\s\\u4E00-\\u9FA5]*)[\\n\\t]*");
            matcher = titlePattern.matcher(html);
            if (matcher.find()) {
                title = matcher.group(2);
            }
            String[] urlArr = url.split("/");
            zhihuQuestion.setQuestionId(Integer.valueOf(urlArr[urlArr.length - 1]));
            zhihuQuestion.setQuestion(title);
            zhihuQuestion.setUrl(url);

            System.out.println("Title: " + title);

//            String[] temp = url.split("/");
//            String id = temp[temp.length - 1];
//            try {
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file_" + ".csv", true));
//                bufferedWriter.write(id + ": " + title + "\n");
//                bufferedWriter.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
