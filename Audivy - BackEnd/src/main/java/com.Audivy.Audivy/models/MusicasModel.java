package com.Audivy.Audivy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

import java.io.Serializable;

@Entity
@Table(name = "TBMUSICAS")
public class MusicasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusica;

    private String nmTitulo;
    private String dsDuracao;
    private String arqAudio;
    private String dsGenero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlbum")
    @JsonBackReference
    private AlbunsModel idAlbum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    @JsonBackReference
    private UsuariosModel idUsuario;

    @OneToMany(mappedBy = "idMusica")
    @JsonManagedReference
    private List<PlaylistMusicasModel> playlistMusicas;

    public Integer getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Integer idMusica) {
        this.idMusica = idMusica;
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

    public AlbunsModel getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(AlbunsModel idAlbum) {
        this.idAlbum = idAlbum;
    }

    public UsuariosModel getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuariosModel idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<PlaylistMusicasModel> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public void setPlaylistMusicas(List<PlaylistMusicasModel> playlistMusicas) {
        this.playlistMusicas = playlistMusicas;
    }
}
