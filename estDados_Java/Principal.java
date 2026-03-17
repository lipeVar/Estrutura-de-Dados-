import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Aluno a = new Aluno(nome: "Maria de Souza Lima");
        ArrayList<Aluno> alunos = new ArrayList<>();
        try (//alunos.add(new Aluno(nome: "João Silva"));
                //alunos.add(new Aluno(nome: "Maria Oliveira"));
                //alunos.add(new Aluno(nome: "Carlos Pereira"));
        Scanner teclado = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Digite o nome do aluno: ");
                String nome = teclado.nextLine().toUpperCase();
                Aluno aluno = new Aluno(nome);
                if (!alunos.contains(aluno)) {
                    alunos.add(aluno);
                }
            }
        }
        alunos.sort((a1, a2) -> a1.nome.compareTo(a2.nome));
        //ListaAlunos.sort((comparador.comparing(a ->)))
        
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}