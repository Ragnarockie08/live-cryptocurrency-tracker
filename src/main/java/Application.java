import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Data data = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Data.class);
        log.info(currencyList.toString());
    }

}