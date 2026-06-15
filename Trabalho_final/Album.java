package Trabalho_final;

import java.util.List;

public class Album {
    
    private List<Figura> figurasRepetidas;
    private List<Figura> figurasDesejadas;
    
    // Constantes com os nomes dos arquivos
    private final String repetidas = "figuras_repetidas.csv";
    private final String desejadas = "figuras_desejadas.csv";
    
    private GerenciadorArquivo gerenciadorArquivo;

    // O construtor é executado logo que crio um novo Album
    public Album() {
        this.gerenciadorArquivo = new GerenciadorArquivo();
        // Toda vez que o programa é iniciado, ele já popula as listas lendo os arquivos CSV
        this.figurasRepetidas = gerenciadorArquivo.carregar(repetidas);
        this.figurasDesejadas = gerenciadorArquivo.carregar(desejadas);
    }

    // Método para cadastrar uma repetida.
    public void adicionarRepetida(Figura figura) {
        figurasRepetidas.add(figura);
        gerenciadorArquivo.salvar(figurasRepetidas, repetidas);
    }

    // Método para cadastrar uma desejada. 
    public void adicionarDesejada(Figura figura) {
        figurasDesejadas.add(figura);
        gerenciadorArquivo.salvar(figurasDesejadas, desejadas);
    }

    // Métodos para imprimir as listas na tela
    public void listarRepetidas() {
        imprimirLista(figurasRepetidas);
    }

    public void listarDesejadas() {
        imprimirLista(figurasDesejadas);
    }

    // metodo para procurar matches com outra pessoa
    public void verificarMatches(String arquivoOutro, boolean procurandoParaReceber) {
        // Primeiro, leio o arquivo CSV do amigo
        List<Figura> listaOutro = gerenciadorArquivo.carregar(arquivoOutro);
        
        if (listaOutro.isEmpty()) {
            System.out.println("Arquivo vazio ou inexistente.");
            return;
        }

        System.out.println("\n--- Figuras carregadas ---");
        imprimirLista(listaOutro);

        // Se eu estou procurando para receber, comparo com a minha lista de desejadas.
        // Se não, comparo com a minha lista de repetidas.
        List<Figura> listaReferencia = procurandoParaReceber ? figurasDesejadas : figurasRepetidas;
        String tipoMatch = procurandoParaReceber ? "Você deseja e o amigo tem" : "Amigo deseja e você tem";
        
        System.out.println("\n=== MATCHES ENCONTRADOS (" + tipoMatch + ") ===");
        boolean achou = false;
        
        // Percorro a lista do amigo
        for (Figura figuraAmigo : listaOutro) {
            // O java acha os matches automaticamente
            if (listaReferencia.contains(figuraAmigo)) {
                System.out.println("MATCH: " + figuraAmigo);
                achou = true;
            }
        }
        
        // Se rodou tudo e não achou nada
        if (!achou) {
            System.out.println("Nenhum match encontrado para troca.");
        }
    }

    private void imprimirLista(List<Figura> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma figura encontrada.");
        } else {
            for (Figura f : lista) {
                System.out.println(f); 
            }
        }
    }
}
