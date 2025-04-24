/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author bruno
 */
public class NoMusica {
    Musica musica;
    NoMusica prox;

    public NoMusica(Musica musica) {
        this.musica = musica;
        this.prox = null;
    }
}
