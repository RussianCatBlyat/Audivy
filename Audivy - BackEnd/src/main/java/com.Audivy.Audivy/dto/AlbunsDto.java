package com.Audivy.Audivy.dto;

import com.Audivy.Audivy.models.UsuariosModel;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AlbunsDto(
        @NotNull String nmTitulo,
        @NotNull Date dtLancamento,
        @NotNull UsuariosModel idUsuario) {
}


