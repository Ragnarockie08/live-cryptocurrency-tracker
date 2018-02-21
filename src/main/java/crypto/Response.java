package crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private static List<CryptoCurrnecy> cryptoCurrnecy;

    public Response() {
    }

    public static List<CryptoCurrnecy> getCryptoCurrnecy() {
        return cryptoCurrnecy;
    }

}
