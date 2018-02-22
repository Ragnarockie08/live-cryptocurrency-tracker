package service;

import crypto.CryptoCurrency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Service implements Runnable {

    private OutputService outputService;
    private RestTemplate restTemplate;
    private static List<CryptoCurrency> currentResponse = new ArrayList<>();

    public Service(OutputService outputService, RestTemplate restTemplate) {
        this.outputService = outputService;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            try{
                getResponse();
                outputService.printTable(InputService.getObservedCurrencies());
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.out.println("Data loading service error");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void getResponse() {

        ResponseEntity<CryptoCurrency[]> response = restTemplate
                .getForEntity("https://api.coinmarketcap.com/v1/ticker/", CryptoCurrency[].class);

        clearScreen();

        currentResponse = Arrays.asList(response.getBody());
    }

    static List<CryptoCurrency> getCurrentResponse() {
        return currentResponse;
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
