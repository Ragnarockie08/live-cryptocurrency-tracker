import helper.OutputHelper;
import service.*;
import org.springframework.web.client.RestTemplate;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]) {
        OutputService outputService = new OutputService();
        RestTemplate restTemplate = new RestTemplate();
        OutputHelper outputHelper = new OutputHelper();
        Service service = new Service(outputService, restTemplate, outputHelper);
        HistoryService historyService = new HistoryService();
        InputService inputService = new InputService(outputHelper, historyService, outputService);

        new Thread(service).start();
        new Thread(inputService).start();
        new Thread(historyService).start();
    }
}
