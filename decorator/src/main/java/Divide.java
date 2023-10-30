public class Divide implements Expressao {

    private final Float value;

    private static final Integer NUMBER_ONE = 1;
    private static final Integer ZERO = 0;

    public Divide(Expressao firstValue, Expressao secondValue) {
        this.value = firstValue.valor() / secondValue.valor() == ZERO ? NUMBER_ONE : secondValue.valor();
    }

    public Float valor() {
        return this.value;
    }

}
