package com.gabrielcostanovaes.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielcostanovaes.inicializaAPI.InicializaAPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        GetTitleInfo getTitleInfo = new GetTitleInfo();

        System.out.println("Digite o nome do livro:");
        String titleName = input.nextLine();

        System.out.println(getTitleInfo.titleInfo(titleName));
    }
}
