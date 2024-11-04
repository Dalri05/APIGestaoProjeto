package com.gestaoprojetos.enums;

import lombok.Getter;

@Getter
public enum TipoEnvioEmailEnum {
    CRIACAO_CONTA(100),
    CRIACAO_TAREFA(200);

    private final int tipoEnvioEmail;

    TipoEnvioEmailEnum(int tipoEnvioEmail) {
        this.tipoEnvioEmail = tipoEnvioEmail;
    }
}
