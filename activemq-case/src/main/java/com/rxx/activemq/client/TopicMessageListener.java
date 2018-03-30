package com.rxx.activemq.client;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author xiefg
 * @create 2017-09-11 16:35
 * @desc
 **/
public class TopicMessageListener implements MessageListener {

    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public void onMessage(Message message) {

        System.out.println("topic收到的消息："+message);
        TextMessage textmessage = (TextMessage)message;
        try {
            logger.info("message："+textmessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
