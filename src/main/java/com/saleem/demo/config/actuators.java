package com.saleem.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Endpoint(id="features")
public class actuators {


    private Map< String,Feature> featureMap= new ConcurrentHashMap<>();

    public actuators(){
        featureMap.put("game",new Feature(true));
        featureMap.put("security",new Feature(false));
        featureMap.put("cloud",new Feature(true));
    }
    @ReadOperation
    public Map<String,Feature> getFeatureMap(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String dept){
        return featureMap.get(dept);
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private  Boolean isEnabled;

    }
}
