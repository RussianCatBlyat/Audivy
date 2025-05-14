package com.Audivy.Audivy.dto;

import com.Audivy.Audivy.enums.UsuariosPlano;
import jakarta.validation.constraints.NotNull;

public record UsuariosDto(@NotNull String nmUsuario, @NotNull String dsEmail, @NotNull String dsSenha, @NotNull String tpUsuario, @NotNull UsuariosPlano dsPlano) {
}
