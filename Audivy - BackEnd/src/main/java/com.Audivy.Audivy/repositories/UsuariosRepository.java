package com.Audivy.Audivy.repositories;

import com.Audivy.Audivy.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer> {
    Optional<UsuariosModel> findByIdUsuario(int idUsuario);

    Optional<UsuariosModel> findAllByIdUsuario(int idUsuario);
}
