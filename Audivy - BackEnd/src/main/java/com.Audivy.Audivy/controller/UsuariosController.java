package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.UsuariosDto;
import com.Audivy.Audivy.models.UsuariosModel;
import com.Audivy.Audivy.repositories.UsuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Usuarios")
public class UsuariosController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity<List<UsuariosModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuariosModel> saveUsuario(@RequestBody @Valid UsuariosDto usuariosDto) {
        var UsuarioModel = new UsuariosModel();
        BeanUtils.copyProperties(usuariosDto, UsuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosRepository.save(UsuarioModel));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value ="idUsuario") int idUsuario) {
        Optional<UsuariosModel> Usuarios0 = usuariosRepository.findById(idUsuario);
        if (Usuarios0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Usuarios0.get());
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value ="idUsuario") int idUsuario) {
        Optional<UsuariosModel> Usuario0 = usuariosRepository.findById(idUsuario);
        if (Usuario0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario não encontrado");
        }
        usuariosRepository.delete(Usuario0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario removido");
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable(value = "idUsuario") int idUsuario, @RequestBody UsuariosDto usuariosDto) {
        Optional<UsuariosModel> usuarioOptional = usuariosRepository.findById(idUsuario);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        UsuariosModel usuarioModel = usuarioOptional.get();
        BeanUtils.copyProperties(usuariosDto, usuarioModel);
        UsuariosModel usuarioAtualizado = usuariosRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }

}
