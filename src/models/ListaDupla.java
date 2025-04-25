/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * @author bruno
 */
public class ListaDupla {
    private NoMusicaDuplo primeiro, ultimo;
    private int numero_nos;

    public ListaDupla() {
        primeiro = ultimo = null;
        numero_nos = 0;
    }

    public void insereNo(NoMusicaDuplo novoNo) {
        novoNo.prox = null;
        novoNo.ant = ultimo;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    public NoMusicaDuplo pegarNo(int indice) {
        NoMusicaDuplo temp_no = primeiro;
        for (int i = 0; (i < indice) && (temp_no != null); i++)
            temp_no = temp_no.prox;
        return temp_no;
    }

    public void incluiNo(NoMusicaDuplo novoNo, int indice) {
        NoMusicaDuplo temp_no = pegarNo(indice);
        novoNo.prox = temp_no;
        if (novoNo.prox != null) {
            novoNo.ant = temp_no.ant;
            novoNo.prox.ant = novoNo;
        } else {
            novoNo.ant = ultimo;
            ultimo = novoNo;
        }
        if (indice == 0)
            primeiro = novoNo;
        else
            novoNo.ant.prox = novoNo;
        numero_nos++;
    }

    public void excluiNo(int indice) {
        if (indice == 0) {
            primeiro = primeiro.prox;
            if (primeiro != null) {
                primeiro.ant = null;
            } else {
                ultimo = null;
            }
        } else {
            NoMusicaDuplo temp_no = pegarNo(indice);
            temp_no.ant.prox = temp_no.prox;
            if (temp_no.prox != null) {
                temp_no.prox.ant = temp_no.ant;
            } else {
                ultimo = temp_no.ant;
            }
        }
        numero_nos--;
    }

    public String ExibeLista() {
        StringBuilder valores = new StringBuilder("Histórico:\n");
        NoMusicaDuplo temp_no = primeiro;
        while (temp_no != null) {
            valores.append(temp_no.getMusica()).append("\n");
            temp_no = temp_no.prox;
        }
        return valores.toString();
    }

    public NoMusicaDuplo getPrimeiro() {
        return primeiro;
    }

    public NoMusicaDuplo getUltimo() {
        return ultimo;
    }

    public int getNumero_nos() {
        return numero_nos;
    }
}
