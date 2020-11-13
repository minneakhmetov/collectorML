package com.razzzil.mlcollector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.razzzil.mldto.KazanApiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class KazanApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${kazan.api.url}")
    private String apiUrl;

    public List<KazanApiResponseModel> getModels() throws JsonProcessingException, RestClientException, NullPointerException {
        ResponseEntity<String> rateResponse =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
        return objectMapper.readValue(Objects.requireNonNull(rateResponse.getBody()),
                new TypeReference<List<KazanApiResponseModel>>() {});
    }



}
