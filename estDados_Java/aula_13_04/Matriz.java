package aula_13_04;

import java.util.ArrayList;

public class Matriz {
    /**
     * metodo de classe que inicializa uma  matriz de inteiros
     * @param matriz - matriz a ser inicializada
     * @param qtdL - quantidade de linhas da matriz
     * @param qtdC - quantidade de colunas da matriz
     */
    public static void inicializarmatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                matriz[i][j] = 0;
            }
        }
        
    }
    /**
     * Metodo de classe que exibe uma matriz de inteiros
     * @param matriz - matriz a ser exibida
     * @param qtdL - quantidade de linhas da matriz
     * @param qtdC - quantidade de colunas da matriz
     */
    public static void exibirMatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * metodo de classe que converte uma matriz especial em uma lista de dados
     * @param matriz - matriz de inteiros
     * @param qtdL
     * @param qtdC
     * @param lista
     */
    public static void converterMatrizEmLista(int matriz[][], int qtdL, int qtdC, ArrayList<Dado> lista) {
        for( int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                if(matriz[i][j] != 0) {
                    lista.add(new Dado(matriz[i][j], i, j));
                }
            }
        }
        }

        public static void exibirLista(ArrayList<Dado> lista) {
            for(Dado item : lista) {
                System.out.println(item);
            }
            System.out.println("------------------------------");
            System.out.println("Total de elementos não nulos: " + lista.size());
        }
}
