package com.Audivy.Audivy.dto;

import com.Audivy.Audivy.models.MusicasModel;
import com.Audivy.Audivy.models.PlaylistsModel;
import jakarta.validation.constraints.NotNull;

public record PlaylistMusicasDto(@NotNull PlaylistsModel Playlist, @NotNull MusicasModel Musica) {
}
