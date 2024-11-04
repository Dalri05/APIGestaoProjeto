package com.gestaoprojetos.services;

import com.gestaoprojetos.enums.TipoEnvioEmailEnum;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public List<SimpleMailMessage> envioEmail(String emailDestino, TipoEnvioEmailEnum tipoEnvioEmail){
        if (StringUtils.isBlank(emailDestino)) return new ArrayList<>();

        try {
            List<SimpleMailMessage> listEmailsEnviados = new ArrayList<>();

            Map<String, String> mapMensagens = definirMensagensEmail(tipoEnvioEmail);

            String mensagem = mapMensagens.get("mensagem");
            String titulo = mapMensagens.get("titulo");


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailDestino);
            message.setSubject(titulo);
            message.setText(mensagem);

            mailSender.send(message);

            listEmailsEnviados.add(message);


            return listEmailsEnviados;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Map<String, String> definirMensagensEmail(TipoEnvioEmailEnum tipo){
        Map<String, String> mapMensagens = new HashMap<>();

        switch (tipo){
            case CRIACAO_CONTA:
                mapMensagens.put("titulo", "Criação de conta.");
                mapMensagens.put("mensagem", "Sua conta foi criada com sucesso!");

            case CRIACAO_TAREFA:
                mapMensagens.put("titulo", "Criação de tarefa.");
                mapMensagens.put("mensagem", "Sua tarefa foi criada!");
        }

        return mapMensagens;
    }
}
