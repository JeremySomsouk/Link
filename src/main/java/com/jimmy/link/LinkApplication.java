package com.jimmy.link;

import com.jimmy.link.model.Position;
import com.jimmy.link.utils.TsvParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

import static java.util.stream.Collectors.toMap;

@SpringBootApplication
public class LinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkApplication.class, args);
    }

    @Bean
    public Map<String, Integer> exampleFilePositionsWeight() {
        TsvParser tsvParser = new TsvParser();
        List<Position> positions = tsvParser.parseFileToPositionList("/example.csv");

        Map<String, Integer> poiCounters = new HashMap<>();

        for (Position position : positions) {
            /* if key do not exists, put 1 as value, otherwise sum 1 to the value linked to key */
            poiCounters.merge(position.getCounterKey(), 1, Integer::sum);
        }

        poiCounters = getSortedDecreasingMap(poiCounters);
        return poiCounters;
    }

    private Map<String, Integer> getSortedDecreasingMap(Map<String, Integer> poiCounters) {
        poiCounters = poiCounters
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        return poiCounters;
    }
}

