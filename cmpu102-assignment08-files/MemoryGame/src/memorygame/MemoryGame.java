/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import acm.program.*;
import utilities.*;
import java.util.Scanner;

/**
 *
 * @author michaelgoldman
 */
public class MemoryGame extends ConsoleProgram {

    private final String DICTIONARY = "dictionary.txt";
    ArrayList<String> dictionary = new ArrayList<String>();
    Random randomInteger = new Random();
    ArrayList<String> keys = new ArrayList<String>();
    AssociativeMap<String, String> wordPairs = new AssociativeMapBST<String, String>();
    boolean wordhuh = true;
    Console console;
    int correct, incorrect;

    /**
     * @param args the command line arguments
     */
    public void run() {
        Scanner input = new Scanner(System.in);
        String guess;
        dictionary();
        println("Hey there, lets play a game!");
        println("I will say two words and you will have to memorize the pairing");
        do {
            println("The score is: " + correct + " correct, " + incorrect + " incorrect.");
            String actualKey = randomWords();
            keys.add(actualKey);
            String actualData = randomWords();
            wordPairs.insert(actualKey, actualData);
            println("When I say: *" + actualKey + "* you say: " + actualData);
            int index = Math.abs(randomInteger.nextInt() % keys.size());
            String keyWord = keys.get(index);
            String keyData = wordPairs.lookUp(keyWord);
            println("What word goes with:  " + keyWord + "?");
            guess = input.next();
            if (guess.equals(keyData)) {
                println("Correct!");
                correct++;
            } else {
                println("Not quite: The correct pairing is: " + keyWord + "  " + keyData);
                incorrect++;
            }
        } while (wordhuh == true);
    }

    void dictionary() {
        try {
            FileReader fileReader = new FileReader(DICTIONARY);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (wordhuh == true) {
                String word = bufferedReader.readLine();
                if (word == null) {
                    break;
                }
                dictionary.add(word);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error: Dictionary can't be found");
            System.out.println(e.getMessage());

        }
    }

    public String randomWords() {
        int word = Math.abs(randomInteger.nextInt()) % dictionary.size();
        return dictionary.get(word);
    }

    public static void main(String[] args) {
        new MemoryGame().start();
    }

}
