package com.curso_kafka.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler{

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("Exception Handler ::: error"); 
        log.info("Payload ::: {}", message.getPayload());
        log.info("Header ::: {}", message.getHeaders());
        log.info("OffSet ::: {}", message.getHeaders().get("kafka_offset"));
        return null;
    }

}
