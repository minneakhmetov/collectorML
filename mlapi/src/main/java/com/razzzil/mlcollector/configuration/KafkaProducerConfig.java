//package com.razzzil.mlcollector.configuration;
//
//import com.razzzil.mldto.KazanApiResponseModel;
//import lombok.Data;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//@ConfigurationProperties(prefix = "kafka")
//@ConditionalOnProperty("kafka.enabled")
//@Data
//public class KafkaProducerConfig {
//
//    private String bootstrapAddress;
//
//    @Bean
//    public ProducerFactory<String, List<KazanApiResponseModel>> kazanApiResponseProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, List<KazanApiResponseModel>> kazanApiResponseKafkaTemplate() {
//        return new KafkaTemplate<>(kazanApiResponseProducerFactory());
//    }
//}
//
