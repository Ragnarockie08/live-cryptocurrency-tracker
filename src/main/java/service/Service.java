package service;

import crypto.CryptoCurrnecy;
import crypto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service implements Runnable {

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            try{
                getObjects();
                Thread.sleep(10000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public void getObjects() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptoCurrnecy[]> response = restTemplate.getForEntity(
                "https://api.coinmarketcap.com/v1/ticker/", CryptoCurrnecy[].class);

        Response currentObjects = new Response(Arrays.asList(response.getBody()));
    }
}
