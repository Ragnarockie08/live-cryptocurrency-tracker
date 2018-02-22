import service.*;
import org.springframework.web.client.RestTemplate;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]) throws InterruptedException {
        OutputService outputService = new OutputService();
        RestTemplate restTemplate = new RestTemplate();
        Service service = new Service(outputService, restTemplate);
        InputService inputService = new InputService();
        HistoryService historyService = new HistoryService();

        Thread serviceThread = new Thread(service);
        serviceThread.start();

        Thread inputServiceThread = new Thread(inputService);
        inputServiceThread.start();

        Thread historyServiceThread = new Thread(historyService);
        historyServiceThread.start();
    }
}

