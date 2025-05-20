package com.Audivy.Audivy.repositories;

import com.Audivy.Audivy.models.AlbunsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AlbunsRepository extends JpaRepository<AlbunsModel, Integer> {
    Optional<AlbunsModel> findByIdAlbum(int idAlbum);

    Optional<AlbunsModel> findAllByIdAlbum(int idAlbum);
}
