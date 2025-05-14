package com.Audivy.Audivy.dto;

import jakarta.validation.constraints.NotNull;

public record PlaylistMusicasDto(@NotNull Integer idPlaylist, @NotNull Integer idMusica) {
}
