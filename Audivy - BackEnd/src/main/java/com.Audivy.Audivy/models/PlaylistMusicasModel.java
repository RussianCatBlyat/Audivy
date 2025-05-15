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
    private PlaylistsModel Playlist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMusica")
    private MusicasModel Musica;

    public Integer getIdPlaylistMusica() {
        return idPlaylistMusica;
    }

    public void setIdPlaylistMusica(Integer idPlaylistMusica) {
        this.idPlaylistMusica = idPlaylistMusica;
    }

    public PlaylistsModel getPlaylist() {
        return Playlist;
    }

    public void setPlaylist(PlaylistsModel playlist) {
        Playlist = playlist;
    }

    public MusicasModel getMusica() {
        return Musica;
    }

    public void setMusica(MusicasModel musica) {
        Musica = musica;
    }
}
