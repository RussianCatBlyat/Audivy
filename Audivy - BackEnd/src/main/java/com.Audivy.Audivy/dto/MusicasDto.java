package com.Audivy.Audivy.dto;

import jakarta.validation.constraints.NotNull;

public record MusicasDto(
        @NotNull String nmTitulo,
        @NotNull String dsDuracao,
        @NotNull String arqAudio,
        @NotNull String dsGenero,
        @NotNull Integer idAlbum,
        @NotNull Integer idUsuario) {
}