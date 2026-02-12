import java.util.*;

public class DeckOfCards {

    static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    static String[] initializeDeck() {
        int n = suits.length * ranks.length;
        String[] deck = new String[n];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int rand = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    static void distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index++];
            }
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cards = sc.nextInt();

        distributeCards(deck, players, cards);
    }
}
