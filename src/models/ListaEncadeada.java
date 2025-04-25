/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.JOptionPane;

/**
 * @author bruno, edited by Kauê
 */
public class ListaEncadeada {
    private NoMusica primeiro, ultimo;
    private int numero_nos = 0;

    public ListaEncadeada() {
        primeiro = ultimo = null;
    }

    public void insereNo_fim(NoMusica novoNo) {
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    public void adicionarMusica(String titulo, String artista, int duracao) {
        Musica nova = new Musica(titulo, artista, duracao);
        insereNo_fim(new NoMusica(nova));
        JOptionPane.showMessageDialog(null, "Música adicionada à fila!");
    }

    public void tocarProximaMusica(ListaDupla historico) {
        try {
            Musica ultimaMusica = getPrimeiro().getMusica();
            historico.insereNo(new NoMusicaDuplo(ultimaMusica));
            excluiNo(ultimaMusica.getTitulo());
            JOptionPane.showMessageDialog(null, "Tocando: \n" + ultimaMusica);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A lista de reprodução está vazia!");
        }
    }

    public void insereNo_inicio(NoMusica novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    public void excluiNo(String titulo) {
        NoMusica temp_no = primeiro;
        NoMusica anterior_no = null;
        while (temp_no != null && !temp_no.musica.getTitulo().equals(titulo)) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no)
            ultimo = anterior_no;
    }

    public String exibeLista() {
        StringBuilder saida = new StringBuilder();
        NoMusica temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            saida.append(i+1).append(" - ").append(temp_no.musica).append("\n");
            temp_no = temp_no.prox;
            i++;
        }

        return saida.toString();
    }

    public NoMusica getPrimeiro() {
        return primeiro;
    }
}
