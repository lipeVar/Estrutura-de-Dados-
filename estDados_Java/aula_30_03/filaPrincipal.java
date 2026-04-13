package aula_30_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class filaPrincipal {
    public class Sistemafilas {

        Queue<String> filaNormal = new LinkedList<>();
        Queue<String> filaPrioritaria = new LinkedList<>();

        int contatorChamados = 0;
        int contadorNormal = 1;
        int contadorPrioritario = 51;

        public void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("====== MENU ======");
                System.out.println("1. Imprimir ficha norlmal");
                System.out.println("2. Imprimir ficha prioritária");
                System.out.println("3. Chamar próximo da fila");
                System.out.println("4. Mostrar filas");
                System.out.println("5. Sair");
                System.out.println("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        // Lógica para imprimir ficha normal
                        break;
                
                    default:
                        break;
                }
            }
        }
        
    }
}
