package service;

import crypto.CryptoCurrency;
import helper.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputService implements Runnable {

    private static List<CryptoCurrency> observedCurrencies = new ArrayList<>();
    private volatile boolean run;

    public InputService(){
        run = true;
    }

    @Override
    public void run() {

        String action = "";

        while(isRunning()){
            action = getInput();
            if (action.equals(Action.EXIT.getValue())){
                stopApp();
            }
            try {
                checkInput(action);
            } catch (NullPointerException e){
                System.out.println("\nThere is no such command.");
            }
        }
    }

    private void checkInput(String input) throws NullPointerException{

        String[] args = input.split(" +");
        Action action = Action.getInstance(args[0]);

        if (action.equals(Action.SELECT)) {
            runSelect(args);
        }
    }

    private void runSelect(String[] args){

        String symbol;

        if (args.length > 1) {
            symbol = args[1];
            for (CryptoCurrency currency : Service.getCurrentResponse()) {
                if (currency.getSymbol().equals(symbol) && !observedCurrencies.contains(currency)) {
                    observedCurrencies.add(currency);
                }
            }
        }
    }

    private boolean isRunning(){
        return run;
    }

    private void stopApp(){
        run = false;
    }

    private String getInput(){

        String input;
        Scanner scanner;

        scanner = new Scanner(System.in);
        input = scanner.nextLine();

        return input;
    }

    public static List<CryptoCurrency> getObservedCurrencies() {
        return observedCurrencies;
    }
}
