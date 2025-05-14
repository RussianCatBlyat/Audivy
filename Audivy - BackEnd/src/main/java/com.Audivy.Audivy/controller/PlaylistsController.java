package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.PlaylistsDto;
import com.Audivy.Audivy.models.PlaylistsModel;
import com.Audivy.Audivy.repositories.PlaylistsRepository;
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
@RequestMapping("/Playlists")
public class PlaylistsController {

    @Autowired
    PlaylistsRepository playlistsRepository;

    @GetMapping
    public ResponseEntity<List<PlaylistsModel>> getAllPlaylist() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<PlaylistsModel> savePlaylist(@RequestBody @Valid PlaylistsDto playlistsDto) {
        var PlaylistModel = new PlaylistsModel();
        BeanUtils.copyProperties(playlistsDto, PlaylistModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistsRepository.save(PlaylistModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePlaylist(@PathVariable(value ="id") int id) {
        Optional<PlaylistsModel> Playlists0 = playlistsRepository.findById(id);
        if (Playlists0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Playlists0.get());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> inserirPlaylist(@PathVariable(value = "id") int id, @RequestBody @Valid PlaylistsDto PlaylistsDto) {

        Optional<PlaylistsModel> Playlists0 = playlistsRepository.findById(id);
        if (Playlists0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist não Encontrado");

        }
        var PlaylistModel = new PlaylistsModel();
        BeanUtils.copyProperties(PlaylistsDto, PlaylistModel);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(playlistsRepository.save(PlaylistModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable(value ="id") int id) {
        Optional<PlaylistsModel> Playlist0 = playlistsRepository.findAllById(id);
        if (Playlist0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Playlist não encontrado");
        }
        playlistsRepository.delete(Playlist0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Playlist removido");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPlaylist(@PathVariable(value = "id") int id, @RequestBody PlaylistsDto playlistsDto) {
        Optional<PlaylistsModel> playlistOptional = playlistsRepository.findById(id);
        if (playlistOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist não encontrado");
        }
        PlaylistsModel playlistModel = playlistOptional.get();
        BeanUtils.copyProperties(playlistsDto, playlistModel);
        PlaylistsModel playlistAtualizado = playlistsRepository.save(playlistModel);
        return ResponseEntity.status(HttpStatus.OK).body(playlistAtualizado);
    }

}
