package br.com.connectapi.models.filme;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformaJsonFilme {
    @JsonProperty("Title")
    private String Title;

    @JsonProperty("Year")
    private String Year;

    @JsonProperty("Plot")
    private String Plot;

    public String getTitle() {
        return Title;
    }

    public int getYear() {
        return Integer.parseInt(Year);
    }

    public String getPlot() {
        return Plot;
    }

}
