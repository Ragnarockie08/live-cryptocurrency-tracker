package com.codecool;

import com.codecool.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.codecool.service.Service;

public class App {

    public static void main(String args[]){

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HistoryService historyService = context.getBean(HistoryService.class);
        InputService inputService = context.getBean(InputService.class);
        Service service = context.getBean(Service.class);


        Thread serviceThread = new Thread(service);
        serviceThread.start();

        Thread inputServiceThread = new Thread(inputService);
        inputServiceThread.start();

        Thread historyServiceThread = new Thread(historyService);
        historyServiceThread.start();

        ThreadService threadService = new ThreadService(serviceThread, inputServiceThread, historyServiceThread);

        inputService.setThreadService(threadService);

    }
}
