package com.covid19.covid19info.services;

import com.covid19.covid19info.models.Country;
import com.covid19.covid19info.models.Summary;
import com.covid19.covid19info.repositories.CountriesRepository;
import com.covid19.covid19info.repositories.SummaryRepository;
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

    @Autowired
    SummaryRepository summaryRepository;

    @Autowired
    CountriesRepository countriesRepository;

    public ResponseEntity<Summary> getSummary() {
        return ResponseEntity.ok(summaryRepository.findTopByOrderByIdDesc());
    }

    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.ok(countriesRepository.findAll());
    }


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() {
        ResponseEntity<String> responseData = restService.restTemplate().getForEntity(URL, String.class);
        try {
            this.jsonData = Mapper.readTree(Objects.requireNonNull(responseData.getBody()));
            populateData();
        } catch (JsonProcessingException e) {
            LOG.error("Can't fetch data!");
        }
    }

    private void populateData() {
        //populate summary
        JsonNode node = jsonData.get("Global");
        summaryRepository.save(Mapper.convertValue(node, Summary.class));
        LOG.error("summary data populated");

        //populate countries
        node = jsonData.get("Countries");
        node.forEach(country -> countriesRepository.save(Mapper.convertValue(country, Country.class)));
        LOG.error("countries data populated");
    }
}
