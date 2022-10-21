package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] wordlist = {"CAR", "BIKE", "HOUSE", "DOCTOR", "LUBOMIR"};
        String randomWord = wordlist[(int) (Math.random() * wordlist.length)];
        String[] guessedLetters = {};

        int lives = 6;

        // here will be the starting for loop

        // printing underscores
        for (int i = 0; i < randomWord.length(); i++) {
            System.out.print("_");
        }

        System.out.println("\nGuess a letter in a random word: ");
        String input = scanner.nextLine();
        System.out.println("You were guessing: " + input);

        System.out.println("........................................");





    }
}
