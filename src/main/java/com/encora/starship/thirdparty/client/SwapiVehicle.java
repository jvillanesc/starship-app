package com.encora.starship.thirdparty.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SwapiVehicle {

    String name;
    String model;
    String manufacturer;

}
