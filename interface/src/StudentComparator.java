import java.util.Comparator;
import java.util.Scanner;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        Integer compare = o1.getFirstname().compareTo(o2.getFirstname());
        if(compare != 0)
            return compare;
        compare = o1.getLastname().compareTo(o2.getLastname());
        if(compare != 0)
            return compare;
        compare = o1.getAge().compareTo(o2.getAge());
        if(compare != 0)
            return compare;
        compare = o1.getGrade().compareTo(o2.getGrade());
        return compare;
    }

}
