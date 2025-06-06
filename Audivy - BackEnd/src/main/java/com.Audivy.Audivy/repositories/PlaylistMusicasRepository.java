package com.Audivy.Audivy.repositories;

import com.Audivy.Audivy.models.PlaylistMusicasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlaylistMusicasRepository extends JpaRepository<PlaylistMusicasModel, Integer> {
    Optional<PlaylistMusicasModel> findByIdPlaylistMusica(int idPlaylistMusica);

    Optional<PlaylistMusicasModel> findAllByIdPlaylistMusica(int idPlaylistMusica);
}
