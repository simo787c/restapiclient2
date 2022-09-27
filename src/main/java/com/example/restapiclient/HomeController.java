package com.example.restapiclient;

import com.example.restapiclient.model.Flag;
import com.example.restapiclient.model.FlagRequest;
import com.example.restapiclient.service.ApiService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
public class HomeController {
    private ApiService apiService;

    public HomeController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping("/virkerDen")
    public ResponseEntity<String> virkerDen(){
        return new ResponseEntity<>("Ja, den gør", HttpStatus.OK);
    }

    @PostMapping("/findFlag")
    public ResponseEntity<Flag> findFlag(@RequestBody FlagRequest flagRequest){
        System.out.println("findFlag called");
        flagRequest.setRequest(" At Simon N " + flagRequest.getRequest());
        Flag flag = apiService.requestFlag(flagRequest);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
