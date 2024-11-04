package com.gestaoprojetos.enums;

import lombok.Getter;

@Getter
public enum PrioridadeEnum {
    BAIXA(0),
    MEDIA(1),
    ALTA(2),
    ALTISSIMA(3);

    private final int prioridade;

    PrioridadeEnum(int prioridade) {
        this.prioridade = prioridade;
    }
}
