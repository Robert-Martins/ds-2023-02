package models;

import annotations.Observe;

@Observe(observado = "Funcionario")
public class Chefe {

    private String name;

    public Chefe(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
