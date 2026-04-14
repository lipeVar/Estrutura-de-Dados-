package aula_13_04;

public class Dado {
    public int valor;
    public int linha;
    public int coluna;

    public Dado(int valor, int linha, int coluna) {
        this.valor = valor;
        this.linha = linha;
        this.coluna = coluna;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dado other = (Dado) obj;
        if (linha != other.linha)
            return false;
        if (coluna != other.coluna)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Dado [valor=" + valor + ", linha=" + linha + ", coluna=" + coluna + "]";
    }

    
}
