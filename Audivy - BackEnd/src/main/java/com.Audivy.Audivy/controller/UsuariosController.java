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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value ="id") int id) {
        Optional<UsuariosModel> Usuarios0 = usuariosRepository.findById(id);
        if (Usuarios0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Usuarios0.get());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> inserirUsuario(@PathVariable(value = "id") int id, @RequestBody @Valid UsuariosDto UsuariosDto) {

        Optional<UsuariosModel> Usuarios0 = usuariosRepository.findById(id);
        if (Usuarios0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não Encontrado");

        }
        var UsuarioModel = new UsuariosModel();
        BeanUtils.copyProperties(UsuariosDto, UsuarioModel);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuariosRepository.save(UsuarioModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value ="id") int id) {
        Optional<UsuariosModel> Usuario0 = usuariosRepository.findAllById(id);
        if (Usuario0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario não encontrado");
        }
        usuariosRepository.delete(Usuario0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario removido");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable(value = "id") int id, @RequestBody UsuariosDto usuariosDto) {
        Optional<UsuariosModel> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        UsuariosModel usuarioModel = usuarioOptional.get();
        BeanUtils.copyProperties(usuariosDto, usuarioModel);
        UsuariosModel usuarioAtualizado = usuariosRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }

}
