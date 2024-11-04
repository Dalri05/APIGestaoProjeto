package com.gestaoprojetos.services;

import com.gestaoprojetos.enums.TipoEnvioEmailEnum;
import com.gestaoprojetos.models.TarefaModel;
import com.gestaoprojetos.models.UsuarioModel;
import com.gestaoprojetos.repositorys.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class TarefaService {
    @Autowired
    TarefaService tarefaService;

    @Autowired
    EmailService emailService;

    @Autowired
    TarefaRepository tarefaRepository;

   public TarefaModel criarTarefa(TarefaModel tarefa) {
       try {
           String emailResponsavel = tarefa.getResponsavel().getEmail();

           if (Objects.nonNull(emailResponsavel)) {
               List<SimpleMailMessage> email = emailService.envioEmail(emailResponsavel, TipoEnvioEmailEnum.CRIACAO_TAREFA);

               if (Objects.nonNull(email)) {
                   tarefaRepository.save(tarefa);

                   return tarefa;
               }
           }

           return null;

       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }

   }
}
