import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new File("words.txt"));

        List<String> words = new ArrayList<>();

        while (myScanner.hasNext()) {
            words.add(myScanner.nextLine());
        }

        Random myRandom = new Random();
        String word = words.get(myRandom.nextInt(words.size()) + 1);
        System.out.println(word);
     }
}
