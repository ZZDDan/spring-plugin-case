package com.rxx.activemq.client;

import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by zhang on 2017/9/19.
 * 这是消费者代码，这里你可以创建多个XML文件，模拟多个消费者
 */
public class JmsTopicReceiver {
    public static void main(String[] args){
        //加载消费者监听
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext-ActiveMQ.xml");
        //写个死循环
        while(true){}
    }
}