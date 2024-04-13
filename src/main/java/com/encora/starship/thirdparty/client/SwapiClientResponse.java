package com.encora.starship.thirdparty.client;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class SwapiClientResponse {

    private Integer count;
    private String next;
    private Object previous;
    private ArrayList<SwapiVehicle> results;

}
