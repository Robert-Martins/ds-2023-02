import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Gabriel", "Bispo", 22, 7.5));
        students.add(new Student("Kelvin", "de Oliveira", 20, 7.0));
        students.add(new Student("Robert", "Martins", 22, 5.0));
        students.add(new Student("Yuan", "Calixto", 20, 8.0));
        students.sort(Student::compareTo);
    }

}