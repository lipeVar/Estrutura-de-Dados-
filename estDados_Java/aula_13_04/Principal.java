package aula_13_04;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //Simulando uma matriz especial, onde os dados são armazenados em uma matriz de inteiros, onde o valor 1 representa a presença de um dado e o valor 0 representa a ausência de um dado.
        int dimansao = 10;
        int matriz[][] = new int[dimansao][dimansao];
        Matriz.inicializarmatriz(matriz, dimansao, dimansao);

        matriz[0][3] = 1;
        matriz[2][5] = 1;
        matriz[5][7] = 1;
        matriz[6][8] = 1;
        Matriz.exibirMatriz(matriz, dimansao, dimansao);

        //converter a matriz especial em lista de dados
        ArrayList<Dado> lista = new ArrayList<>();
        Matriz.converterMatrizEmLista(matriz, dimansao, dimansao, lista);
        Matriz.exibirLista(lista);
    }
}
