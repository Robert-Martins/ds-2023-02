package models;

import interfaces.Markdown;

public class Item implements Markdown {
    private final Markdown texto;

    public Item(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public String exibe() {
        return "* " + texto.exibe();
    }
}
