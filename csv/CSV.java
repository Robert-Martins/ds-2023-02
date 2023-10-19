import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CSV {

    private static final Integer HUNDRED = 100;

    private static final Integer TEN = 10;

    private static List<FileLine> fileLines = new ArrayList<>();

    public static void main(String[] args) {
        createFile(); // Para testar o programa
        consumeFile();
    }

    private static void createFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("values.csv"))) {
            Integer lines = getRandomIntegerBetweenTenAndAHundred();
            for(int i = 0; i < lines; i++)
                writer.println(generateLine());
        } catch (IOException e) {
            System.out.println("Não foi possível criar arquivo com valores");
        }
    }

    private static void consumeFile() {
        fileLines.clear();
        try (Scanner scanner = new Scanner(new FileReader("values.csv"))) {
            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                fileLines.add(
                        new FileLine(
                                Integer.parseInt(line[0]),
                                Integer.parseInt(line[1])
                        )
                );
            }
            persistFile();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de valores não encontrado");
        }
    }

    private static void persistFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sum.csv"))) {
            fileLines.forEach(fileLine -> writer.println(fileLine.toString()));
        } catch (IOException e) {
            System.out.println("Não foi possível criar arquivo com valores e soma");
        }
    }

    private static String generateLine() {
        return getRandomIntegerBetweenTenAndAHundred().toString() + ',' + getRandomIntegerBetweenTenAndAHundred().toString();
    }

    private static Integer getRandomIntegerBetweenTenAndAHundred() {
        return new Random().nextInt(HUNDRED - TEN) + TEN;
    }

}

class FileLine implements Serializable {

    private Integer value1;

    private Integer value2;

    private Integer sum;

    public FileLine(Integer value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.sum = this.value1 + this.value2;
    }

    @Override
    public String toString() {
        return this.value1.toString() + ',' + this.value2.toString() + ',' + this.sum;
    }

}