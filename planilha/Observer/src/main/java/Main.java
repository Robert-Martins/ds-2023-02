public class Main {

    public static void main(String[] args) {
        Celula a1 = new Celula("A1");
        Celula a2 = new Celula("A2");
        Celula a3 = new Celula("A3");

        a3.addObserver(a1);
        a3.addObserver(a2);

        a3.setValue(1);
    }

}
