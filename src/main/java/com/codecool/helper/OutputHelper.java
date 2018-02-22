package com.codecool.helper;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
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
