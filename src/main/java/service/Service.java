package service;

import crypto.CryptoCurrency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Service implements Runnable {

    private OutputService outputService;
    private RestTemplate restTemplate;
    private static List<CryptoCurrency> currentResponse = new ArrayList<>(  );

    public Service(OutputService outputService, RestTemplate restTemplate) {
        this.outputService = outputService;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            try{
                getResponse();
                this.outputService.printTable(currentResponse);
                Thread.sleep(10000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void getResponse() {

        ResponseEntity<CryptoCurrency[]> response = restTemplate.getForEntity(
                "https://api.coinmarketcap.com/v1/ticker/", CryptoCurrency[].class);

        currentResponse = Arrays.asList(response.getBody());
    }
}
