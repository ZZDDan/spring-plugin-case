package com.rxx.activemq.server;

import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by zhang on 2017/9/19.
 */
public class HelloSender {

    /**
     * @param args
     * jmsTemplate和destination都是在spring配置文件中进行配制的
     * Sender只使用了配置文件中的jmsFactory，jmsTemplate，还有destination这三个属性
     */
    public static void main(String[] args) {
        sendMsg("发送消息：Hello ActiveMQ Text Message2！");
    }

    public static void sendMsg(String msg) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext-ActiveMQ.xml");
        JmsTemplate template = (JmsTemplate) applicationContext.getBean("jmsTemplate");
        template.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        System.out.println("成功发送了一条JMS消息");
    }

}
