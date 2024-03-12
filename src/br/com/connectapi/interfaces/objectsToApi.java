package br.com.connectapi.interfaces;

import java.io.IOException;

public interface objectsToApi {
    public String getUrl();
    
    @Override
    public String toString();

    public void enviaNomeParaApi(String link) throws IOException, InterruptedException;
}
