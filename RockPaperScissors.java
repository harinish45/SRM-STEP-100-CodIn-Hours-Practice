import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    public static String determineWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) {
            return "Draw";
        } else if ((user.equalsIgnoreCase("Rock") && computer.equalsIgnoreCase("Scissors")) ||
                   (user.equalsIgnoreCase("Paper") && computer.equalsIgnoreCase("Rock")) ||
                   (user.equalsIgnoreCase("Scissors") && computer.equalsIgnoreCase("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, computerWins = 0, draws = 0;

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();
            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Result: " + winner);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        System.out.println("\nGame Statistics:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);
        System.out.printf("User Win Percentage: %.2f%%\n", (userWins * 100.0) / games);
        System.out.printf("Computer Win Percentage: %.2f%%\n", (computerWins * 100.0) / games);
    }
}

