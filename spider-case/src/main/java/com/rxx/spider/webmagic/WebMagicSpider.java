package com.rxx.spider.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

import javax.management.JMException;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/9/11 18:17
 */
public class WebMagicSpider {

    public static void main(String[] args) throws JMException {
        Spider spider = Spider.create(new GithubRepoPageProcessor())
                //从https://github.com/code4craft开始抓
                .addUrl("https://github.com/code4craft")
                //设置Scheduler，使用Redis来管理URL队列，默认使用
//                .setScheduler(new RedisScheduler("localhost"))
                //设置Pipeline，将结果以json方式保存到文件
                .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                //开启5个线程同时执行
                .thread(5);

        // 监控爬虫
        SpiderMonitor.instance().register(spider);

        //启动爬虫
        spider.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        spider.stop();
    }
}
