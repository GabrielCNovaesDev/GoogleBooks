package com.gabrielcostanovaes.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner(System.in);
        GetTitleInfo getTitleInfo = new GetTitleInfo();

        System.out.println("Digite o nome do livro:");
        String titleName = input.nextLine();

        System.out.println(getTitleInfo.titleInfo(titleName));
    }
}
