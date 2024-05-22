package com.learn.bootcamp.enums;

public enum Nivel {

    BASICO(1),
    INTERMEDIARIO(2),
    AVANCADO(3);

    private Integer id;

    Nivel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static Nivel valueOf(int code) {
        for (Nivel value : Nivel.values()) {
            if (value.getId() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Id do Nivel inválido!");
    }

}
