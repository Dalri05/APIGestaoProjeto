package com.gestaoprojetos.repositorys;

import com.gestaoprojetos.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaRepository extends JpaRepository<TarefaModel, Integer> {

    @Query("SELECT t FROM TarefaModel t WHERE t.usuario.id = :usuarioId")
    public List<TarefaModel>  findAllByUsuarioId(@Param("usuarioId")Integer idUsuario);

}
