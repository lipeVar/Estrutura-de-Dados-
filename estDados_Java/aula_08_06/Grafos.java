package estDados_Java.aula_08_06;

import java.util.ArrayList;
 
public class Grafos {
    int matrizADJ[][];
    int qtdVertices;
    ArrayList<String> listaVertices;
 
    /**
     * construtor que monta a listaVertices, qtdVertices e matrizADJ a partir da listaVertices
     * @param listaVertices contém os vértices do grafo ou mapa
     */
    public Grafos(ArrayList<String> listaVertices) {
        this.listaVertices = new ArrayList<>();
        this.listaVertices.addAll(listaVertices);
        
        this.qtdVertices = listaVertices.size();
        
        this.matrizADJ = new int[this.qtdVertices][this.qtdVertices];
        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.matrizADJ[i][j] = 0;
            }
        }
    }
 
    /**
     * metodo que insere um arco simétrico entre origem, destino e passando um custo
     * @param origem vertice de partida
     * @param destino vertice de destino
     * @param custo custo real
     */
    void inserirArestaSimetrica(String origem, String destino, int custo) {
        int indiceOrigem = this.listaVertices.indexOf(origem);
        int indiceDestino = this.listaVertices.indexOf(destino);
 
        if (this.matrizADJ[indiceOrigem][indiceDestino] == 0) {
            this.matrizADJ[indiceOrigem][indiceDestino] = custo;
            this.matrizADJ[indiceDestino][indiceOrigem] = custo;
        }
    }
 
    /**
     * metodo que insere um arco assimétrico entre origem, destino e passando um custo
     * @param origem vertice de partida
     * @param destino vertice de destino
     * @param custo custo real
     */
    void inserirAresta(String origem, String destino, int custo) {
        int indiceOrigem = this.listaVertices.indexOf(origem);
        int indiceDestino = this.listaVertices.indexOf(destino);
 
        if (this.matrizADJ[indiceOrigem][indiceDestino] == 0) {
            this.matrizADJ[indiceOrigem][indiceDestino] = custo;
        }
    }
 
    /**
     * metodo que mostra o grafo não grafico com os custos
     */
    void mostrarGrafo() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(this.listaVertices.get(i) + ": ");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matrizADJ[i][j] != 0) {
                    System.out.print(this.listaVertices.get(j) + "(" + this.matrizADJ[i][j] + ")\t");
                }
            }
        }
    }
}