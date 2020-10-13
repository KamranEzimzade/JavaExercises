
import java.io.*;
import java.util.Scanner;

public class Util {


    private String nameofReserver;
    private String surnameofReserver;
    private int payment;
    private int numberOfRooms;
    //    private String roomType;


//    public String getRoomType() {
//        return roomType;
//    }
//
//    public void setRoomType(String roomType) {
//        this.roomType = roomType;
//    }


    public void launch() {
        System.out.println("Welcome to Hilton Hotel...");
        System.out.println("1. Make Reservation\n" +
                "2. Print Reservations\n" +
                "3. Exit");
        operationMenu();
    }

    private void operationMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================================================");
        System.out.println("Enter the number of option you want to operate: ");
        int option = sc.nextInt();


        switch (option) {
            case 1:
                makeReservation();
                System.out.println("===========================================================================");
                break;
            case 2:
                printReservations();
                System.out.println("===========================================================================");
                operationMenu();
                break;
            case 3:
                System.out.println("Thanks for spending time with us");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
    }


    private void makeReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.nameofReserver = sc.nextLine();
        System.out.println("Enter your surname: ");
        this.surnameofReserver = sc.nextLine();
        System.out.println("Enter the number of poeple will be staying: ");
        int numberOfPeople = sc.nextInt();
        System.out.println("Enter the number of rooms will be booked: ");
        this.numberOfRooms = sc.nextInt();
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.println("Enter information for room no: " + (i + 1));
            System.out.println("===========================================================================");
            reservationDetails();
        }

        makePayment();
        sendReceipt();
        System.out.println("Reservation completed");
        System.out.println("===========================================================================");
        writeToFile();
        launch();

    }


    private int reservationDetails() {
        Scanner sc = new Scanner(System.in);
        showRoomType();
        System.out.println("===========================================================================");
        System.out.println("Enter the type of room you would like to book: ");
        int roomTypeChoice = sc.nextInt();
        if (roomTypeChoice == 1) {
//            setRoomType("Single Room");
            payment += 50;
        } else if (roomTypeChoice == 2) {
//            setRoomType("Double Room");
            payment += 80;
        } else if (roomTypeChoice == 3) {
//            setRoomType("Deluxe Room");
            payment += 200;
        }

        System.out.println("Would you like a full board booking with breakfast included, lunch and dinner included without drinks?" +
                " 1 for yes and 2 for no: ");
        int fullBoard = sc.nextInt();
        if (fullBoard == 1) {
            payment += 35;
        }

        System.out.println("Would you like to have the beautiful seaview from your room room?" +
                " 1 for yes and 2 for no: ");
        int sieView = sc.nextInt();

        if (sieView == 1) {
            payment += 20;
        }
        return payment;
    }

    private void showRoomType() {
        System.out.println("1. Single Room = 50 AZN\n" +
                "2. Double Room = 80 AZN\n" +
                "3. Deluxe Room = 200 AZN");
    }

    private void makePayment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to make the payment?" +
                " 1 for yes and 2 for no: ");
        int makingPayment = sc.nextInt();
        if (makingPayment == 1) {
            System.out.println("Payment has been made for: " + payment + " AZN");
        }
    }

    private void sendReceipt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("The receipt has been sent to: " + email);
    }


    public void printReservations() {
        readFile();
        System.out.println("===========================================================================");
        launch();
    }

    private void writeToFile() {
        String numoFRooms = Integer.toString(numberOfRooms);
        try {
            FileWriter myWriter = new FileWriter("/home/kamran/ReservationData.txt", true);
            myWriter.write("Name: " + nameofReserver + " " + surnameofReserver + " have booked " + numoFRooms + " room\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void readFile() {
        File file = new File("/home/kamran/ReservationData.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


