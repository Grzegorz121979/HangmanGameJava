import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static Random myRandom = new Random();
    public static void main(String[] args) {
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(new File("words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<>();

        while (myScanner.hasNext()) {
            words.add(myScanner.nextLine());
        }

        String word = words.get(myRandom.nextInt(words.size()));
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);

        while (true) {
            getPlayerGuesses(keyboard, word, playerGuesses);
        }
    }

    private static void getPlayerGuesses(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.print("Please enter a letter: ");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        printWordState(word, playerGuesses);
    }

    private static void printWordState(String word, List<Character> playerGuesses) {
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
