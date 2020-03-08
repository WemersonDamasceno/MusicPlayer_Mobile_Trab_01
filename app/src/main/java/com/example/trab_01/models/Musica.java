package com.example.trab_01.models;

import com.example.trab_01.R;

public class Musica {
    String nome;
    String artista;
    String album;
    String duracao;
    public int id;


    public Musica(String nome, String artista, String album, String duracao, int save) {
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
        id = save;
    }

    public String getDuracao() {
        return duracao+" minutos";
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
}
