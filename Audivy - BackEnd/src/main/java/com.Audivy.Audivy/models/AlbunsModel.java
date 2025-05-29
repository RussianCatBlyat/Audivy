package com.Audivy.Audivy.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TBALBUNS")
public class AlbunsModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;

    private String nmTitulo;
    private Date dtLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference
    private UsuariosModel idUsuario;

    @OneToMany(mappedBy = "idAlbum")
    @JsonManagedReference
    private List<MusicasModel> dsMusicas;

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNmTitulo() {
        return nmTitulo;
    }

    public void setNmTitulo(String nmTitulo) {
        this.nmTitulo = nmTitulo;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public UsuariosModel getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuariosModel idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<MusicasModel> getDsMusicas() {
        return dsMusicas;
    }

    public void setDsMusicas(List<MusicasModel> dsMusicas) {
        this.dsMusicas = dsMusicas;
    }
}
