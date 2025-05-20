package com.Audivy.Audivy.dto;

import com.Audivy.Audivy.models.UsuariosModel;
import jakarta.validation.constraints.NotNull;

public record PlaylistsDto(@NotNull  String nmTitulo, @NotNull UsuariosModel idUsuario) {
}
