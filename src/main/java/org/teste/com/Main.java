package org.teste.com;

import java.util.Scanner;

public class Main {

    public static void printMatrizBit(boolean[][] matriz, int len) {
        for(int i=0;i<len;i++) {
            System.out.print("| ");
            for(int j=0;j<len;j++) {
                if(matriz[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("|\n");
        }
    }

    public static void printMatrizInt(int[][] matriz, int len) {
        for(int i=0;i<len;i++) {
            System.out.print("| ");
            for(int j=0;j<len;j++) {
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.print("|\n");
        }
    }

    public static void main(String[] args) {

        // Variáveis

        boolean[][] matrizBit = new boolean[4][4];
        Scanner scan = new Scanner(System.in);
        IntefaceCLI interfaceCLI = new IntefaceCLI();
        Karnaugh kar = new Karnaugh();
        String option;

        // Menu

        while(true) {
            interfaceCLI.printMenu();
            option = scan.next();

            if(option.equals("0")) {
                break;
            } else if(option.equals("1")) {
                interfaceCLI.limparTela();

                // Pede os valores na Tabela Verdade

                System.out.print(" DIGITE O ESTADO PARA:\n" +
                                 " | A | B | C | D |\n");
                for(int i=0;i<2;i++) {
                    for(int j=0;j<2;j++) {
                        for(int k=0;k<2;k++) {
                            for(int m=0;m<2;m++) {
                                System.out.printf(" | %d | %d | %d | %d | [%02d]: ", i,j,k,m,((i*8)+(j*4)+(k*2)+m));

                                int[] aux = new int[2];
                                aux[0] = (2*i)+j;
                                aux[1] = (2*k)+m;
                                for(int l=0;l<2;l++) {
                                    if(aux[l]==2) {
                                        aux[l] = 3;
                                    } else if(aux[l]==3) {
                                        aux[l] = 2;
                                    }
                                }

                                if(scan.nextInt()==0) {
                                    matrizBit[aux[0]][aux[1]] = false;
                                } else {
                                    matrizBit[aux[0]][aux[1]] = true;
                                }
                            }
                        }
                    }
                }

                // Karnaugh

                kar.resolverKarnaugh(matrizBit);
                interfaceCLI.printResultado(matrizBit,kar.getMatrizMapaGrupos(),kar.getExpressao());

            } else if(option.equals("2")) {

            } else if(option.equals("3")) {

            } else {
                System.out.println(" A opção digitada não existe!");
            }
            interfaceCLI.pressEnter(scan);

        }

        System.out.println(" O programa foi finalizado!");

    }
}