import java.util.Scanner;

public class SquareRootAproximationApp {

    public static void main(String[] args) {
        Function<Double, Double> squareRootAproximation = new SquareRootAproximation();
        System.out.println("Insira um valor:\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Resultado: " + squareRootAproximation.apply(scanner.nextInt());
        System.out.println("Obtido com Epsilon de 1e-10");
    }

}
