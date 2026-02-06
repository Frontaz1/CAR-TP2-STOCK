package com.example.tp2.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class KafkaConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final StockService stockService;

    public KafkaConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "my-first-topic", groupId = "my-first-group")
    public void consume(ConsumerRecord<String, String> record) {
        LOGGER.info("Consumed message: {}", record.value());
        String message = record.value();
        String separateur= " ";
        String[] myArray = message.split(separateur);
        //j'aurais pu garder upsertStock et ajouter devant qte un "-"
        String libelle = myArray[0];
        int qte = Integer.parseInt(myArray[1]);
        stockService.DeleteStock(libelle, qte);
    }
}