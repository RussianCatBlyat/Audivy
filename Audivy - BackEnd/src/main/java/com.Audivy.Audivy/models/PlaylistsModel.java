package com.Audivy.Audivy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TBPLAYLISTS")
public class PlaylistsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;

    private String nmTitulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference
    private UsuariosModel idUsuario;

    @OneToMany(mappedBy = "idPlaylist")
    @JsonManagedReference
    private List<PlaylistMusicasModel> dsplaylistMusicas;

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

    public List<PlaylistMusicasModel> getDsplaylistMusicas() {
        return dsplaylistMusicas;
    }

    public void setDsplaylistMusicas(List<PlaylistMusicasModel> dsplaylistMusicas) {
        this.dsplaylistMusicas = dsplaylistMusicas;
    }
}
