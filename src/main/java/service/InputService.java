package service;


import crypto.CryptoCurrency;
import helper.Action;
import helper.OutputHelper;

import java.util.ArrayList;
import java.util.List;

public class InputService implements Runnable {

    private List<String> observedCurrencies = new ArrayList<>();
    private OutputHelper outputHelper;
    private HistoryService historyService;
    private OutputService outputService;


    public InputService(OutputHelper outputHelper, HistoryService historyService, OutputService outputService){

        this.outputHelper = outputHelper;
        this.historyService = historyService;
        this.outputService = outputService;
    }

    @Override
    public void run() {

        String action = "";

        while(!action.equals(Action.EXIT.getValue())){
            action = outputHelper.getInput();
            Service.setIsRunning(true);
            try {
                checkInput(action);
            } catch (NullPointerException e) {
                System.out.println("\nThere is no such command.");
            }
        }
        stopApp();
    }

    private void checkInput(String input) throws NullPointerException{

        String[] args = input.split(" +");
        Action action = Action.getInstance(args[0]);
        if (action.equals(Action.SELECT)) {
            runSelect(args);
        } else if (action.equals(Action.SORT)){
            runSort(args);
        } else if (action.equals(Action.HISTORY)){
            runHistory(args);
        }
    }

    private void runSelect(String[] args){

        String symbol;

        if (args.length > 1) {
            symbol = args[1];
            for (CryptoCurrency currency : Service.getCurrentResponse()) {
                if (currency.getSymbol().equals(symbol) && !observedCurrencies.contains(currency.getSymbol())) {
                    observedCurrencies.add(currency.getSymbol());
                }
            }
        }
    }

    private void runSort(String[] args){

        String columnNum;

        if (args.length > 1){
            columnNum = args[1];
            if (columnNum.matches("^[0-9]$|^10$|^11$|^12$")){
                OutputService.setColumnNumberToSortBy(Integer.valueOf(columnNum));
            }
        }
    }

    private void runHistory(String[] args){

        String date;
        Service.setIsRunning(false);

        if (args.length > 1) {
            date = args[1];
            if (historyService.getHistory().keySet().contains(date)) {
                outputService.printTable(historyService.getHistory().get(date));
            }
        }
    }

    private void stopApp(){
        System.exit(0);
    }

    public List<CryptoCurrency> refreshList(){

        List<CryptoCurrency> currentCurrency = new ArrayList<>();
        for (CryptoCurrency responseCurrency: Service.getCurrentResponse()) {
            if (observedCurrencies.contains(responseCurrency.getSymbol())){
                currentCurrency.add(responseCurrency);
            }
        }
        return currentCurrency;
    }
}
