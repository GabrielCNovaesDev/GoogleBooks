package com.gabrielcostanovaes.inicializaAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcostanovaes.formatacao.Format;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;


public class InicializaAPI {

    Properties prop = new Properties();
    Format format = new Format();

    public String getTitleName(String nomeLivro) throws IOException, InterruptedException {

        prop.load(new FileInputStream(".idea/config/config.properties"));
        String apiKey = prop.getProperty("apiKey");

        String responseBody = "";
        String nomeLivroFormatado = format.formataString(nomeLivro);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=intitle:" + nomeLivroFormatado + "&key=" + apiKey))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            responseBody = response.body();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return responseBody;
    }

}
