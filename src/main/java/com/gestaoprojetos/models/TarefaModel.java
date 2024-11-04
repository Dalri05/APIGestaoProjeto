package com.gestaoprojetos.models;

import com.gestaoprojetos.enums.ComplexidadeEnum;
import com.gestaoprojetos.enums.PrioridadeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tarefas")
public class TarefaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel responsavel;

    private Date dataInclusao = new Date();

    private long prazo;

    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    @Enumerated(EnumType.STRING)
    private ComplexidadeEnum complexidade;

    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentariosModel> comentarios;
}
