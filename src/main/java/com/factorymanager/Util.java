package com.factorymanager;

import java.util.Scanner;

public class Util {

    public int validador(Scanner scanner){
    int codigo = -1;
    boolean idValido = false;

    while (!idValido){
        try {
        String input = scanner.nextLine();
        codigo = Integer.parseInt(input);
        if (codigo<0){
            System.out.println("Id deve ser um numero inteiro positivo:");

        }else {
        idValido =true;
        }
        }catch (NumberFormatException e){
            System.out.println("Erro, digite apenas numeros inteiros válidos por favor:");
        }
    }
    return codigo;
    }
}
