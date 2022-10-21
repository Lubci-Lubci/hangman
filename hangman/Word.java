package hangman;

import javax.swing.plaf.IconUIResource;

public class Word {

    String notGuessedLetters = "abcdefghijklmnopqrstuvwxyz";

    String[] words = new String[]{"CAR", "BIKE", "HOUSE", "DOCTOR", "LUBOMIR"};
    String[] countries = new String[]{"GERMANY", "FRANCE", "AUSTRIA", "CROATIA",
            "SLOVAKIA", "SPAIN", "CZECHIA", "SWEDEN","ANDORRA"};

    //String[] sports = new String[]{"FOOTBALL", "HOCKEY", "TENNIS", "SWIMMING"};

    String randomword = words[(int) (Math.random() * words.length)];

    String randomcountry = countries[(int) (Math.random() * countries.length)];



}
