import helper.OutputHelper;
import service.*;
import org.springframework.web.client.RestTemplate;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]) throws InterruptedException {
        OutputService outputService = new OutputService();
        RestTemplate restTemplate = new RestTemplate();
        OutputHelper outputHelper = new OutputHelper();
        HistoryService historyService = new HistoryService();

        Service service = new Service(outputService, restTemplate, outputHelper);
        InputService inputService = new InputService(outputHelper, historyService, outputService);

        Thread serviceThread = new Thread(service);
        serviceThread.start();

        Thread inputServiceThread = new Thread(inputService);
        inputServiceThread.start();

        Thread historyServiceThread = new Thread(historyService);
        historyServiceThread.start();

    }
}
