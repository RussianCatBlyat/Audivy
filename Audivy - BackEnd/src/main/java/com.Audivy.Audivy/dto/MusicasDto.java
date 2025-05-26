package com.Audivy.Audivy.dto;

import com.Audivy.Audivy.models.AlbunsModel;
import com.Audivy.Audivy.models.UsuariosModel;
import jakarta.validation.constraints.NotNull;

public record MusicasDto(
        @NotNull String nmTitulo,
        @NotNull String dsDuracao,
        @NotNull String arqAudio,
        @NotNull String dsGenero,
        @NotNull AlbunsModel idAlbum,
        @NotNull UsuariosModel idUsuario) {
}