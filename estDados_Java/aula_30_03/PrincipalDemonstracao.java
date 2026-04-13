package aula_30_03;
import java.util.ArrayList;
import java.util.Stack;

public class PrincipalDemonstracao {
    public static void main(String[] args) {
        // Coleções
        // List, Arraylist, Linkedlist
        Arraylist<String> lista = new Arraylist<>();
        lista.add("ED");
        lista.add("IA");
        System.out.println(lista.size());
        System.out.println(lista.isEmpty());
        lista.remove("ED");
        System.out.println(lista.contains("PRD"));
        //Stack - pilha -> topo, push/add e  pop/remove
        // LIPO -> Last in, First out. O ultimo elemento a entrar é o primeiro a sair
        Stack<String> pilha = new Stack<>();
        pilha.push("joao");
        pilha.push("messias");
        pilha.push("luiz");
        pilha.push("Zorzi");

        System.out.println(pilha);
        System.out.println(pilha.peek());
        pilha.pop();
        System.out.println(pilha);


        //Queue - fila -> inicio/cabeça/head e fim/cauda/tail, add e remove
    }
}
