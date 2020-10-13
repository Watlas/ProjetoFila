/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

/**
 * @author watla
 */
public class Fila {

    int tamanho;
    int inicio;
    int fim;
    int quantidadeDeElementos;
    int[] array;

    public Fila(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho tem que ser > 0");
        }

        this.tamanho = tamanho;
        this.array = new int[tamanho];
        inicio = 0;
        fim = 0;
        quantidadeDeElementos = 0;

    }

    public boolean empty() {

        return quantidadeDeElementos == 0;
    }

    public int size() {
        return quantidadeDeElementos;
    }


    public void enqueue(int elemento) {
        if (quantidadeDeElementos == tamanho) {
            throw new RuntimeException("Fila CHEAIA");
        }
        array[fim] = elemento;
        fim = (fim + 1) % tamanho;
    }


    public void dequeue() {
        if (!empty()) {
            throw new RuntimeException("Fila Vazia");
        }
        inicio = (inicio + 1) % tamanho;
        quantidadeDeElementos--;
    }

    public int peek() {
        if (!empty()) {
            return array[inicio];
        }
        throw new RuntimeException("fila vazia");
    }

    public void destroy() {
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }


    public String mostrar() {
        String elementos = "";
        for (int i = inicio; i <= fim; i++) {
            elementos += array[i] + " - ";
        }
        return elementos;

    }

    public static void main(String[] args) {
        Fila f = new Fila(4);
        f.enqueue(10);
        f.enqueue(12);


        String aux = f.mostrar();
        System.out.println(aux);
        f.dequeue();
        f.mostrar();

    }
}
