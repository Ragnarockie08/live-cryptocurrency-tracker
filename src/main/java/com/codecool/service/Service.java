package com.codecool.service;

import com.codecool.model.CryptoCurrency;
import com.codecool.helper.OutputHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component
public class Service implements Runnable {

    private OutputService outputService;
    private RestTemplate restTemplate;
    private OutputHelper outputHelper;
    private InputService inputService;
    private static boolean isRunning = true;
    private static List<CryptoCurrency> currentResponse = new ArrayList<>();

    public Service(OutputService outputService, OutputHelper outputHelper, InputService inputService) {
        this.outputService = outputService;
        this.restTemplate = new RestTemplate();
        this.outputHelper = outputHelper;
        this.inputService = inputService;
    }

    @Override
    public void run(){

        synchronized (Thread.currentThread()){
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    if (!isRunning) {
                        Thread.currentThread().wait();
                    }
                    getResponse();
                    outputService.printTable(inputService.refreshList());
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    System.out.println("Data loading service error");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void getResponse() {

        ResponseEntity<CryptoCurrency[]> response = restTemplate
                .getForEntity("https://api.coinmarketcap.com/v1/ticker/", CryptoCurrency[].class);

        outputHelper.clearScreen();
        currentResponse = Arrays.asList(response.getBody());
    }

    static List<CryptoCurrency> getCurrentResponse() {
        return currentResponse;
    }

    public static void setIsRunning(boolean isRunning) {
        Service.isRunning = isRunning;
    }

    public static boolean isRunning() {
        return isRunning;
    }
}
