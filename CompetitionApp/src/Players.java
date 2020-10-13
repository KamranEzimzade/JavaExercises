import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Players {

    private String name;
    private String surname;
    private int age;




    public void setFields() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name of the Player: ");
        this.name = sc.nextLine();
        System.out.println("Enter surname of the Player: ");
        this.surname = sc.nextLine();
        System.out.println("Enter age of the Player: ");
        this.age = sc.nextInt();
    }

}
