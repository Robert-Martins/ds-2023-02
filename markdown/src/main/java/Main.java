import interfaces.Markdown;
import models.*;

public class Main {
    public static void main(String[] args) {

        Markdown titulo = new Titulo(new Texto("Exemplo de corpo em Markdown"));

        Markdown negrito = new Negrito(new Texto("Este é um texto em negrito"));

        Markdown italico = new Italico(new Texto("Este é um texto em itálico"));

        Markdown concatena = new Concatena(new Texto("Este é um texto"), new Texto("concatenado"));

        System.out.println(titulo.exibe());
        System.out.println(negrito.exibe());
        System.out.println(italico.exibe());
        System.out.println(concatena.exibe());
    }
}
