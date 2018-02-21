package crypto;



import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<CryptoCurrnecy> cryptoCurrnecy;

    public Response(List<CryptoCurrnecy> objects) {
        this.cryptoCurrnecy = objects;
    }

    public List<CryptoCurrnecy> getCryptoCurrnecy() {
        return cryptoCurrnecy;
    }

}
