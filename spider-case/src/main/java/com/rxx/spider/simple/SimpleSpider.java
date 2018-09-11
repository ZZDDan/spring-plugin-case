package com.rxx.spider.simple;

import com.rxx.spider.util.HttpClientUtil;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/9/11 16:55
 */
public class SimpleSpider {

    private static final Logger logger = Logger.getLogger(SimpleSpider.class);
    private static String url = "https://gitee.com/explore?page=1";

    public static void main(String[] args) {
        // 爬取
        String pageData= HttpClientUtil.httpGet(url);
        logger.info("\n=================================> 原始文件：\n" + pageData);

        // 解析
        Document document= new Document(url);
        document.html(pageData);
        Elements elements = document.select("#git-discover-list .item");

        int count = 1;
        for(Element e:elements){
            String title = e.select(".title").text();
            String projectDesc = e.select(".project-desc").text();
            String timeago = e.select(".timeago").text();
            String lang = e.select(".project-meta>a:eq(0)").text();

            // 打印
            logger.info("\nNo." + count++ +
                    "\n\ttitle:" + title +
                    "\n\tprojectDesc:" + projectDesc +
                    "\n\ttimeago:" + timeago +
                    "\n\tlang:" + lang);
        }
    }
}
