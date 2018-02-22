import helper.OutputHelper;
import service.*;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]){
        OutputService outputService = new OutputService();
        OutputHelper outputHelper = new OutputHelper();
        HistoryService historyService = new HistoryService();
        InputService inputService = new InputService(outputHelper, historyService, outputService);
        Service service = new Service(outputService, outputHelper, inputService);


        Thread serviceThread = new Thread(service);
        serviceThread.start();

        Thread inputServiceThread = new Thread(inputService);
        inputServiceThread.start();

        Thread historyServiceThread = new Thread(historyService);
        historyServiceThread.start();

    }
}
