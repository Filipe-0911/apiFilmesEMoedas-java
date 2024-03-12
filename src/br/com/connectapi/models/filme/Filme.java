package br.com.connectapi.models.filme;

import java.io.IOException;

//bibliotecas externas baixadas do site https://jar-download.com/artifacts/com.fasterxml.jackson.core
//arquivos adicionados na pasta lib
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.connectapi.interfaces.objectsToApi;
import br.com.connectapi.models.ConexaoApis.ConnectApi;

public class Filme extends TransformaJsonFilme implements objectsToApi {
    private String url = "https://www.omdbapi.com/?t=%s&apikey=834a114d";
    private String dadosJson;
    private String descricao;
    private String titulo;
    private int anoDeLancamento;
    private ConnectApi connectApi;

    public Filme(String nome) throws IOException, InterruptedException {
        this.url = url.formatted(nome);

        enviaNomeParaApi(this.getUrl());

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
            TransformaJsonFilme filme = objectMapper.readValue(this.dadosJson, TransformaJsonFilme.class);

            _setAnoDeLancamento(filme.getYear());
            _setTituloFilme(filme.getTitle());
            _setDescricao(filme.getPlot());        
            
            String movie = "Nome: %s, Ano de lançamento: %d, Descrição: %s".formatted(this.titulo, this.anoDeLancamento, this.descricao);
            
            return movie;
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Não foi possível realizar a conexão";
        }
    }
    
    @Override
    public String getUrl() {
        return this.url;
    }

    private void _setAnoDeLancamento (int ano) {
        this.anoDeLancamento = ano;
    }

    private void _setTituloFilme(String titulo) {
        this.titulo = titulo;
    }

    private void _setDescricao(String descricao) {
        this.descricao = descricao;
    }

        
    private void _setDadosJson(String dadosJson) {
        this.dadosJson = dadosJson;
    }
    
}
