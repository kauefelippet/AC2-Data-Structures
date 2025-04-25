/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.*;

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

    public void navegarHistorico(ListaEncadeada listaReproducao, String escolha) {
        if (escolha.equalsIgnoreCase("A")) {
            if (numero_nos < 2) {
                JOptionPane.showMessageDialog(null, "Não há músicas anteriores no histórico.");
                return;
            }
            Musica musica = ultimo.getMusica();
            excluiNo(numero_nos - 1);
            listaReproducao.insereNo_inicio(new NoMusica(musica));
            JOptionPane.showMessageDialog(null, "Música anterior:\n" + ultimo.getMusica());
        } else if (escolha.equalsIgnoreCase("P")) {
            try {
                Musica proximaMusica = listaReproducao.getPrimeiro().getMusica();
                insereNo(new NoMusicaDuplo(proximaMusica));
                listaReproducao.excluiNo(proximaMusica.getTitulo());
                JOptionPane.showMessageDialog(null, "Próxima música:\n" + ultimo.getMusica());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não há músicas seguintes no histórico.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
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

    public NoMusicaDuplo pegarNo(int indice) {
        NoMusicaDuplo temp_no = primeiro;
        for (int i = 0; (i < indice) && (temp_no != null); i++)
            temp_no = temp_no.prox;
        return temp_no;
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

    public NoMusicaDuplo getUltimo() {
        return ultimo;
    }
}
