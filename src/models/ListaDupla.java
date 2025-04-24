/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author bruno
 */
public class ListaDupla {
    NoMusicaDuplo primeiro, ultimo;
    int numero_nos;
    
    public ListaDupla(){
    primeiro = ultimo = null;
    numero_nos = 0;
    }
    
    void insereNo (NoMusicaDuplo novoNo){
        novoNo.prox = null;
        novoNo.ant = ultimo;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }
    NoMusicaDuplo pegarNo (int indice){
        NoMusicaDuplo temp_no = primeiro;
        for (int i = 0; (i < indice) && (temp_no != null); i++)
        temp_no = temp_no.prox;
        return temp_no;
    }
    void incluiNo (NoMusicaDuplo novoNo, int indice){
        NoMusicaDuplo temp_no = pegarNo (indice);
        novoNo.prox = temp_no;
        if (novoNo.prox != null){
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
    void excluiNo (int indice){
        if (indice == 0){
            primeiro = primeiro.prox;
        if (primeiro != null)
            primeiro.ant = null;
        }else{
            NoMusicaDuplo temp_no = pegarNo (indice);
            temp_no.ant.prox = temp_no.prox;
            if (temp_no != ultimo){
                temp_no.prox.ant = temp_no.ant;
            }else{
                ultimo = temp_no;
            }
        }
        numero_nos--;
    }
    String ExibeLista(){
        String valores="As múscas existentes no histórico são:\n";
        NoMusicaDuplo temp_no = primeiro;
        while (temp_no != null){
            valores += temp_no.toString() + "\n";
            temp_no = temp_no.prox;
        }
        return valores;
    }
}
