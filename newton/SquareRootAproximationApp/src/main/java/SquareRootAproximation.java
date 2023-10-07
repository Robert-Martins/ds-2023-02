import java.util.function.Function;

public class SquareRootAproximation implements Function<Double, Double> {

    private static final Double EPSILON = 0.001;

    public Double apply(Double x) {
        if (x < 0)
            throw new IllegalArgumentException("X não pode ser negativo");
        
        Double guess = x / 2.0;

        while(Math.abs(guess * guess - x) > EPSILON)
            guess = 0.5 * (guess + x / guess);

        return guess;
    }

}
