package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.PlaylistsDto;
import com.Audivy.Audivy.models.PlaylistsModel;
import com.Audivy.Audivy.models.UsuariosModel;
import com.Audivy.Audivy.repositories.AlbunsRepository;
import com.Audivy.Audivy.repositories.PlaylistsRepository;
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
@RequestMapping("/Playlists")
public class PlaylistsController {

    @Autowired
    PlaylistsRepository playlistsRepository;
    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity<List<PlaylistsModel>> getAllPlaylist() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<PlaylistsModel> savePlaylist(@RequestBody @Valid PlaylistsDto playlistsDto) {
        Optional<UsuariosModel> usuarioOptional = usuariosRepository.findById(playlistsDto.idUsuario());
        var PlaylistModel = new PlaylistsModel();
        PlaylistModel.setNmTitulo(playlistsDto.nmTitulo());
        PlaylistModel.setIdUsuario(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistsRepository.save(PlaylistModel));
    }

    @GetMapping("/{idPlaylist}")
    public ResponseEntity<Object> getOnePlaylist(@PathVariable(value ="idPlaylist") int idPlaylist) {
        Optional<PlaylistsModel> Playlists0 = playlistsRepository.findById(idPlaylist);
        if (Playlists0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Playlists0.get());
    }

    @DeleteMapping("/{idPlaylist}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable(value ="idPlaylist") int idPlaylist) {
        Optional<PlaylistsModel> Playlist0 = playlistsRepository.findById(idPlaylist);
        if (Playlist0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Playlist não encontrado");
        }
        playlistsRepository.delete(Playlist0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Playlist removido");
    }

    @PutMapping("/{idPlaylist}")
    public ResponseEntity<Object> atualizarPlaylist(@PathVariable(value = "idPlaylist") int idPlaylist, @RequestBody PlaylistsDto playlistsDto) {
        Optional<PlaylistsModel> playlistOptional = playlistsRepository.findById(idPlaylist);
        if (playlistOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist não encontrado");
        }
        PlaylistsModel playlistModel = playlistOptional.get();
        BeanUtils.copyProperties(playlistsDto, playlistModel);
        PlaylistsModel playlistAtualizado = playlistsRepository.save(playlistModel);
        return ResponseEntity.status(HttpStatus.OK).body(playlistAtualizado);
    }

}
