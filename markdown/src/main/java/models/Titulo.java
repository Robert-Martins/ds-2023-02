package models;

import interfaces.Markdown;

public class Titulo implements Markdown {
    private final Markdown texto;

    public Titulo(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public String exibe() {
        return "# " + texto.exibe();
    }
}