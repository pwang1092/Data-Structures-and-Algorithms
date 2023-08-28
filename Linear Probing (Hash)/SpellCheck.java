package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;

public class SpellCheck {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\plwdr\\Documents\\Java\\src\\DataStructuresAndAlgorithms\\ThousandWords.txt");
        Scanner input = new Scanner(file);

        // list of mis-spellings
        // first string (Key)is mis-spelled word, second string (Value) for right spelling
        LinearProbingHash<String, String> spellCheck = new LinearProbingHash<>();
        // contains correctly spelled words
        LinearProbingHash<String, String> dictionary = new LinearProbingHash<>();
        String nextWord;

        while (input.hasNextLine()) {
            nextWord = input.nextLine();
            // put potential mis-spells into spellCheck
            addToBeginning(nextWord, spellCheck);
            addToBeginning(nextWord, spellCheck);
            removeFromBeginning(nextWord, spellCheck);
            removeFromEnd(nextWord, spellCheck);
            swapAdjacent(nextWord, spellCheck);
            // put correctly spelled words in dictionary
            dictionary.put(nextWord, nextWord); // only key matters so put 0 for value
        }

        // prompt user to enter words
        Scanner console = new Scanner(System.in);
        String inputWord = "Y";
        while (inputWord.equals("Y")) {
            System.out.println("Enter a word: ");
            inputWord = console.nextLine();
            // see if word is in dictionary
            if (dictionary.get(inputWord) != null) {
                System.out.println("no mistakes found");
            }
            else {
                System.out.println("Suggested spellings: ");
                System.out.println(spellCheck.get(inputWord));
            }

            System.out.println("\nY to continue");
            inputWord = console.nextLine();
        }
    }

    // add words with extra letter at beginning
    public static void addToBeginning(String word, LinearProbingHash<String, String> spellCheck) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            spellCheck.put(word + ch, word);
        }
    }
    // add words with extra letter at end
    public static void addToEnd(String word, LinearProbingHash<String, String> spellCheck) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            spellCheck.put(ch + word, word);
        }
    }
    // add word with first letter missing
    public static void removeFromBeginning(String word, LinearProbingHash<String, String> spellCheck) {
        spellCheck.put(word.substring(1), word);
    }
    // add word with last letter missing
    public static void removeFromEnd(String word, LinearProbingHash<String, String> spellCheck) {
        spellCheck.put(word.substring(0, word.length()-1), word);
    }
    // add words with adjacent letters exchanged
    public static void swapAdjacent(String word, LinearProbingHash<String, String> spellCheck) {
        for (int i = 0; i < word.length() - 1; i++) {
            String newWord = word.substring(0, i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2);
            spellCheck.put(newWord, word);
        }
    }
}