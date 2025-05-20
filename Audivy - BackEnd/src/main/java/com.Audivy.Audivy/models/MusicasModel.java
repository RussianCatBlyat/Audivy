package com.Audivy.Audivy.models;

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
    private AlbunsModel Album;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private UsuariosModel Usuario;

    @OneToMany(mappedBy = "Musica")
    private List<PlaylistMusicasModel> playlistMusicas;

    public Integer getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Integer idMusica) {
        this.idMusica = idMusica;
    }

    public List<PlaylistMusicasModel> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public void setPlaylistMusicas(List<PlaylistMusicasModel> playlistMusicas) {
        this.playlistMusicas = playlistMusicas;
    }

    public AlbunsModel getAlbum() {
        return Album;
    }

    public void setAlbum(AlbunsModel album) {
        Album = album;
    }

    public UsuariosModel getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuariosModel usuario) {
        Usuario = usuario;
    }

    public String getDsGenero() {
        return dsGenero;
    }

    public void setDsGenero(String dsGenero) {
        this.dsGenero = dsGenero;
    }

    public String getDsDuracao() {
        return dsDuracao;
    }

    public void setDsDuracao(String dsDuracao) {
        this.dsDuracao = dsDuracao;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
    }

    public String getArqAudio() {
        return arqAudio;
    }

    public void setArqAudio(String arqAudio) {
        this.arqAudio = arqAudio;
    }
}
