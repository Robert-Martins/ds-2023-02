public class SquareRootAproximation {

    private static final Double EPSILON = 1e-10;

    public static double calculateSquareRoot(Integer x) {
        if (x < 0)
            throw new IllegalArgumentException("X não pode ser negativo");
        
        Double guess = x / 2.0;

        while(Math.abs(guess * guess - x) > EPSILON)
            guess = 0.5 * (guess + x / guess);

        return guess;
    }

}
