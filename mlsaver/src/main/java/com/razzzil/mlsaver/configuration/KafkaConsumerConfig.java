package com.razzzil.mlsaver.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.razzzil.mldto.KazanApiResponseModel;
import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableKafka
@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConsumerConfig {

    private String bootstrapAddress;
    private String groupApi;

    public ConsumerFactory<String, List<KazanApiResponseModel>> kazanApiResponseModelConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupApi);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new KazanApiDeserializer());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, List<KazanApiResponseModel>> kazanApiResponseModelKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, List<KazanApiResponseModel>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kazanApiResponseModelConsumerFactory());
        return factory;
    }
}
