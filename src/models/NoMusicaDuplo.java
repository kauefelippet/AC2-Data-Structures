/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author bruno
 */
public class NoMusicaDuplo {
    Musica musica;
    NoMusicaDuplo ant;
    NoMusicaDuplo prox;

    public NoMusicaDuplo(Musica musica) {
        this.musica = musica;
        this.ant = null;
        this.prox = null;
    }
}
