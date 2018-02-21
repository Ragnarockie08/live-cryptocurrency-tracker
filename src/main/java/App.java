import org.springframework.web.client.RestTemplate;
import service.OutputService;
import service.Service;

public class App {

    public static void main(String args[]) {
        OutputService outputService = new OutputService();
        RestTemplate restTemplate = new RestTemplate();
        Service service = new Service( outputService, restTemplate );

        Thread thread = new Thread(service);
        thread.start();
    }
}

