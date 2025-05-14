package com.Audivy.Audivy.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBMUSICAS")
public class MusicasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nmTitulo;
    private String dsDuracao;
    private String arqAudio;
    private String dsGenero;
    private String idAlbum;
    private String idArtista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
    }

    public String getDsDuracao() {
        return dsDuracao;
    }

    public void setDsDuracao(String dsDuracao) {
        this.dsDuracao = dsDuracao;
    }

    public String getArqAudio() {
        return arqAudio;
    }

    public void setArqAudio(String arqAudio) {
        this.arqAudio = arqAudio;
    }

    public String getDsGenero() {
        return dsGenero;
    }

    public void setDsGenero(String dsGenero) {
        this.dsGenero = dsGenero;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }
}
