import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[new Random().nextInt(3)];
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "draw";
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("scissors") && computer.equals("paper")) ||
            (player.equals("paper") && computer.equals("rock"))) {
            return "player";
        }
        return "computer";
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int games) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf((playerWins * 100.0) / games) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf((computerWins * 100.0) / games) + "%";
        return stats;
    }

    public static void displayResults(String[][] stats) {
        System.out.println("Name\tWins\tWin %");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }

    @SuppressWarnings("ConvertToStringSwitch")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();

        int playerWins = 0, computerWins = 0;

        for (int i = 1; i <= games; i++) {
            System.out.print("Game " + i + " - Enter rock, paper, or scissors: ");
            String player = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(player, computer);

            System.out.println("Computer chose: " + computer);
            if (winner.equals("player")) {
                playerWins++;
                System.out.println("You win!");
            } else if (winner.equals("computer")) {
                computerWins++;
                System.out.println("Computer wins!");
            } else {
                System.out.println("It's a draw!");
            }
        }

        String[][] stats = calculateStats(playerWins, computerWins, games);
        displayResults(stats);
    }
}
