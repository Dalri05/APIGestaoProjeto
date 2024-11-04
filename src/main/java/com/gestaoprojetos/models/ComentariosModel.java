package com.gestaoprojetos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "comentarios")
public class ComentariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String texto;

    private Date dataComentario = new Date();

    @ManyToOne
    @JoinColumn(name = "tarefa_id", nullable = false)
    private TarefaModel tarefa;
}
