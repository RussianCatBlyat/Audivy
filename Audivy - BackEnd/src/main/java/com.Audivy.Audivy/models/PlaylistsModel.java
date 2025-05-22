package com.Audivy.Audivy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private UsuariosModel idUsuario;

    @OneToMany(mappedBy = "idPlaylist")
    @JsonManagedReference
    private List<PlaylistMusicasModel> playlistMusicas;

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
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
