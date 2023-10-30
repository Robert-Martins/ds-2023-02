public class Main {

    public static void main(String[] args) {
        System.out.println(
                new Soma(
                        new Constante(5F),
                        new Multiplica(
                                new Constante(2F),
                                new Constante(3F)
                        )
                ).valor()
        );
    }

}
