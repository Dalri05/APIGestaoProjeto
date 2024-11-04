package com.gestaoprojetos.enums;

import lombok.Getter;

@Getter
public enum ComplexidadeEnum {
    FACIL(0),
    MEDIA(1),
    DIFICL(2),
    EXTREMA(3);

    private final int complexidade;

    ComplexidadeEnum(int complexidade) {
        this.complexidade = complexidade;
    }

}
