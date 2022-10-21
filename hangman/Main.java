package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Word myWord = new Word();
        String secretword = new String();

        int option;
        System.out.println("\n\tLet's play a game called HANGMAN: \n");
        System.out.println("\tChoose a category: ");
        System.out.println("1 - Guessing random words");
        System.out.println("2 - Guessing random countries");
        System.out.println("0 - Exit program - I dont't wanna play today");
        option = scanner.nextInt();
        if (option == 1) {
            secretword = myWord.randomword;
        } else if (option == 2) {
            secretword = myWord.randomcountry;
        } else if (option == 0) {
            return;
        }
        System.out.println("This is only for testing purposes: " + secretword);
        String scanner1 = scanner.nextLine();

        for (int i = 0; i < secretword.length(); i++) {
            System.out.print("_");
        }

        char[] letters = new char[secretword.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '_';
        }

        int lives = 6;
        while (lives > 0) {
            System.out.print("\nYour lives: ");
            for (int i = 0; i < lives; i++) {
                System.out.print("I");
            }
            System.out.println();

            System.out.print("your input: ");
            String input = scanner.nextLine();
            input = input.toUpperCase();
            char letter = input.charAt(0);

            boolean isSpecialCharacterString = false;
            String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}0123456789";
            for (int i = 0; i < input.length(); i++) {
                letter = input.charAt(i);
                if (specialCharactersString.contains(Character.toString(letter))) {
                    System.out.println(input + " is a not a letter. Please enter only letters");
                    isSpecialCharacterString = true;
                }
            }

            boolean isWrongtGuess = true;
            for (int i = 0; i < secretword.length(); i++) {
                char l = secretword.charAt(i);
                if (l == letter) {
                    // update our letters
                    letters[i] = l;
                    isWrongtGuess = false;
                }
            }
            if (isWrongtGuess && !isSpecialCharacterString) {
                lives--;
            }

            // printing hangman
            if (lives == 6) {
                System.out.println("  _______\n  |/\n  |\n  |\n  |\n  |\n__|__");
            } else if (lives == 5) {
                System.out.println("  _______\n  |/    |\n  |     O\n  |\n  |\n  |\n__|__");
            } else if (lives == 4) {
                System.out.println("  _______\n  |/    |\n  |     O\n  |    /\n  |\n  |     \n__|__");
            } else if (lives == 3) {
                System.out.println("  _______\n  |/    |\n  |     O\n  |    / \\\n  |\n  |\n__|__");
            } else if (lives == 2) {
                System.out.println("  _______\n  |/    |\n  |     O\n  |    /|\\\n  |     |\n  |\n__|__");
            } else if (lives == 1) {
                System.out.println("  _______\n  |/    |\n  |     O\n  |    /|\\\n  |     |\n  |    /\n__|__");
            }

            myWord.notGuessedLetters = myWord.notGuessedLetters.toUpperCase().replace(letter, ' ');
            System.out.println("Letters that you didn't try yet: " + myWord.notGuessedLetters);
            System.out.println("............................................................");
            System.out.println("the word: ");   // print the word with the letters // end of the loop

            boolean isFinished = true;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == '_') {
                    isFinished = false;
                }
                System.out.print(letters[i]);
            }

            if (isFinished) {
                System.out.println("\nCONGRATZ YOU WON THE GAME!");
                break;
            } else if (lives == 0) {
                System.out.println("\nYOU LOST! You are out of lives.\nYou were guessing the word: "
                        + secretword + "\n\t\tGAME OVER");
                System.out.println("  _______\n  |/    |\n  |     O\n  |    /|\\\n  |     |\n  |    / \\\n__|__");
                break;
            }
        }
    }
}