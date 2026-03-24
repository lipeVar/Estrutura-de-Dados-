import java.io.*;
import java.util.*;

public class Main {
    // Estação
    public static String getEstacao(String mes) {
        switch (mes) {
            case "Dezembro":
            case "Janeiro":
            case "Fevereiro":
            case "Março":
                return "Verão";
        
            case "Abril":
            case "Maio":
            case "Junho":
            case "Julho":
                return "Outono";
            
            // O código original agrupa o resto dos meses no Inverno
            default:
                return "Inverno"; 
        }
    }
    
    // Precipitação
    public static int valorPrecipitacao(String p) {
        switch (p) {
            case "Nada": return 0;
            case "Pouca": return 1;
            case "Média": return 2;
            case "Muita": return 3;
            default: return 0;
        }
    }
    
    // Temperatura
    public static int valorTemp(String t) {
        switch (t) {
            case "Frio": return 0;
            case "Ameno": return 1;
            case "Quente": return 3;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        // Inicio da lista
        ArrayList<Clima> lista = new ArrayList<>();

        // Leitura de arquivo
        String linha;
        try {
            BufferedReader br = new BufferedReader(new FileReader("dadosClimaticos.csv"));

            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(",");
                // p[0] = ano, p[1] = mes, p[2] = temperatura, p[3] = precipitacao
                lista.add(new Clima(p[0], p[1], p[2], p[3]));
            }
            br.close();
        } catch(Exception e) {
            System.out.println("Erroooo!!" + e.getMessage());
        }
        
        // Contadores
        int chuvaVe = 0, chuvaOu = 0, chuvaIn = 0;
        int tempVe = 0, tempOu = 0, tempIn = 0;
        
        System.out.println("===== Dados do Arquivo =====");
        
        // Imprime o arquivo e acumula os valores
        for(Clima c : lista) {
            System.out.println(c);

            String estacao = getEstacao(c.mes);
            int valorChuva = valorPrecipitacao(c.precipitacao);
            int valorTemp = valorTemp(c.temperatura);

            switch (estacao) {
                case "Verão":
                    chuvaVe += valorChuva;
                    tempVe += valorTemp;
                    break;
                case "Outono":
                    chuvaOu += valorChuva;
                    tempOu += valorTemp;
                    break;
                case "Inverno":
                    chuvaIn += valorChuva;
                    tempIn += valorTemp;
                    break;
            }
        }

        // === NOVA LÓGICA: Encontrar os Máximos e Mínimos ===
        
        String maisChove = "", menosChove = "";
        String maisQuente = "", menosQuente = "";

        // Inicializamos com valores extremos para garantir que sejam substituídos na primeira verificação
        int maxChuva = -1, minChuva = Integer.MAX_VALUE;
        int maxTemp = -1, minTemp = Integer.MAX_VALUE;

        // Arrays para facilitar a comparação
        String[] estacoes = {"Verão", "Outono", "Inverno"};
        int[] valoresChuva = {chuvaVe, chuvaOu, chuvaIn};
        int[] valoresTemp = {tempVe, tempOu, tempIn};

        for (int i = 0; i < 3; i++) {
            // Verifica a chuva
            if (valoresChuva[i] > maxChuva) {
                maxChuva = valoresChuva[i];
                maisChove = estacoes[i];
            }
            if (valoresChuva[i] < minChuva) {
                minChuva = valoresChuva[i];
                menosChove = estacoes[i];
            }

            // Verifica a temperatura
            if (valoresTemp[i] > maxTemp) {
                maxTemp = valoresTemp[i];
                maisQuente = estacoes[i];
            }
            if (valoresTemp[i] < minTemp) {
                minTemp = valoresTemp[i];
                menosQuente = estacoes[i];
            }
        }

        // Exibir o resultado final da atividade
        System.out.println("\n=== Resultados da Análise ===");
        System.out.println("Estação que MAIS chove: " + maisChove + " (Pontuação: " + maxChuva + ")");
        System.out.println("Estação que MENOS chove: " + menosChove + " (Pontuação: " + minChuva + ")");
        System.out.println("Estação MAIS quente: " + maisQuente + " (Pontuação: " + maxTemp + ")");
        System.out.println("Estação MENOS quente: " + menosQuente + " (Pontuação: " + minTemp + ")");
    }
}