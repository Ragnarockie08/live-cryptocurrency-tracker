import service.HistoryService;
import service.InputService;
import org.springframework.web.client.RestTemplate;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]) {
        OutputService outputService = new OutputService();
        RestTemplate restTemplate = new RestTemplate();
        new Thread(new Service( outputService, restTemplate)).start();
        new Thread(new InputService()).start();
        new Thread(new HistoryService()).start();
    }
}

