package helper;

import java.util.Scanner;

public class OutputHelper {

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getInput(){

        String input;
        Scanner scanner;

        scanner = new Scanner(System.in);
        input = scanner.nextLine();

        return input;
    }
}
