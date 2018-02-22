package com.codecool.service;

public class ThreadService {

    private Thread serviceThread;
    private Thread inputThread;
    private Thread historyThread;

    public ThreadService(Thread serviceThread, Thread inputThread, Thread historyThread){
        this.serviceThread = serviceThread;
        this.inputThread = inputThread;
        this.historyThread = historyThread;
    }

    public synchronized void notifyService(){
        Service.setIsRunning(true);
        serviceThread.notify();
    }

    public Thread getServiceThread() {
        return serviceThread;
    }

    public Thread getInputThread() {
        return inputThread;
    }

    public Thread getHistoryThread() {
        return historyThread;
    }
}
