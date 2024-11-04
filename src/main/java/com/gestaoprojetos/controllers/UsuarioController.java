package com.gestaoprojetos.controllers;

import com.gestaoprojetos.models.UsuarioModel;
import com.gestaoprojetos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criarUsuario")
    public ResponseEntity criarUsuario(@RequestBody UsuarioModel usuarioRequest){
        try {
            UsuarioModel usuario = usuarioService.criarUsuario(usuarioRequest);

            if (Objects.nonNull(usuario)){
                return ResponseEntity.ok().body(usuario);
            }

            return ResponseEntity.badRequest().build();
        } catch (Exception e){
            String msg = e.getMessage();
            return ResponseEntity.badRequest().body(msg);
        }
    }
}
