package com.Audivy.Audivy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TBPLAYLISTMUSICAS")
public class PlaylistMusicasModel   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylistMusica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference
    private PlaylistsModel idPlaylist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMusica", nullable = false)
    @JsonBackReference
    private MusicasModel idMusica;

    public Integer getIdPlaylistMusica() {
        return idPlaylistMusica;
    }

    public void setIdPlaylistMusica(Integer idPlaylistMusica) {
        this.idPlaylistMusica = idPlaylistMusica;
    }

    public PlaylistsModel getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(PlaylistsModel idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public MusicasModel getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(MusicasModel idMusica) {
        this.idMusica = idMusica;
    }
}
