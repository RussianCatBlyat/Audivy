package com.Audivy.Audivy.models;

import com.Audivy.Audivy.enums.UsuariosPlano;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TBUSUARIOS")
public class UsuariosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @OneToMany(mappedBy = "idUsuario")
    private List<PlaylistsModel> playlists;
    @OneToMany(mappedBy = "idUsuario")
    private List<AlbunsModel> albuns;
    @OneToMany(mappedBy = "idUsuario")
    private List<MusicasModel> musicas;

    private String nmUsuario;
    private String dsEmail;
    private String dsSenha;
    private String tpUsuario;
    private UsuariosPlano dsPlano;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosPlano getDsPlano() {
        return dsPlano;
    }

    public void setDsPlano(UsuariosPlano dsPlano) {
        this.dsPlano = dsPlano;
    }

    public String getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(String tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    public List<AlbunsModel> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<AlbunsModel> albuns) {
        this.albuns = albuns;
    }

    public List<PlaylistsModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistsModel> playlists) {
        this.playlists = playlists;
    }

    public List<MusicasModel> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<MusicasModel> musicas) {
        this.musicas = musicas;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }
}
