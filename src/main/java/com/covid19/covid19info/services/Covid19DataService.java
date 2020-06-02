package com.covid19.covid19info.services;

import com.covid19.covid19info.models.Country;
import com.covid19.covid19info.models.Summary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class Covid19DataService {
    private static final Logger LOG = LoggerFactory.getLogger(Covid19DataService.class);
    final private ObjectMapper Mapper = new ObjectMapper();
    private JsonNode jsonData;

    @Value("${fetch.data.url}")
    private String URL;

    @Autowired
    private RestService restService;

    public ResponseEntity<Summary> getSummary() {
        JsonNode node = jsonData.get("Global");
        Summary summary = Mapper.convertValue(node, Summary.class);
        return ResponseEntity.ok(summary);
    }

    public ResponseEntity<List<Country>> getCountries(){
        JsonNode nodes = jsonData.get("Countries");
        List<Country> countries = new ArrayList<>();
        nodes.forEach( country -> {
            Country c = Mapper.convertValue(country, Country.class);
            countries.add(c);
        });
        return ResponseEntity.ok(countries);
    }


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() {
        ResponseEntity<String> responseData = restService.restTemplate().getForEntity(URL, String.class);
        try {
            this.jsonData = Mapper.readTree(Objects.requireNonNull(responseData.getBody()));
        } catch (JsonProcessingException e) {
            LOG.error("Can't fetch data!");
        }
    }
}
