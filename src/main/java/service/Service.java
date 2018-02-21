package service;

import crypto.CryptoCurrnecy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;

public class Service implements Runnable {

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            try{
                handleTracking();
                Thread.sleep(10000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void handleTracking(){

        String url = "https://api.coinmarketcap.com/v1/ticker/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptoCurrnecy[]> response = restTemplate.getForEntity(url, CryptoCurrnecy[].class);
    }



}
