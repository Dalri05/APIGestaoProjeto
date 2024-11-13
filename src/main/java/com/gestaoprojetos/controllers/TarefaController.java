package com.gestaoprojetos.controllers;

import com.gestaoprojetos.models.TarefaModel;
import com.gestaoprojetos.models.UsuarioModel;
import com.gestaoprojetos.repositorys.TarefaRepository;
import com.gestaoprojetos.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @PostMapping("/criar")
    public ResponseEntity criarTarefa(@RequestBody TarefaModel tarefaModel) {
        try {
            return ResponseEntity.ok().body(tarefaService.criarTarefa(tarefaModel));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ListarTarefas/IdUsuario")
    public List<TarefaModel> listarTarefa(@RequestParam int idUsuario) {
        try {
            return tarefaService.listarTarefasPorUsuario(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
