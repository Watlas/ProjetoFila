package ExercicioFila_03.main;

import ExercicioFila_03.classses.Fila;
import ExercicioFila_03.classses.Pilha;

import java.util.Scanner;

public class executor {
    public static void main(String[] args) {
        Fila fila = null;
        Pilha pilha = new Pilha(100);

        Scanner ler = new Scanner(System.in);

        System.out.println("DIGITE A PALAVRA");
        System.out.print("> ");
        String p = ler.nextLine();
        int tam = p.length();
        fila = new Fila(tam);
        for (int i = 0; i < p.length(); i++) {

            pilha.inserir(p.charAt(i) + "");

        }
        Pilha pilha1 = new Pilha(pilha.quantidadeDeElementos());
        while (!pilha.estaVazia()) {
            String aux = pilha.consultar();
            if (aux.matches("[a-z]")) {
                pilha1.inserir(aux);
            }
            if (aux.matches("[1-9]")) {
                fila.enqueue(aux);
            }

            pilha.retirar();
        }

        while (!pilha1.estaVazia()) {
            String aux = pilha1.consultar();
            fila.enqueue(aux);
            pilha1.retirar();
        }

            System.out.println(fila.mostrar());


    }
}
