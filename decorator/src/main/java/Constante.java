public class Constante implements Expressao {

    private final Float value;

    public Constante(Float value) {
        this.value = value;
    }

    @Override
    public Float valor() {
        return value;
    }
}
