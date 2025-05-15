package com.Audivy.Audivy.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TBPLAYLISTS")
public class PlaylistsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;
    private String nmTitulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private UsuariosModel Usuario;

    @OneToMany(mappedBy = "Playlist")
    private List<PlaylistMusicasModel> playlistMusicas;

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public List<PlaylistMusicasModel> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public void setPlaylistMusicas(List<PlaylistMusicasModel> playlistMusicas) {
        this.playlistMusicas = playlistMusicas;
    }

    public UsuariosModel getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuariosModel usuario) {
        Usuario = usuario;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
    }
}
