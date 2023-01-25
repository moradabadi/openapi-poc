package com.moradabadi.poc;


import com.moradabadi.poc.api.SampleApi;
import com.moradabadi.poc.api.model.SampleRequestDto;
import com.moradabadi.poc.api.model.SampleResponseDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @RestController
    public static class MySampleController implements SampleApi {

        @Override
        public Mono<ResponseEntity<SampleResponseDto>> createSample(Mono<SampleRequestDto> sampleRequestDto, ServerWebExchange exchange) {
            return Mono.just(ResponseEntity.ok().build());
        }

        @Override
        public Mono<ResponseEntity<SampleResponseDto>> getSample(ServerWebExchange exchange) {
            return Mono.just(ResponseEntity.ok(
                    SampleResponseDto.builder()
                            .id(UUID.randomUUID().toString())
                            .build()
            ));
        }
    }
}
