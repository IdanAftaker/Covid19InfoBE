package com.covid19.covid19info.controllers;

import com.covid19.covid19info.models.Country;
import com.covid19.covid19info.models.Summary;
import com.covid19.covid19info.services.Covid19DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private Covid19DataService dataService;

    @GetMapping("/summary")
    public ResponseEntity<Summary> getSummary() {
        return dataService.getSummary();
    }

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries() {
        return dataService.getCountries();
    }


}
