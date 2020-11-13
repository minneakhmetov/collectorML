package com.razzzil.mlcollector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.razzzil.mlcollector.repositry.KazanBusRepository;
import com.razzzil.mldto.KazanApiResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
public class MainService {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Value("${tracing.enabled}")
    private Boolean tracing;

    @Autowired
    private KazanBusRepository kazanBusRepository;

    @Autowired
    private KazanApiService kazanApiService;

    private Logger logger = LoggerFactory.getLogger(MainService.class);

    @Scheduled(cron = "0/30 * * * * *")
    public void execute() {
        try {
            List<KazanApiResponseModel> kazanApiResponseModels = kazanApiService.getModels();
            if (tracing)
                logger.info("Retrieved :" + kazanApiResponseModels);
            kazanBusRepository.saveBatch(kazanApiResponseModels);
        } catch (JsonProcessingException | NullPointerException e) {
            logger.error("Error with executing response", e);
        } catch (RestClientException restClientException ) {
            logger.warn("API is not available");
        }
    }


}
