package Trabalho_final;

import java.util.Scanner;

// Main para interface do usuario
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Instancio o meu álbum. Quando isso roda, o construtor dele já carrega os CSVs automaticamente.
        Album meuAlbum = new Album();

        int opcao = 0;
        
        // Só para de rodar quando digita 7
        do {
            exibirMenu();
            System.out.print("Opção: ");
            
            // Faço um try-catch para não quebrar o programa se o usuário digitar uma letra sem querer
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            // switch-case para as opções
            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrar Repetida ---");
                    // Chamo meu método auxiliar que cria a figura via scanner, passo true pq é repetida
                    meuAlbum.adicionarRepetida(criarFiguraViaScanner(scanner, true));
                    System.out.println("Cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.println("\n--- FIGURAS REPETIDAS ---");
                    meuAlbum.listarRepetidas();
                    break;
                case 3:
                    System.out.println("\n--- Cadastrar Desejada ---");
                    // Passo false porque é desejada
                    meuAlbum.adicionarDesejada(criarFiguraViaScanner(scanner, false));
                    System.out.println("Cadastrada com sucesso!");
                    break;
                case 4:
                    System.out.println("\n--- FIGURAS DESEJADAS ---");
                    meuAlbum.listarDesejadas();
                    break;
                case 5:
                    System.out.print("Digite o arquivo de repetidas da pessoa para troca: ");
                    String arqRepetidasOutro = scanner.nextLine();
                    // Passo true porque estou verificando o que eu quero receber do amigo
                    meuAlbum.verificarMatches(arqRepetidasOutro, true); 
                    break;
                case 6:
                    System.out.print("Digite o arquivo de desejadas da pessoa para troca: ");
                    String arqDesejadasOutro = scanner.nextLine();
                    // Passo false porque estou verificando o que o amigo quer receber de mim
                    meuAlbum.verificarMatches(arqDesejadasOutro, false); 
                    break;
                case 7:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    // metodo apenas para MENU
    private static void exibirMenu() {
        System.out.println("\n================ MENU ================");
        System.out.println("1 - Cadastrar figuras repetidas");
        System.out.println("2 - Listar figuras repetidas");
        System.out.println("3 - Cadastrar figuras desejadas");
        System.out.println("4 - Listar figuras desejadas");
        System.out.println("5 - Carregar figuras repetidas (Procurar matches)");
        System.out.println("6 - Carregar figuras desejadas (Procurar matches)");
        System.out.println("7 - Sair");
        System.out.println("======================================");
    }

    // Criei esse método auxiliar para não repetir as perguntas
    private static Figura criarFiguraViaScanner(Scanner scanner, boolean isRepetida) {
        System.out.print("Seleção: ");
        String selecao = scanner.nextLine();
        
        System.out.print("Número da Figura: ");
        int numero = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Descrição (Jogador, Brasão...): ");
        String descricao = scanner.nextLine();
        
        int quantidade = 1; 
        
        // Se for repetida, eu pergunto a quantidade.
        if (isRepetida) {
            System.out.print("Quantidade: ");
            quantidade = Integer.parseInt(scanner.nextLine());
        }
        
        System.out.print("É rara? (S/N): ");
        boolean rara = scanner.nextLine().trim().equalsIgnoreCase("S");

        // Retorno o novo objeto montado com os dados que o usuário digitou
        return new Figura(selecao, numero, descricao, quantidade, rara);
    }
}
