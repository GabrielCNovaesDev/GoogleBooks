package com.gabrielcostanovaes.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcostanovaes.inicializaAPI.InicializaAPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        InicializaAPI inicializaAPI = new InicializaAPI();
        Scanner input = new Scanner(System.in);
        ObjectMapper jackson = new ObjectMapper();

        System.out.println("Digite o nome do livro:");
        String titleName = input.nextLine();

        String TitleJson = inicializaAPI.getTitle(titleName);
        JsonNode TitleJsonNode = jackson.readTree(TitleJson)
                .get("items")
                .get(0)
                .get("volumeInfo");

        String Author = TitleJsonNode.get("authors").get(0).asText();
        String pageCount = TitleJsonNode.get("pageCount").asText();
        String categories = TitleJsonNode.get("categories").get(0).asText();
        String description = TitleJsonNode.get("description").asText();

        System.out.println("Autores: "+Author);
        System.out.println("Numéro de páginas: "+ pageCount);
        System.out.println("Classificação: "+categories);
        System.out.println("Descrição: "+description);
    }
}
