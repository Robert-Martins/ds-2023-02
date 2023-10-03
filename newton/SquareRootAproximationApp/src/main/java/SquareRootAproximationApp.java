import java.util.Scanner;

public class SquareRootAproximationApp {

    public static void main(String[] args) {
        System.out.println("Insira um valor:\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Resultado: " + SquareRootAproximation.calculateSquareRoot(scanner.nextInt(), 0.001, 100));
        System.out.println("Obtido com Epsilon de 0.001 e um Máximo de 100 iterações");
    }

}
