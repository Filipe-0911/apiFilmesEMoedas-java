package br.com.connectapi.models.receitasMeal;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransformaJsonComida {
    
    @JsonProperty("meals")
    private ArrayList<TransformaListaJsonComida> meals;

    public ArrayList<TransformaListaJsonComida> getMeals() {
        return meals;
    }

    private List<TransformaListaJsonComida> _listaComDadosReceita() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);

        List<TransformaListaJsonComida> meals = this.getMeals();

        return meals;

    }

    public TransformaListaJsonComida objetoFinal() {
        _listaComDadosReceita();

        return meals.get(0);
    }

}
