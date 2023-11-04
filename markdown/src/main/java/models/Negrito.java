package models;

import interfaces.Markdown;

public class Negrito implements Markdown {
    private final Markdown texto;

    public Negrito(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public String exibe() {
        return "**" + texto.exibe() + "**";
    }
}