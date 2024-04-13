package com.encora.starship.thirdparty;

import com.encora.starship.thirdparty.client.SwapiClientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;


@ReactiveFeignClient(
        name = "swapi-client",
        url = "${swapi-client.urls.base-url}"
)
public interface SwapiClient {
    @GetMapping(value = "${swapi-client.urls.get-vehicles-url}", headers = {"Content-Type=application/json"})
    Mono<SwapiClientResponse> getVehicles();

}
