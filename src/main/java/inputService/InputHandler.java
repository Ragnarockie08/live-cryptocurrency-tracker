package inputService;

import crypto.CryptoCurrency;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler implements Runnable {

    private List<CryptoCurrency> observedCurrencies;

    public InputHandler() {
        this.observedCurrencies = new ArrayList<>();
    }

    @Override
    public void run() {

        String action = "";

        while(!(Thread.currentThread().isInterrupted() || action.equals(Action.EXIT.getValue()))){
            action = getInput();
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
        } else if (action.equals(Action.CHECK)){
            runCheck();
        }
    }

    private void runSelect(String[] args){

        String symbol;

        if (args.length > 1){
            symbol = args[1];
            for (CryptoCurrency currency: Service.getCurrentResponse())
                if (currency.getSymbol().equals(symbol)){
                    observedCurrencies.add(currency);
                }
        }
    }

    private void runCheck(){

        if (!observedCurrencies.isEmpty()){
            System.out.println("display");
        }
    }

    private String getInput(){

        String input;
        Scanner scanner;

        scanner = new Scanner(System.in);
        System.out.println("Command:\n");
        input = scanner.nextLine();

        return input;
    }





}
