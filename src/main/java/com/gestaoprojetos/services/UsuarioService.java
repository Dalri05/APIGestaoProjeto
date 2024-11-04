package com.gestaoprojetos.services;

import com.gestaoprojetos.models.UsuarioModel;
import com.gestaoprojetos.repositorys.TarefaRepository;
import com.gestaoprojetos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    EmailService emailService;


    public UsuarioModel criarUsuario(UsuarioModel usuario) {
        try {
            List<SimpleMailMessage> emails = emailService.enviarEmailCriacaoConta(usuario.getEmail());

            boolean emailEnviado = emails.stream()
                    .map(SimpleMailMessage::getTo)
                    .flatMap(Arrays::stream)
                    .anyMatch(email -> email.equals(usuario.getEmail()));

            if (emailEnviado) {
                usuarioRepository.save(usuario);
                return usuario;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
