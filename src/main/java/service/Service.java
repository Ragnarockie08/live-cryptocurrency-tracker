package service;

import crypto.CryptoCurrency;
import helper.OutputHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.*;

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

        while(!Thread.currentThread().isInterrupted()){
            if (!isRunning){
                continue;
            }
            try{
                getResponse();
                outputService.printTable(inputService.refreshList());
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

        outputHelper.clearScreen();
        currentResponse = Arrays.asList(response.getBody());
    }

    static List<CryptoCurrency> getCurrentResponse() {
        return currentResponse;
    }

    public static void setIsRunning(boolean isRunning) {
        Service.isRunning = isRunning;
    }
}
