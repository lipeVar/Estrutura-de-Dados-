package Trabalho_final;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Criação da classe GerenciadorArquivos cujo unico objetivo é ler e escrever o arquivo
public class GerenciadorArquivo {
    
    // Método para ler o arquivo e devolver uma lista de figurinhas prontas
    public List<Figura> carregar(String nomeArquivo) {
        List<Figura> lista = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        
        // Se o arquivo não existir, devolvo a lista vazia.
        if (!arquivo.exists()) {
            return lista; 
        }

        // Uso o BufferedReader porque ele lê o arquivo linha por linha de forma eficiente
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            // Enquanto tiver linha para ler no arquivo...
            while ((linha = br.readLine()) != null) {
                // Chama método que converte o texto em um objeto Figura
                Figura f = Figura.fromCSV(linha);
                if (f != null) {
                    lista.add(f); // Adiciono na lista
                }
            }
        } catch (IOException e) {
            // Caso dê erro, mostro a mensagem para o usuário
            System.out.println("Erro ao carregar o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
        return lista;
    }

    // Método para pegar uma lista de figurinhas e salvar no arquivo
    public void salvar(List<Figura> lista, String nomeArquivo) {
        // Uso o BufferedWriter para escrever no arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Percorro todas as figurinhas da lista
            for (Figura f : lista) {
                bw.write(f.toCSV()); // Escrevo a versão em texto da figurinha
                bw.newLine(); 
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}