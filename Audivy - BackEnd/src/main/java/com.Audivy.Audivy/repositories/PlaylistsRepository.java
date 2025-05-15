package com.Audivy.Audivy.repositories;

import com.Audivy.Audivy.models.PlaylistsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlaylistsRepository extends JpaRepository<PlaylistsModel, Integer> {
    Optional<PlaylistsModel> findByIdPlaylist(int idPlaylist);

    Optional<PlaylistsModel> findAllByIdPlaylist(int idPlaylist);
}
