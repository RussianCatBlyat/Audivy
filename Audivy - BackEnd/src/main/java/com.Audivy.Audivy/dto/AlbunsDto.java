package com.Audivy.Audivy.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AlbunsDto(@NotNull String nmTitulo, @NotNull Date dtLancamento, @NotNull Integer idArtista) {
}


