package br.com.connectapi.models.ConexaoApis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.com.connectapi.interfaces.connectionApi;

public class ConnectApi implements connectionApi {
    private String url;
    private String result;

    HttpClient client;
    HttpRequest request;


    public ConnectApi (String url) {
        this.url = url;
    }
    
    public void connect() throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();

        HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());
        
        this.result = response.body();
    }

    public String getResult() {
        return this.result;
    }




}
