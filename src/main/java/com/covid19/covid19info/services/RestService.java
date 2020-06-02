package com.covid19.covid19info.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    public RestService() {
        this.restTemplate = new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate() {
        return this.restTemplate;
    }
}
