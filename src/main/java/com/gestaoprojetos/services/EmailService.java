package com.gestaoprojetos.services;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public List<SimpleMailMessage> enviarEmailCriacaoConta(String emailDestino){
        if (StringUtils.isBlank(emailDestino)) return new ArrayList<>();

        try {
            List<SimpleMailMessage> listEmailsEnviados = new ArrayList<>();


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailDestino);
            message.setSubject("Criação de conta");
            message.setText("Sua conta foi criada com sucesso");

            mailSender.send(message);

            listEmailsEnviados.add(message);


            return listEmailsEnviados;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
