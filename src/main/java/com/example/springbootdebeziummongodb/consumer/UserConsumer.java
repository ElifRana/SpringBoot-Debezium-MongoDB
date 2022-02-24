package com.example.springbootdebeziummongodb.consumer;

import com.example.springbootdebeziummongodb.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserConsumer {

    //ObjectMapper: JSON okuma ve yazma işlevlerinin yanı sıra dönüştürmeleri gerçekleştirmek için ilgili işlevsellik sağlar

    final ObjectMapper objectMapper;

    @KafkaListener(topics = "data.cdc.mongo_example")
    public void consumeUser(ConsumerRecord<String, String> record) throws JsonProcessingException {

        String consumedValue = record.value();

        var jsonNode = objectMapper.readTree(consumedValue);
        JsonNode payload = jsonNode.path("payload");
        JsonNode after = payload.path("after");

        String userString = after.toString();
        User user = objectMapper.readValue(userString, User.class);


    }
}
