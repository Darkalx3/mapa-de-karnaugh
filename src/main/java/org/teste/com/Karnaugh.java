package org.teste.com;

public class Karnaugh {

    // Variáveis

    private int[][] matrizMapaGrupos;
    private String[] expressao;

    // Construtores

    public Karnaugh() {
        this.expressao = new String[16];
    }

    public Karnaugh(boolean[][] matrizBits) {
        resolverKarnaugh(matrizBits);
        this.expressao = new String[16];
    }

    // Métodos

    public void limparExpressao() {
        for(int i=0;i<16;i++) {
            this.expressao[i] = null;
        }
    }

    private int[] posicaoParaABCD(int x1, int y1, int x2, int y2) {
        boolean[][] matrizABCD = new boolean[16][4];
        int[] ABCD = new int[4];
        int indexABCD = 0;

        // Extrai os valores em sua versão binária para a Matriz ABCD

        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                switch(i) {
                    case 0: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = false; break;
                    case 1: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = true; break;
                    case 2: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = true; break;
                    case 3: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = false; break;
                    default:
                }
                switch(j) {
                    case 0: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = false; break;
                    case 1: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = true; break;
                    case 2: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = true; break;
                    case 3: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = false; break;
                    default:
                }
                indexABCD++;
            }
        }

        // O ABCD recebe o valor padrão

        for(int i=0;i<4;i++) {
            if(matrizABCD[0][i]) {
                ABCD[i] = 1;
            } else {
                ABCD[i] = 0;
            }
        }

        // Verifica se algum do valores: A, B, C ou D variam, se sim, atribui -1 a eles (eles deixam de existir)

        for(int j=0;j<4;j++) {
            for(int i=0;i<(indexABCD-1);i++) {
                if(matrizABCD[i][j]!=matrizABCD[i+1][j]) {
                    ABCD[j] = -1;
                    break;
                }
            }
        }

        return ABCD;
    }

    private int[] posicaoParaABCD(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        boolean[][] matrizABCD = new boolean[16][4];
        int[] ABCD = new int[4];
        int indexABCD = 0;

        // Extrai os valores em sua versão binária para a Matriz ABCD

        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                switch(i) {
                    case 0: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = false; break;
                    case 1: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = true; break;
                    case 2: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = true; break;
                    case 3: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = false; break;
                    default:
                }
                switch(j) {
                    case 0: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = false; break;
                    case 1: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = true; break;
                    case 2: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = true; break;
                    case 3: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = false; break;
                    default:
                }
                indexABCD++;
            }
        }

        for(int i=x3;i<=x4;i++) {
            for(int j=y3;j<=y4;j++) {
                switch(i) {
                    case 0: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = false; break;
                    case 1: matrizABCD[indexABCD][0] = false; matrizABCD[indexABCD][1] = true; break;
                    case 2: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = true; break;
                    case 3: matrizABCD[indexABCD][0] = true; matrizABCD[indexABCD][1] = false; break;
                    default:
                }
                switch(j) {
                    case 0: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = false; break;
                    case 1: matrizABCD[indexABCD][2] = false; matrizABCD[indexABCD][3] = true; break;
                    case 2: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = true; break;
                    case 3: matrizABCD[indexABCD][2] = true; matrizABCD[indexABCD][3] = false; break;
                    default:
                }
                indexABCD++;
            }
        }

        // O ABCD recebe o valor padrão

        for(int i=0;i<4;i++) {
            if(matrizABCD[0][i]) {
                ABCD[i] = 1;
            } else {
                ABCD[i] = 0;
            }
        }

        // Verifica se algum do valores: A, B, C ou D variam, se sim, atribui -1 a eles (eles deixam de existir)

        for(int j=0;j<4;j++) {
            for(int i=0;i<(indexABCD-1);i++) {
                if(matrizABCD[i][j]!=matrizABCD[i+1][j]) {
                    ABCD[j] = -1;
                    break;
                }
            }
        }

        return ABCD;
    }

    private String posicaoParaCaracteres(int x1, int y1, int x2, int y2) {
        String expressaoABCD = "";
        int[] ABCD = posicaoParaABCD(x1,y1,x2,y2);

        // Transforma os valores em texto

        switch(ABCD[0]) {
            case 0: expressaoABCD += "A`"; break;
            case 1: expressaoABCD += "A"; break;
            default:
        }
        switch(ABCD[1]) {
            case 0: expressaoABCD += "B`"; break;
            case 1: expressaoABCD += "B"; break;
            default:
        }
        switch(ABCD[2]) {
            case 0: expressaoABCD += "C`"; break;
            case 1: expressaoABCD += "C"; break;
            default:
        }
        switch(ABCD[3]) {
            case 0: expressaoABCD += "D`"; break;
            case 1: expressaoABCD += "D"; break;
            default:
        }

        return expressaoABCD;
    }

    private String posicaoParaCaracteres(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        String expressaoABCD = "";
        int[] ABCD = posicaoParaABCD(x1,y1,x2,y2,x3,y3,x4,y4);

        // Transforma os valores em texto

        switch(ABCD[0]) {
            case 0: expressaoABCD += "A`"; break;
            case 1: expressaoABCD += "A"; break;
            default:
        }
        switch(ABCD[1]) {
            case 0: expressaoABCD += "B`"; break;
            case 1: expressaoABCD += "B"; break;
            default:
        }
        switch(ABCD[2]) {
            case 0: expressaoABCD += "C`"; break;
            case 1: expressaoABCD += "C"; break;
            default:
        }
        switch(ABCD[3]) {
            case 0: expressaoABCD += "D`"; break;
            case 1: expressaoABCD += "D"; break;
            default:
        }

        return expressaoABCD;
    }

    private boolean ehPossivelConjunto(boolean[] vetor) { // com base em vetor, verifica possibidade de conjunto
        for(int i=0;i<3;i++) {
            if(vetor[i]==vetor[i+1] && vetor[i]) {
                return true;
            }
        }
        if(vetor[0]==vetor[3] && vetor[0]) {
            return true;
        }

        return false;
    }

    private int[] ondeEPossivelConjunto(boolean[] vetor) { // verifica onde é possível ter um conjunto
        int[] indicePossivel = new int[2];

        for(int i=0;i<3;i++) {
            if(vetor[i]==vetor[i+1] && vetor[i]) {
                indicePossivel[0] = i;
                indicePossivel[1] = i+1;
                return indicePossivel;
            }
        }
        if(vetor[0]==vetor[3] && vetor[0]) {
            indicePossivel[0] = 0;
            indicePossivel[1] = 3;
        }

        return indicePossivel;
    }

    private void preencherMapa(int[][] matriz, int x1, int y1, int x2, int y2, int value) {
        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                matriz[i][j] = value;
            }
        }
    }

    public void resolverKarnaugh(boolean[][] matrizBits) {

        // Variáveis

        int[][] matrizGrupos = new int[4][4];
        int numeroDosGrupos = 1;
        boolean auxCheck = false;

        // Reseta a expressao

        limparExpressao();

        // Verifica se a matriz está Completa (todos os valores são 1)

        auxCheck = true;
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                if(!matrizBits[i][j]) {
                    auxCheck = false;
                }
            }
        }

        if (auxCheck) {
            preencherMapa(matrizGrupos,0,0,3,3,numeroDosGrupos);
            this.matrizMapaGrupos = matrizGrupos;
            this.expressao[numeroDosGrupos-1] = "";
            return;
        }

        // Verifica Linhas e Colunas

        boolean[] linhas = new boolean[4];
        boolean[] colunas = new boolean[4];
        int nLinhas = 0;
        int nColunas = 0;

        for(int i=0;i<4;i++) {
            int countLinhas = 0;
            int countColunas = 0;
            for(int j=0;j<4;j++) {
                if(matrizBits[i][j]) { // Verifica as linhas
                    countLinhas++;
                }
                if(matrizBits[j][i]) { // Verifica as colunas
                    countColunas++;
                }
            }
            if(countLinhas==4) {
                linhas[i] = true;
                nLinhas++;
            }
            if(countColunas==4) {
                colunas[i] = true;
                nColunas++;
            }
        }

        // Preenche os conjuntos de linhas ou colunas ou apenas linha e coluna na matriz, se existir

        if(ehPossivelConjunto(linhas)) {

            //System.out.println("Linhas com Conjunto");
            int[] indice = ondeEPossivelConjunto(linhas);
            preencherMapa(matrizGrupos,indice[0],0,indice[0],3,numeroDosGrupos);
            preencherMapa(matrizGrupos,indice[1],0,indice[1],3,numeroDosGrupos);
            this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(indice[0],0,indice[0],3,indice[1],0,indice[1],3);
            numeroDosGrupos++;

        } else if(ehPossivelConjunto(colunas)){

            //System.out.println("Colunas com Conjunto");
            int[] indice = ondeEPossivelConjunto(colunas);
            preencherMapa(matrizGrupos,0,indice[0],3,indice[0],numeroDosGrupos);
            preencherMapa(matrizGrupos,0,indice[1],3,indice[1],numeroDosGrupos);
            this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(0,indice[0],3,indice[0],0,indice[1],3,indice[1]);
            numeroDosGrupos++;

        } else if(nLinhas>0) {

            //System.out.println("Linhas");
            int linha = 0;
            for(int i=0;i<4;i++) {
                if(linhas[i]) {
                    linha = i;
                    break;
                }
            }
            preencherMapa(matrizGrupos,linha,0,linha,3,numeroDosGrupos);
            this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(linha,0,linha,3);
            numeroDosGrupos++;

        } else if(nColunas>0) {

            //System.out.println("Coluna");
            int coluna = 0;
            for(int i=0;i<4;i++) {
                if(colunas[i]) {
                    coluna = i;
                    break;
                }
            }
            preencherMapa(matrizGrupos,0,coluna,3,coluna,numeroDosGrupos);
            this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(0,coluna,3,coluna);
            numeroDosGrupos++;

        } else {
            //System.out.println("Nenhuma Linha ou Coluna");
        }

        // Verificação conjunto de 4 (Quadrados)

        // Verificação normal

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(matrizBits[i][j] && matrizBits[i+1][j] && matrizBits[i][j+1] && matrizBits[i+1][j+1] &&
                   matrizGrupos[i][j]==0 && matrizGrupos[i+1][j]==0 && matrizGrupos[i][j+1]==0 && matrizGrupos[i+1][j+1]==0) {
                    preencherMapa(matrizGrupos,i,j,i+1,j+1,numeroDosGrupos);
                    this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(i,j,i+1,j+1);
                    numeroDosGrupos++;
                }
            }
        }

        // Verificação de Conjuntos Esquerda-Direita

        for(int i=0;i<3;i++) {
            if(matrizBits[i][0] && matrizBits[i+1][0] && matrizBits[i][3] && matrizBits[i+1][3] &&
               matrizGrupos[i][0]==0 && matrizGrupos[i+1][0]==0 && matrizGrupos[i][3]==0 && matrizGrupos[i+1][3]==0) {
                preencherMapa(matrizGrupos,i,0,i+1,0, numeroDosGrupos);
                preencherMapa(matrizGrupos,i,3,i+1,3, numeroDosGrupos);
                this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(i,0,i+1,0,i,3,i+1,3);
                numeroDosGrupos++;
            }
        }

        // Verificação de Conjunto Cima-Baixo

        for(int i=0;i<3;i++) {
            if(matrizBits[0][i] && matrizBits[0][i+1] && matrizBits[3][i] && matrizBits[3][i+1] &&
               matrizGrupos[0][i]==0 && matrizGrupos[0][i+1]==0 && matrizGrupos[3][i]==0 && matrizGrupos[3][i+1]==0) {
                preencherMapa(matrizGrupos,0,i,0,i+1,numeroDosGrupos);
                preencherMapa(matrizGrupos,3,i,3,i+1,numeroDosGrupos);
                this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(0,i,0,i+1,3,i,3,i+1);
                numeroDosGrupos++;
            }
        }

        // Verificação de 2

        for(int i=0;i<3;i++) {
            for(int j=0;j<4;j++){
                if(matrizBits[i][j] && matrizBits[i+1][j] &&
                   matrizGrupos[i][j]==0 && matrizGrupos[i+1][j]==0) { // Verifica os conjuntos de 2 na vertical
                    preencherMapa(matrizGrupos,i,j,i+1,j,numeroDosGrupos);
                    this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(i,j,i+1,j);
                    numeroDosGrupos++;
                }
                if(matrizBits[j][i] && matrizBits[j][i+1] &&
                   matrizGrupos[j][i]==0 && matrizGrupos[j][i+1]==0) { // Verifica os conjuntos de 2 na horizontal
                    preencherMapa(matrizGrupos,j,i,j,i+1,numeroDosGrupos);
                    this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(j,i,j,i+1);
                    numeroDosGrupos++;
                }
            }
        }

        // Verificação de 2 Especial

        for(int i=0;i<4;i++) {
            if(matrizBits[i][0] && matrizBits[i][3] &&
               matrizGrupos[i][0]==0 && matrizGrupos[i][3]==0) { // Verificão Esquerda-Direita
                preencherMapa(matrizGrupos,i,0,i,0,numeroDosGrupos);
                preencherMapa(matrizGrupos,i,3,i,3,numeroDosGrupos);
                this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(i,0,i,0,i,3,i,3);
                numeroDosGrupos++;
            }
            if(matrizBits[0][i] && matrizBits[3][i] &&
               matrizGrupos[0][i]==0 && matrizGrupos[3][i]==0) { // Verificação Cima-Baixo
                preencherMapa(matrizGrupos,0,i,0,i,numeroDosGrupos);
                preencherMapa(matrizGrupos,3,i,3,i,numeroDosGrupos);
                this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(0,i,0,i,3,i,3,i);
                numeroDosGrupos++;
            }
        }

        // Verificação de 1 (Sobra)

        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                if(matrizBits[i][j] && matrizGrupos[i][j]==0) {
                    preencherMapa(matrizGrupos,i,j,i,j,numeroDosGrupos);
                    this.expressao[numeroDosGrupos-1] = posicaoParaCaracteres(i,j,i,j);
                    numeroDosGrupos++;
                }
            }
        }

        this.matrizMapaGrupos = matrizGrupos;
        return;
    }

    public int[][] getMatrizMapaGrupos() {
        return matrizMapaGrupos;
    }

    public String getExpressao() {
        String expressaoSOP = this.expressao[0];

        for(int i=1;i<this.expressao.length;i++) {
            if(this.expressao[i]!=null) {
                expressaoSOP += " + "+this.expressao[i];
            }
        }

        return expressaoSOP;
    }
}
