package com.Audivy.Audivy.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TBMUSICAS")
public class MusicasModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusica;

    private String nmTitulo;
    private String dsDuracao;
    private String arqAudio;
    private String dsGenero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlbum")
    private AlbunsModel idAlbum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuariosModel idUsuario;

    @OneToMany(mappedBy = "idMusica")
    private List<PlaylistMusicasModel> dsplaylistMusicas;

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

    public List<PlaylistMusicasModel> getDsplaylistMusicas() {
        return dsplaylistMusicas;
    }

    public void setDsplaylistMusicas(List<PlaylistMusicasModel> dsplaylistMusicas) {
        this.dsplaylistMusicas = dsplaylistMusicas;
    }
}
