package com.Audivy.Audivy.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBALBUNS")
public class AlbunsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;
    private String nmTitulo;
    private Date dtLancamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private UsuariosModel Usuario;

    @OneToMany(mappedBy = "Album")
    private List<MusicasModel> Musicas;

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public UsuariosModel getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuariosModel usuario) {
        Usuario = usuario;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
    }

    public List<MusicasModel> getMusicas() {
        return Musicas;
    }

    public void setMusicas(List<MusicasModel> musicas) {
        Musicas = musicas;
    }
}
