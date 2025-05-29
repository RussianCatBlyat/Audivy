package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.PlaylistMusicasDto;
import com.Audivy.Audivy.models.PlaylistsModel;
import com.Audivy.Audivy.models.PlaylistMusicasModel;
import com.Audivy.Audivy.models.MusicasModel;
import com.Audivy.Audivy.repositories.MusicasRepository;
import com.Audivy.Audivy.repositories.PlaylistMusicasRepository;
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
@RequestMapping("/PlaylistMusicas")
public class PlaylistMusicasController {

    @Autowired
    PlaylistMusicasRepository playlistmusicasRepository;
    @Autowired
    PlaylistsRepository playlistsRepository;
    @Autowired
    MusicasRepository musicasRepository;

    @GetMapping
    public ResponseEntity<List<PlaylistMusicasModel>> getAllPlaylistMusica() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistmusicasRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<PlaylistMusicasModel> savePlaylistMusica(@RequestBody @Valid PlaylistMusicasDto playlistmusicasDto) {
        Optional<PlaylistsModel> playlistOptional = playlistsRepository.findById(playlistmusicasDto.idPlaylist());
        Optional<MusicasModel> musicaOptional = musicasRepository.findById(playlistmusicasDto.idMusica());
        var PlaylistMusicaModel = new PlaylistMusicasModel();
        PlaylistMusicaModel.setIdPlaylist(playlistOptional.get());
        PlaylistMusicaModel.setIdMusica(musicaOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistmusicasRepository.save(PlaylistMusicaModel));
    }

    @GetMapping("/{idPlaylistMusica}")
    public ResponseEntity<Object> getOnePlaylistMusica(@PathVariable(value ="idPlaylistMusica") int idPlaylistMusica) {
        Optional<PlaylistMusicasModel> PlaylistMusicas0 = playlistmusicasRepository.findById(idPlaylistMusica);
        if (PlaylistMusicas0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlaylistMusica não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(PlaylistMusicas0.get());
    }

    @DeleteMapping("/{idPlaylistMusica}")
    public ResponseEntity<Object> deletePlaylistMusica(@PathVariable(value ="idPlaylistMusica") int idPlaylistMusica) {
        Optional<PlaylistMusicasModel> PlaylistMusica0 = playlistmusicasRepository.findById(idPlaylistMusica);
        if (PlaylistMusica0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("PlaylistMusica não encontrado");
        }
        playlistmusicasRepository.delete(PlaylistMusica0.get());
        return ResponseEntity.status(HttpStatus.OK).body("PlaylistMusica removido");
    }

    @PutMapping("/{idPlaylistMusica}")
    public ResponseEntity<Object> atualizarPlaylistMusica(@PathVariable(value = "idPlaylistMusica") int idPlaylistMusica, @RequestBody PlaylistMusicasDto playlistmusicasDto) {
        Optional<PlaylistMusicasModel> playlistmusicaOptional = playlistmusicasRepository.findById(idPlaylistMusica);
        if (playlistmusicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlaylistMusica não encontrado");
        }
        PlaylistMusicasModel playlistmusicaModel = playlistmusicaOptional.get();
        BeanUtils.copyProperties(playlistmusicasDto, playlistmusicaModel);
        PlaylistMusicasModel playlistmusicaAtualizado = playlistmusicasRepository.save(playlistmusicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(playlistmusicaAtualizado);
    }

}
