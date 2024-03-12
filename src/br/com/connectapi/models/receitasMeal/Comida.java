package br.com.connectapi.models.receitasMeal;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.connectapi.interfaces.objectsToApi;
import br.com.connectapi.models.ConexaoApis.ConnectApi;

public class Comida extends TransformaJsonComida implements objectsToApi{
    private ArrayList<String> listaIngredientes = new ArrayList<>();
    
    private String categoriaReceita;
    private String linkImagem;
    private String nomeReceita;

    private TransformaListaJsonComida objetoFinal;

    private String dadosJson;
    private ConnectApi connectApi;
    private String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=%s";
    
    public Comida(String nomeReceita) throws IOException, InterruptedException {
        this.url = url.formatted(nomeReceita);
        
        enviaNomeParaApi(this.getUrl());
    }

    @Override
    public void enviaNomeParaApi(String link) throws IOException, InterruptedException {
        connectApi = new ConnectApi(link);
        connectApi.connect();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        _setDadosJson(connectApi.getResult());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);
        
        try { 
            TransformaJsonComida receita = objectMapper.readValue(this.dadosJson, TransformaJsonComida.class);
            objetoFinal = receita.objetoFinal();
            listaIngredientes = objetoFinal.getListaIngredientes();

            _setCategoriaReceita(objetoFinal.getStrCategory());
            _setNomeReceita(objetoFinal.getStrMeal());
            _setLinkImagem(objetoFinal.getStrMealThumb());
            
            return "Nome: %s; Categoria: %s; Ingredientes: %s; Link Imagem Receita: %s"
            .formatted(this.nomeReceita, this.categoriaReceita, _criaStringDeListaDeIngredientes(), this.linkImagem);
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Não foi possível realizar a conexão";
        }
    }

    private void _setDadosJson(String data){
        this.dadosJson = data;
    }

    private String _criaStringDeListaDeIngredientes() {
        String lista = " ";

        for(String string : listaIngredientes) {
            if (string != null && !string.equals("") ) {
                lista += string;
                lista += ", ";
            }

        }
        return lista;
    }

    public String getCategoriaReceita() {
        return categoriaReceita;
    }
    public String getLinkImagem() {
        return linkImagem;
    }
    public String getNomeReceita() {
        return nomeReceita;
    }
    

    private void _setCategoriaReceita(String categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }
    private void _setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }
    private void _setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    
}
