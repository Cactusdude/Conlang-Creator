/*
    This class handles everything that that the program will handle that is related to words
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class Words {

    // setting some stuff up
    Phonemes phonemes;
    Random random;
    ArrayList<Word> wordInv;
    ArrayList<Letter> wordEntry;

    // a constructor
    public Words (Phonemes phonemes) {
        wordInv = new ArrayList<>();
        wordEntry = new ArrayList<>();
        random = new Random();
        this.phonemes = phonemes;
    }

    public void addWord(String wordType, String wordEntry, String translatesTo) {
        wordInv.add(new Word(wordType, wordEntry, translatesTo));
        System.out.println("Added word '" + wordEntry + "' of type '" + wordType + "' to word inventory with the translation '" + translatesTo + "'");
    }

    public void manualCreateWord(String wordType, String wordEntry, String translatesTo) {
        addWord(wordType, wordEntry, translatesTo);
    }

    // automatically creates a new word based off of user input
    public void autoCreateWord(String wordType, int wordLength, String translatesTo) {
        random.setSeed(System.currentTimeMillis());
        // preventing a NullPointerException because ArrayList.size() isn't null-safe
        if (phonemes.phonemeInv != null) {
            if (phonemes.phonemeInv.isEmpty()) {
                System.out.println("There are currently no phonemes in inventory, please add phonemes before creating a new word");
            }
            else {
                for(int i = 0; i < wordLength; i++) {

                    int randomSoundIndex = random.nextInt(phonemes.phonemeInv.size());
                    wordEntry.add(phonemes.phonemeInv.get(randomSoundIndex)); // adds a random phoneme from phonemeInv to wordEntry
                }

                // calls the addWord method and adds a new word to the ArrayList
                addWord(wordType, wordEntry.toString(), translatesTo);
            }
        }
    }

    // allows the user to remove words they have previously created
    public void removeWord(int index) {
        if (index > wordInv.size()) {
            System.out.println("That index is too large (array size: " + wordInv.size() + "), please pick a smaller number");
        }
        else if (index <= 0) {
            System.out.println("That index is too small, only positive values are permitted");
        }
        else {
            System.out.println("Successfully removed " + wordInv.get(index-1) + " at index " + (index));
            wordInv.remove(index - 1);
        }

    }

    // outputting wordInv
    public void outputWordList() {
        if (wordInv.isEmpty()) {
            System.out.println("There are currently no words in inventory");
        }
        else{
            System.out.println(wordInv);
        }
    }
}
