package com.Audivy.Audivy.dto;

import jakarta.validation.constraints.NotNull;

public record PlaylistsDto(@NotNull  String nmTitulo, @NotNull Integer idUsuario) {
}
