public class Multiplica implements Expressao {

    private final Float value;

    public Multiplica(Expressao firstValue, Expressao secondValue) {
        this.value = firstValue.valor() * secondValue.valor();
    }

    public Float valor() {
        return this.value;
    }

}
