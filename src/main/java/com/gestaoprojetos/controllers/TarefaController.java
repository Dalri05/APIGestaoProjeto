package com.gestaoprojetos.controllers;

import com.gestaoprojetos.models.UsuarioModel;
import com.gestaoprojetos.repositorys.TarefaRepository;
import com.gestaoprojetos.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

}
