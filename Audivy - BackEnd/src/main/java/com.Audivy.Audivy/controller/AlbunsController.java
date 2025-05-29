package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.AlbunsDto;
import com.Audivy.Audivy.models.AlbunsModel;
import com.Audivy.Audivy.models.UsuariosModel;
import com.Audivy.Audivy.repositories.AlbunsRepository;
import com.Audivy.Audivy.repositories.UsuariosRepository;
import jakarta.validation.Valid;
import jdk.internal.org.objectweb.asm.tree.analysis.BasicInterpreter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Albuns")
public class AlbunsController {

    BasicInterpreter entityManager;

    @Autowired
    AlbunsRepository albunsRepository;
    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity<List<AlbunsModel>> getAllAlbum() {
        return ResponseEntity.status(HttpStatus.OK).body(albunsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<AlbunsModel> saveAlbum(@RequestBody @Valid AlbunsDto albunsDto) {
        Optional<UsuariosModel> usuarioOptional = usuariosRepository.findById(albunsDto.idUsuario());
        var AlbumModel = new AlbunsModel();
        AlbumModel.setNmTitulo(albunsDto.nmTitulo());
        AlbumModel.setDtLancamento(albunsDto.dtLancamento());
        AlbumModel.setIdUsuario(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(albunsRepository.save(AlbumModel));
    }

    @GetMapping("/{idAlbum}")
    public ResponseEntity<Object> getOneAlbum(@PathVariable(value ="idAlbum") int idAlbum) {
        Optional<AlbunsModel> Albuns0 = albunsRepository.findById(idAlbum);
        if (Albuns0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Albuns0.get());
    }

    @DeleteMapping("/{idAlbum}")
    public ResponseEntity<Object> deleteAlbum(@PathVariable(value ="idAlbum") int idAlbum) {
        Optional<AlbunsModel> Album0 = albunsRepository.findById(idAlbum);
        if (Album0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Album não encontrado");
        }
        albunsRepository.delete(Album0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Album removido");
    }

    @PutMapping("/{idAlbum}")
    public ResponseEntity<Object> atualizarAlbum(@PathVariable(value = "idAlbum") int idAlbum, @RequestBody AlbunsDto albunsDto) {
        Optional<AlbunsModel> albumOptional = albunsRepository.findById(idAlbum);
        if (albumOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album não encontrado");
        }
        AlbunsModel albumModel = albumOptional.get();
        BeanUtils.copyProperties(albunsDto, albumModel);
        AlbunsModel albumAtualizado = albunsRepository.save(albumModel);
        return ResponseEntity.status(HttpStatus.OK).body(albumAtualizado);
    }

}
