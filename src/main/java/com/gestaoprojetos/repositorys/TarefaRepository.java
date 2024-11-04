package com.gestaoprojetos.repositorys;

import com.gestaoprojetos.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Integer> {
}
