package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.PlaylistMusicasDto;
import com.Audivy.Audivy.models.PlaylistMusicasModel;
import com.Audivy.Audivy.repositories.PlaylistMusicasRepository;
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
@RequestMapping("/PlaylistMusicas")
public class PlaylistMusicasController {

    @Autowired
    PlaylistMusicasRepository playlistmusicasRepository;

    @GetMapping
    public ResponseEntity<List<PlaylistMusicasModel>> getAllPlaylistMusica() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistmusicasRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<PlaylistMusicasModel> savePlaylistMusica(@RequestBody @Valid PlaylistMusicasDto playlistmusicasDto) {
        var PlaylistMusicaModel = new PlaylistMusicasModel();
        BeanUtils.copyProperties(playlistmusicasDto, PlaylistMusicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistmusicasRepository.save(PlaylistMusicaModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePlaylistMusica(@PathVariable(value ="id") int id) {
        Optional<PlaylistMusicasModel> PlaylistMusicas0 = playlistmusicasRepository.findById(id);
        if (PlaylistMusicas0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlaylistMusica não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(PlaylistMusicas0.get());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> inserirPlaylistMusica(@PathVariable(value = "id") int id, @RequestBody @Valid PlaylistMusicasDto PlaylistMusicasDto) {

        Optional<PlaylistMusicasModel> PlaylistMusicas0 = playlistmusicasRepository.findById(id);
        if (PlaylistMusicas0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlaylistMusica não Encontrado");

        }
        var PlaylistMusicaModel = new PlaylistMusicasModel();
        BeanUtils.copyProperties(PlaylistMusicasDto, PlaylistMusicaModel);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(playlistmusicasRepository.save(PlaylistMusicaModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylistMusica(@PathVariable(value ="id") int id) {
        Optional<PlaylistMusicasModel> PlaylistMusica0 = playlistmusicasRepository.findAllById(id);
        if (PlaylistMusica0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("PlaylistMusica não encontrado");
        }
        playlistmusicasRepository.delete(PlaylistMusica0.get());
        return ResponseEntity.status(HttpStatus.OK).body("PlaylistMusica removido");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPlaylistMusica(@PathVariable(value = "id") int id, @RequestBody PlaylistMusicasDto playlistmusicasDto) {
        Optional<PlaylistMusicasModel> playlistmusicaOptional = playlistmusicasRepository.findById(id);
        if (playlistmusicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlaylistMusica não encontrado");
        }
        PlaylistMusicasModel playlistmusicaModel = playlistmusicaOptional.get();
        BeanUtils.copyProperties(playlistmusicasDto, playlistmusicaModel);
        PlaylistMusicasModel playlistmusicaAtualizado = playlistmusicasRepository.save(playlistmusicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(playlistmusicaAtualizado);
    }

}
