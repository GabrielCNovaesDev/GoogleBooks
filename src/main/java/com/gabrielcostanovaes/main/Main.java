package com.gabrielcostanovaes.main;

import com.gabrielcostanovaes.formatacao.Format;
import com.gabrielcostanovaes.inicializaAPI.InicializaAPI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        InicializaAPI inicializaAPI = new InicializaAPI();
        System.out.println(inicializaAPI.getTitleName("Messias de Duna"));
    }
}
