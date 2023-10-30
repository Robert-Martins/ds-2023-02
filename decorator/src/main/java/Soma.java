public class Soma implements Expressao {

    private final Float value;

    public Soma(Expressao firstValue, Expressao secondValue) {
        this.value = firstValue.valor() + secondValue.valor();
    }

    public Float valor() {
        return this.value;
    }

}
