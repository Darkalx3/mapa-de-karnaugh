package org.teste.com;

import java.util.Scanner;

public class IntefaceCLI {

    // Construtor

    public IntefaceCLI() {}

    // Métodos

    public void limparTela() {
        System.out.print("\n\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnter(Scanner scan) {
        System.out.print("\n Digite Algo para Continuar: ");
        scan.next();
    }

    public void printMenu() {
        limparTela();
        System.out.printf("" +
                          "----------------------------------------------------\n" +
                          "              MENU DO MAPA DE KARNAUGH\n" +
                          "----------------------------------------------------\n" +
                          " [1] Resolver Karnaugh Apartir da Tabela Verdade\n" +
                          " [0] Sair\n" +
                          "----------------------------------------------------\n" +
                          " Sua Opção: ");
    }

    public void printResultado(boolean[][] matrizBit, int[][] matrizGrupo, String expressao) {
        limparTela();
        System.out.print("" +
                          "----------------------------------------------------\n" +
                          "     MAPA DE KARNAUGH  |  MAPA DE GRUPOS\n" +
                          "----------------------------------------------------\n");
        for(int i=0;i<4;i++) {
            System.out.print("          |");
            for(int j=0;j<4;j++) {
                if(matrizBit[i][j]) {
                    System.out.print(" 1");
                } else {
                    System.out.print(" 0");
                }
            }
            System.out.print(" |     |");
            for(int j=0;j<4;j++) {
                System.out.printf(" %d", matrizGrupo[i][j]);
            }
            System.out.println(" |");
        }

        System.out.printf("" +
                         "----------------------------------------------------\n" +
                         " ESPRESSÃO: %s\n" +
                         "----------------------------------------------------\n", expressao);
    }
}
