package com.Audivy.Audivy.models;

import com.Audivy.Audivy.enums.UsuariosPlano;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TBUSUARIOS")
public class UsuariosModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nmUsuario;
    private String dsEmail;
    private String dsSenha;
    private String tpUsuario;
    private UsuariosPlano dsPlano;

    @OneToMany(mappedBy = "idUsuario")
    @JsonManagedReference
    private List<PlaylistsModel> dsPlaylists;
    @OneToMany(mappedBy = "idUsuario")
    @JsonManagedReference
    private List<AlbunsModel> dsAlbuns;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<PlaylistsModel> getDsPlaylists() {
        return dsPlaylists;
    }

    public void setDsPlaylists(List<PlaylistsModel> dsPlaylists) {
        this.dsPlaylists = dsPlaylists;
    }

    public List<AlbunsModel> getDsAlbuns() {
        return dsAlbuns;
    }

    public void setDsAlbuns(List<AlbunsModel> dsAlbuns) {
        this.dsAlbuns = dsAlbuns;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(String tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    public UsuariosPlano getDsPlano() {
        return dsPlano;
    }

    public void setDsPlano(UsuariosPlano dsPlano) {
        this.dsPlano = dsPlano;
    }
}
