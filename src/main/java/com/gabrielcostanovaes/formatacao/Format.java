package com.gabrielcostanovaes.formatacao;

public class Format {
    public String formataString(String texto) {
        texto = texto.replaceAll(" ","+");
        return texto;
    }
}
