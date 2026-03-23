import java.io.*;
import java.util.*;

public class Main {
    //Estação
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
            
            default:
                return "Inverno";
        }
    }
    //Precipitação

    public static int valorPrecipitacao(String p) {

        switch (p) {
            case "Nada": return 0;
            case "Pouca": return 1;
            case "Media": return 2;
            case "Muita": return 3;
                
            default:
                return 0;
        }
    }
    // temperatura
    public static int valorTemp(String t) {
        switch (t) {
            case "Frio": return 0;
            case "Ameno": return 1;
            case "Quente": return 3;
        
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        //Inicio da lista
        ArrayList<Clima> lista = new ArrayList<>();

        //Leitura de arquivo
        String linha;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lfvar\\OneDrive\\Documentos\\GitHub\\Estrutura-de-Dados\\Desafios\\dadosClimaticos.csv"));

            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(",");

                lista.add(new Clima(p[0], p[1], p[2], p[3]));
            }
        br.close();
        } catch(Exception e) {
            System.out.println("Erroooo!!" + e.getMessage());
        }
        //Contadores
        int chuvaVe = 0, chuvaOu = 0, chuvaIn = 0;
        int tempVe = 0, tempOu = 0, tempIn = 0;
        
    }
}
