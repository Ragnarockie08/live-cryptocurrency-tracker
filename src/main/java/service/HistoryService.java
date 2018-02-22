package service;

import crypto.CryptoCurrency;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryService implements Runnable {

    private Map<String, List<CryptoCurrency>> history;

    public HistoryService(){
        history = new HashMap<>();
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                addToHistory();
                Thread.sleep(360000);
            } catch (InterruptedException e){
                System.out.println("History service error");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void addToHistory(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd")
                                 .format(Calendar.getInstance()
                                 .getTime());
        history.put( timeStamp, Service.getCurrentResponse());

    }

    public Map<String, List<CryptoCurrency>> getHistory(){
        return history;
    }
}
