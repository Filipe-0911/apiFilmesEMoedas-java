package br.com.connectapi.models.coinConverter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.connectapi.interfaces.objectsToApi;
import br.com.connectapi.models.ConexaoApis.ConnectApi;

public class Coin extends TransformaJsonCoin implements objectsToApi {
    private String nomeMoeda;
    private String dataVerificacao;
    private Object valores;

    private double valor;
    private String url = "https://api.exchangerate-api.com/v4/latest/%s";
    private ConnectApi connectApi;
    private String dadosJson;

    public Coin(String nomeMoeda) throws IOException, InterruptedException {
        this.nomeMoeda = nomeMoeda;
        this.url = url.formatted(nomeMoeda);

        enviaNomeParaApi(this.getUrl());

    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }

    public String getDataVerificacao() {
        return dataVerificacao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public void enviaNomeParaApi(String link) throws IOException, InterruptedException {
        connectApi = new ConnectApi(link);
        connectApi.connect();
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _setDadosJson(connectApi.getResult());
        
        try { 
            TransformaJsonCoin valoresMoedas = objectMapper.readValue(this.dadosJson, TransformaJsonCoin.class);

            this.nomeMoeda = valoresMoedas.getBase();
            this.valores = valoresMoedas.getRates();
     
            
            String stringToReturnWithValues = 
            "Nome moeda: %s; Vale: R$ %s".formatted(this.nomeMoeda, this.valores);
            
            return stringToReturnWithValues;
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Não foi possível realizar a conexão";
        }
    }

    private void _setDadosJson(String result) {
        this.dadosJson = result;
    }

}
