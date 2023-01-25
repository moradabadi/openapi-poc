package com.moradabadi.poc;

import com.moradabadi.poc.api.SampleApi;
import com.moradabadi.poc.api.model.SampleRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Component
    public static class MyTestComponent {
        @Autowired
        private SampleApi sampleApi;

        @PostConstruct
        private void postConstruct() {
            sampleApi.createSample(
                    new SampleRequest()
                            .firstName("test")
                            .provider(SampleRequest.ProviderEnum.FACEBOOK)
            );

            System.out.println(sampleApi.getSample());
        }
    }
}
