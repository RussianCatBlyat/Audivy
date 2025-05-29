package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.MusicasDto;
import com.Audivy.Audivy.models.AlbunsModel;
import com.Audivy.Audivy.models.MusicasModel;
import com.Audivy.Audivy.models.UsuariosModel;
import com.Audivy.Audivy.repositories.AlbunsRepository;
import com.Audivy.Audivy.repositories.MusicasRepository;
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
@RequestMapping("/Musicas")
public class MusicasController {

    @Autowired
    MusicasRepository musicasRepository;
    @Autowired
    UsuariosRepository usuariosRepository;
    @Autowired
    AlbunsRepository albunsRepository;

    @GetMapping
    public ResponseEntity<List<MusicasModel>> getAllMusica() {
        return ResponseEntity.status(HttpStatus.OK).body(musicasRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<MusicasModel> saveMusica(@RequestBody @Valid MusicasDto musicasDto) {
        Optional<AlbunsModel> albumOptional = albunsRepository.findById(musicasDto.idAlbum());
        Optional<UsuariosModel> usuarioOptional = usuariosRepository.findById(musicasDto.idUsuario());
        var MusicaModel = new MusicasModel();
        MusicaModel.setNmTitulo(musicasDto.nmTitulo());
        MusicaModel.setDsDuracao(musicasDto.dsDuracao());
        MusicaModel.setArqAudio(musicasDto.arqAudio());
        MusicaModel.setDsGenero(musicasDto.dsGenero());
        MusicaModel.setIdAlbum(albumOptional.get());
        MusicaModel.setIdUsuario(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(musicasRepository.save(MusicaModel));
    }

    @GetMapping("/{idMusica}")
    public ResponseEntity<Object> getOneMusica(@PathVariable(value ="idMusica") int idMusica) {
        Optional<MusicasModel> Musicas0 = musicasRepository.findById(idMusica);
        if (Musicas0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Musicas0.get());
    }

    @DeleteMapping("/{idMusica}")
    public ResponseEntity<Object> deleteMusica(@PathVariable(value ="idMusica") int idMusica) {
        Optional<MusicasModel> Musica0 = musicasRepository.findById(idMusica);
        if (Musica0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Musica não encontrado");
        }
        musicasRepository.delete(Musica0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Musica removido");
    }

    @PutMapping("/{idMusica}")
    public ResponseEntity<Object> atualizarMusica(@PathVariable(value = "idMusica") int idMusica, @RequestBody MusicasDto musicasDto) {
        Optional<MusicasModel> musicaOptional = musicasRepository.findById(idMusica);
        if (musicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não encontrado");
        }
        MusicasModel musicaModel = musicaOptional.get();
        BeanUtils.copyProperties(musicasDto, musicaModel);
        MusicasModel musicaAtualizado = musicasRepository.save(musicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(musicaAtualizado);
    }

}
