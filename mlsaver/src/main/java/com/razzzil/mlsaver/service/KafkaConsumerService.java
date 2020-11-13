package com.razzzil.mlsaver.service;

import com.razzzil.mldto.KazanApiResponseModel;
import com.razzzil.mlsaver.repositry.KazanBusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumerService {

    @Autowired
    private KazanBusRepository kazanBusRepository;

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Value("${tracing.enabled}")
    private Boolean tracing;

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "kazanApiResponseModelKafkaListenerContainerFactory", groupId = "${kafka.groupId}")
    public void kazanApi(List<KazanApiResponseModel> models) {
        if (tracing)
            logger.info("Received messages: " + models);
        kazanBusRepository.saveBatch(models);
       // this.greetingLatch.countDown();
    }
}
