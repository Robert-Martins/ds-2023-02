package models;

public class Funcionario {

    private String name;

    public Funcionario(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
