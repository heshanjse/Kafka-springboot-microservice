package org.hesh.springboot;

import org.hesh.springboot.entity.WikiData;
import org.hesh.springboot.repository.WikiDataRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDbConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDbConsumer.class);

    private WikiDataRespository dataRespository;

    public KafkaDbConsumer(WikiDataRespository dataRespository) {
        this.dataRespository = dataRespository;
    }

    @KafkaListener(topics = "wiki_recentchange" , groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
        WikiData wikiData = new WikiData();
        wikiData.setWikiEventData(eventMessage);

        dataRespository.save(wikiData);
    }

}
