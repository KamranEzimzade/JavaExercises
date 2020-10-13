import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Util {

    private String username = "kamran";
    private String password = "1994";
    private int randomNum;
    private int numberOfPlayer;
    private int minPlayers = 1;

    public Util() {

    }


    public void login(String username, String password) {

        int loginCount = 0;

        if (username != this.username || password != this.password) {
            loginCount++;
            System.out.println("Not correct, try again");
            if (loginCount == 3) {
                System.out.println("You are banned");
                exit(0);
            }
        } else if (username == this.username && password == this.password) {
            System.out.println("\nSuccessfuly logged in");
            System.out.println("===========================================================================");
//            showMenu();
            operationMenu();
        }
    }

    public void showMenu() {
        System.out.println("1. Register Players\n" +
                "2. Start Game\n" +
                "3. Logout\n" +
                "4. Exit");
    }

    public void operationMenu() {

        Scanner sc = new Scanner(System.in);
        showMenu();
        System.out.println("===========================================================================");
        System.out.println("Enter the number of option you want to operate: ");
        int option = sc.nextInt();


        switch (option) {
            case 1:
                registerPlayers();
                System.out.println("===========================================================================");
                operationMenu();
                break;
            case 2:
                startGame();
                System.out.println("===========================================================================");
                operationMenu();
                break;
            case 3:
                login("", "");
                System.out.println("===========================================================================");
                operationMenu();
                break;
            case 4:
                System.out.println("Thanks for spending time with us");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
    }


    public void registerPlayers() {
        System.out.println("Enter the number of players to participate in the game: ");
        Scanner sc = new Scanner(System.in);
        int numOfPlayers = sc.nextInt();
        this.numberOfPlayer = numOfPlayers;
        Players[] players = new Players[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Players();
            players[i].setFields();
        }
        System.out.println("The players participating in the game have been registered");
    }

    public void startGame() {
        randomPlayer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Who do you think is the winner?: ");
        int input = sc.nextInt();

        if (input == randomNum) {
            System.out.println("Congratulations, you won");
        } else {
            System.out.println("You failed");
        }
    }

    public int randomPlayer() {
        this.randomNum = ThreadLocalRandom.current().nextInt(minPlayers, numberOfPlayer + 1);
        return randomNum;
    }

}





