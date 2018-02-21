import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrency {

    private Long id;
    private URL url;
    private URL imageUrl;
    private String name;
    private String symbol;
    private String coinName;
    private String fullName;
    private String algorithm;
    private String proofType;
    private int follyPremined;
    private long totalCoinSupply;
    private String preMinedValue;
    private String totalCoinsFreeFloat;
    private int sortOrder;
    private boolean sponsored;

    public CryptoCurrency() {
    }
}
