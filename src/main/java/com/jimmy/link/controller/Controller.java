package com.jimmy.link.controller;

import com.jimmy.link.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private POIService poiService;

    @GetMapping("/poi")
    public String getPois(@RequestParam("lon") double lon, @RequestParam("lat") double lat) {
        return poiService.getPOIs(lon, lat);
    }

    @GetMapping("/poi/densest/{top}")
    public List<String> getDensestPois(@PathVariable("top") int topNumbers) {
        return poiService.getDensestPOIs(topNumbers);
    }
}
