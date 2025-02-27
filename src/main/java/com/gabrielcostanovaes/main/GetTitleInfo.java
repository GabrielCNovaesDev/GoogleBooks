package com.gabrielcostanovaes.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcostanovaes.inicializaAPI.InicializaAPI;

import java.io.IOException;

public class GetTitleInfo extends InicializaAPI{

    public String titleInfo(String titleName) throws IOException{
        InicializaAPI inicializaAPI = new InicializaAPI();
        ObjectMapper jackson = new ObjectMapper();

        String TitleJson = inicializaAPI.getTitle(titleName);
        JsonNode TitleJsonNode = jackson.readTree(TitleJson)
                .get("items")
                .get(0)
                .get("volumeInfo");

        String Author = TitleJsonNode.get("authors").get(0).asText();
        String pageCount = TitleJsonNode.get("pageCount").asText();
        String categories = TitleJsonNode.get("categories").get(0).asText();
        String description = TitleJsonNode.get("description").asText();

        return "Autores: " + Author + "\n"
                + "Quantidade de páginas: "+ pageCount + "\n"
                + "Categorias: " + categories + "\n"
                + "Descrição: " + description + "\n" ;

    }


}
