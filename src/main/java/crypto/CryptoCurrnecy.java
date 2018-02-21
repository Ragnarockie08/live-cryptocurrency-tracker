package crypto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrnecy implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private double name;

    public CryptoCurrnecy(){

    }

    public String toString(){
        return "example.CryptoCurrency{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                '}';
    }



}
