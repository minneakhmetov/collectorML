package com.razzzil.mlsaver.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.razzzil.mldto.KazanApiResponseModel;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class KazanApiDeserializer extends JsonDeserializer<List<KazanApiResponseModel>> {

    @Override
    public List<KazanApiResponseModel> deserialize(String topic, Headers headers, byte[] data) {
        return deserialize(topic, data);
    }

    @Override
    public List<KazanApiResponseModel> deserialize(String topic, byte[] data) {
        if (Objects.isNull(data)) {
            return null;
        }
        try {
            return objectMapper.readValue(data, new TypeReference<List<KazanApiResponseModel>>() {});
        } catch (IOException e) {
            throw new SerializationException("Can't deserialize data [" + Arrays.toString(data) +
                    "] from topic [" + topic + "]", e);
        }
    }
}
