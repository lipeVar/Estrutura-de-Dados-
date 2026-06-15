package Trabalho_final;
import java.util.Objects;

// Criação da classe abstrata
public abstract class ItemColecionavel {
    
    //modificador protected para que as classes que herdarem desta possam acessar esses atributos.
    protected String nomeSelecao;
    protected int numeroFigura;
    protected String descricao;

    // Construtor da classe para inicializar os atributos básicos
    public ItemColecionavel(String nomeSelecao, int numeroFigura, String descricao) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
    }

    // Métodos Getters 
    public String getNomeSelecao() { return nomeSelecao; }
    public int getNumeroFigura() { return numeroFigura; }
    public String getDescricao() { return descricao; }
}
