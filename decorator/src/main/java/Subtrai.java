public class Subtrai implements Expressao {

    private final Float value;

    public Subtrai(Expressao firstValue, Expressao secondValue) {
        this.value = firstValue.valor() - secondValue.valor();
    }

    public Float valor() {
        return this.value;
    }

}
