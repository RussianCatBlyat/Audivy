package com.Audivy.Audivy.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TBPLAYLISTMUSICAS")
public class PlaylistMusicasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylistMusica;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPlaylist")
    private PlaylistsModel idPlaylist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMusica")
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
