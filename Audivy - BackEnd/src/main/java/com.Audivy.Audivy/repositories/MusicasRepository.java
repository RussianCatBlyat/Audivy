package com.Audivy.Audivy.repositories;

import com.Audivy.Audivy.models.MusicasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MusicasRepository extends JpaRepository<MusicasModel, Integer> {
    Optional<MusicasModel> findByIdMusica(int idMusica);

    Optional<MusicasModel> findAllByIdMusica(int idMusica);
}
