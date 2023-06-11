package com.example.atipera.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class GithubUserConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
