package com.kuaizhan.utils;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * rabbitMq操作工具类
 * Created by zixiong on 2017/3/23.
 */
@Component("mqUtil")
public class MqUtil {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发布消息到mq
     * @param routingKey 消息的routing_key, 与queue name一致
     * @param msgMap  消息的数据，封装到一个HashMap中
     */
    public void publish(String routingKey, HashMap<String, Object> msgMap) {
        rabbitTemplate.convertAndSend(routingKey, msgMap);
    }
}
