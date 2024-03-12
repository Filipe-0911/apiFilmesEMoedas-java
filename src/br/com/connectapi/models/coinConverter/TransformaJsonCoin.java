package br.com.connectapi.models.coinConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformaJsonCoin {
    @JsonProperty("base")
    private String base;

    @JsonProperty("rates")
    private TransformaJsonCoin rates;

    @JsonProperty("BRL")
    private double brl;

    public double getRates() {
        return rates.getBrl();
    }

    public String getBase() {
        return base;
    }

    public double getBrl() {
        return brl;
    }

}
