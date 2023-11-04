package models;

import interfaces.Markdown;

public class Texto implements Markdown {
    private final String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    @Override
    public String exibe() {
        return this.texto;
    }
}
