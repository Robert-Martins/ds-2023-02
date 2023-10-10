public class Student implements Comparable<Student> {

    private String firstname;
    private String lastname;
    private Integer age;
    private Double grade;

    public Student(String firstname, String lastname, Integer age, Double grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.grade = grade;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student another) {
        return new StudentComparator().compare(this, another);
    }
}
