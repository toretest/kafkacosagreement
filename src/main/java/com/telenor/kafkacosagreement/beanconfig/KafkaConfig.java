package com.telenor.kafkacosagreement.beanconfig;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.telenor.kafkacosagreement.models.Hallo;
import com.telenor.kafkacosagreement.models.ProductOffer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    String BOOT_STRAP_SERVER_CONFIG="127.0.0.1:9092";

    @Bean
    public ProducerFactory<String, Hallo> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOT_STRAP_SERVER_CONFIG);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializable.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Hallo> kafkaAgreementOfferTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
