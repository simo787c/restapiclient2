package com.example.restapiclient.service;

import com.example.restapiclient.model.Flag;
import com.example.restapiclient.model.FlagRequest;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    final String API = "http://localhost:8081/findFlag"; // find ud  af, hvilket IP + port
    RestTemplate restTemplate = new RestTemplate();
    public Flag requestFlag(FlagRequest req) {
        System.out.println("sending request...");
        JsonNode jsonNode = restTemplate.postForObject(API, req, JsonNode.class);
        System.out.println("received ansver " + jsonNode.get("message"));
        Flag flag = new Flag();
        flag.setMessage(jsonNode.get("message").toString());
        return flag;
    }
}
