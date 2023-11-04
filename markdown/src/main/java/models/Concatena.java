package models;

import interfaces.Markdown;

public class Concatena implements Markdown {
    private final Markdown textoA;
    private final Markdown textoB;

    public Concatena(Markdown textoA, Markdown textoB) {
        this.textoA = textoA;
        this.textoB = textoB;
    }

    @Override
    public String exibe() {
        return textoA.exibe() + textoB.exibe();
    }
}