package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.dto.MusicasDto;
import com.Audivy.Audivy.models.MusicasModel;
import com.Audivy.Audivy.repositories.MusicasRepository;
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

    @GetMapping
    public ResponseEntity<List<MusicasModel>> getAllMusica() {
        return ResponseEntity.status(HttpStatus.OK).body(musicasRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<MusicasModel> saveMusica(@RequestBody @Valid MusicasDto musicasDto) {
        var MusicaModel = new MusicasModel();
        BeanUtils.copyProperties(musicasDto, MusicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicasRepository.save(MusicaModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMusica(@PathVariable(value ="id") int id) {
        Optional<MusicasModel> Musicas0 = musicasRepository.findById(id);
        if (Musicas0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Musicas0.get());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> inserirMusica(@PathVariable(value = "id") int id, @RequestBody @Valid MusicasDto MusicasDto) {

        Optional<MusicasModel> Musicas0 = musicasRepository.findById(id);
        if (Musicas0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não Encontrado");

        }
        var MusicaModel = new MusicasModel();
        BeanUtils.copyProperties(MusicasDto, MusicaModel);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(musicasRepository.save(MusicaModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMusica(@PathVariable(value ="id") int id) {
        Optional<MusicasModel> Musica0 = musicasRepository.findAllById(id);
        if (Musica0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Musica não encontrado");
        }
        musicasRepository.delete(Musica0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Musica removido");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarMusica(@PathVariable(value = "id") int id, @RequestBody MusicasDto musicasDto) {
        Optional<MusicasModel> musicaOptional = musicasRepository.findById(id);
        if (musicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não encontrado");
        }
        MusicasModel musicaModel = musicaOptional.get();
        BeanUtils.copyProperties(musicasDto, musicaModel);
        MusicasModel musicaAtualizado = musicasRepository.save(musicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(musicaAtualizado);
    }

}
