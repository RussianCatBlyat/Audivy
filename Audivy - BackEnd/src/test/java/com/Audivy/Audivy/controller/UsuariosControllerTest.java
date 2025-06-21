package com.Audivy.Audivy.controller;

import com.Audivy.Audivy.models.UsuariosModel;
import com.Audivy.Audivy.repositories.UsuariosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static com.Audivy.Audivy.enums.UsuariosPlano.PREMIUM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UsuariosControllerTest {

    @InjectMocks
    private UsuariosController usuariosController;

    @Mock
    private UsuariosRepository usuariosRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUsuarioById_UsuarioExiste(){
        Integer id = 1;
        UsuariosModel usuario = new UsuariosModel();
        usuario.setIdUsuario(1);
        usuario.setNmUsuario("Teste");
        usuario.setDsEmail("teste@teste.teste");
        usuario.setDsSenha("12345");
        usuario.setTpUsuario("artista");
        usuario.setDsPlano(PREMIUM);

        when(usuariosRepository.findById(id)).thenReturn(Optional.of(usuario));

        ResponseEntity<Object> response = usuariosController.getOneUsuario(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        UsuariosModel usuarioResponse = (UsuariosModel) response.getBody();
        assertEquals("Teste", usuarioResponse.getNmUsuario());
    }

    @Test
    void testGetUsuarioById_UsuarioNaoExiste() {
        Integer id = 2;

        when(usuariosRepository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = usuariosController.getOneUsuario(id);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
