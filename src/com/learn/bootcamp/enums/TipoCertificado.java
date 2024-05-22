package com.learn.bootcamp.enums;

public enum TipoCertificado {

    CURSO(1),
    MENTORIA(2),
    BOOTCAMP(3);

    private Integer id;

    TipoCertificado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static TipoCertificado valueOf(int code) {
        for (TipoCertificado value : TipoCertificado.values()) {
            if (value.getId() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Id do TipoCertificado inválido!");
    }

}
