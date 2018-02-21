package crypto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrnecy implements Serializable {

    private String id;
    private String name;
    private String symbol;
    private int rank;
    @JsonProperty("price_usd")
    private double priceUsd;
    @JsonProperty("price_btc")
    private double priceBtc;
    @JsonProperty("24h_volume_usd")
    private double VolumeUsd24;
    @JsonProperty("market_cap_usd")
    private double marketCapUsd;
    @JsonProperty("available_supply")
    private double availableSupply;
    @JsonProperty("total_supply")
    private double totalSupply;
    @JsonProperty("max_supply")
    private double maxSupply;
    @JsonProperty("percent_change_1h")
    private double percent1;
    @JsonProperty("percent_change_24h")
    private double percent24;
    @JsonProperty("percent_change_7d")
    private double percent7d;
    @JsonProperty("last_updated")
    private long lastUpdate;

    public CryptoCurrnecy(){

    }

    public String toString(){
        return "example.CryptoCurrency{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                '}';
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

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getPriceBtc() {
        return priceBtc;
    }

    public double getVolumeUsd24() {
        return VolumeUsd24;
    }

    public double getMarketCapUsd() {
        return marketCapUsd;
    }

    public double getAvailableSupply() {
        return availableSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public double getPercent1() {
        return percent1;
    }

    public double getPercent24() {
        return percent24;
    }

    public double getPercent7d() {
        return percent7d;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }
}
