package crypto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrency implements Serializable {

    private String id;
    private String name;
    private String symbol;
    private int rank;
    @JsonProperty("price_usd")
    private String priceUsd;
    @JsonProperty("price_btc")
    private String priceBtc;
    @JsonProperty("24h_volume_usd")
    private String VolumeUsd24;
    @JsonProperty("market_cap_usd")
    private String marketCapUsd;
    @JsonProperty("available_supply")
    private String availableSupply;
    @JsonProperty("total_supply")
    private String totalSupply;
    @JsonProperty("max_supply")
    private String maxSupply;
    @JsonProperty("percent_change_1h")
    private String percent1;
    @JsonProperty("percent_change_24h")
    private String percent24;
    @JsonProperty("percent_change_7d")
    private String percent7d;
    @JsonProperty("last_updated")
    private String lastUpdate;

    public CryptoCurrency(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String getVolumeUsd24() {
        return VolumeUsd24;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public String getPercent1() {
        return percent1;
    }

    public String getPercent24() {
        return percent24;
    }

    public String getPercent7d() {
        return percent7d;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
