import java.util.ArrayList;

public class StudentTest {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();

        Student kamran = new Student();
        Student nurlan = new Student();
        Student aslan = new Student();

        kamran.setName("Kamran");
        kamran.setAge(26);
        kamran.setGrade("Senior");

        nurlan.setName("Nurlan");
        nurlan.setAge(32);
        nurlan.setGrade("Freshmen");

        aslan.setName("Aslan");
        aslan.setAge(33);
        aslan.setGrade("Junior");

        students.add(kamran);
        students.add(nurlan);
        students.add(aslan);

        students.contains(kamran);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getAge() + " years old " + students.get(i).getGrade());
        }
    }
}
