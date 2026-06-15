package Trabalho_final;

import java.util.Objects;

// A classe Figura herda de ItemColecionavel. 
public class Figura extends ItemColecionavel {
    
    private int quantidade;
    private boolean rara;

    // Construtor da Figurinha
    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        // O "super" chama o construtor da classe pai e repassa os atributos básicos para ela.
        super(nomeSelecao, numeroFigura, descricao); 
        
        this.quantidade = quantidade;
        this.rara = rara;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Se for o exato mesmo objeto na memória, é igual.
        if (obj == null || getClass() != obj.getClass()) return false; // Se for nulo ou de outra classe, não é.
        
        Figura figura = (Figura) obj;
        
        // Comparação do número e o nome da seleção
        return numeroFigura == figura.numeroFigura && 
               Objects.equals(nomeSelecao.toLowerCase(), figura.nomeSelecao.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeSelecao.toLowerCase(), numeroFigura);
    }

    // Método que formata a Figurinha
    @Override
    public String toString() {
        return String.format("[%s - %d] %s | Qtd: %d | Rara: %s", 
                nomeSelecao, numeroFigura, descricao, quantidade, rara ? "Sim" : "Não");
    }

    // Criei esse método para preparar a figurinha para ser salva no arquivo CSV.
    public String toCSV() {
        return nomeSelecao + ";" + numeroFigura + ";" + descricao + ";" + quantidade + ";" + rara;
    }

    // Criei esse método estático para pegar uma linha de texto do arquivo CSV e transformar de volta em um objeto Figura.
    public static Figura fromCSV(String linha) {
        String[] dados = linha.split(";"); // Corta a linha onde tem ponto e vírgula
        
        // Se a linha quebrou em exatamente 5 partes, os dados estão corretos
        if (dados.length == 5) {
            return new Figura(
                dados[0], // Seleção
                Integer.parseInt(dados[1]), 
                dados[2], 
                Integer.parseInt(dados[3]),
                Boolean.parseBoolean(dados[4]) 
            );
        }
        return null; // Retorna nulo se a linha estiver defeituosa
    }
}
