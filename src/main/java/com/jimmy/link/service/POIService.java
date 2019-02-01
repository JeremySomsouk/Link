package com.jimmy.link.service;

import com.jimmy.link.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class POIService {

    private Map<String, Integer> bigFilePositions;
    private Map<String, Integer> tinyFilePositions;

    @Autowired
    public POIService(Map<String, Integer> bigFilePositions, Map<String, Integer> tinyFilePositions) {
        this.bigFilePositions = bigFilePositions;
        this.tinyFilePositions = tinyFilePositions;
    }

    public String getPOIs(double lon, double lat) {
        String key = Position.getCounterKey(lon, lat);
        return tinyFilePositions.get(key).toString();
    }

    public List<String> getDensestPOIs(int topNumbers) {

        List<String> poiList = new ArrayList<>();

        int i = 0;
        for (Map.Entry<String, Integer> entry : tinyFilePositions.entrySet()) {
            String[] lonLat = entry.getKey().split("\\|");
            String minLon = lonLat[0];
            String maxLon = Double.toString(Double.parseDouble(minLon) + 0.5f);
            String minLat = lonLat[1];
            String maxLat = Double.toString(Double.parseDouble(minLat) + 0.5f);
            poiList.add(String.format("[min_lat: %s; max_lat: %s; min_lon: %s; max_lon: %s]", minLat, maxLat, minLon, maxLon));

            if (++i == topNumbers) {
                break;
            }
        }

        return  poiList;
    }
}