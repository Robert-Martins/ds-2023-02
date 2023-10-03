public class SquareRootAproximation {

    public static double calculateSquareRoot(Integer x, Double epsilon, Integer maxIterations) {
        if (x < 0)
            throw new IllegalArgumentException("X não pode ser negativo");

        Double guess = x / 2.0;
        Integer iterations = 0;

        while (Math.abs(guess * guess - x) > epsilon && iterations < maxIterations) {
            guess = 0.5 * (guess + x / guess);
            iterations++;
        }

        return guess;
    }

}
