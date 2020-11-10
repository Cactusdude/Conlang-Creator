/*
    This class handles the loading routine
 */

import java.io.*;
import java.util.ArrayList;

public class Load {
    public void load(String fileName, Phonemes phonemes, Words words) {
        try{
            // initiating the file streams
            FileInputStream phonemeFileStream = new FileInputStream(fileName + "-PhonemeInventory.txt");
            FileInputStream wordFileStream = new FileInputStream(fileName + "-WordInventory.txt");

            ObjectInputStream phonemeObjStream = new ObjectInputStream(phonemeFileStream);
            ObjectInputStream wordObjStream = new ObjectInputStream(wordFileStream);

            // confirmation message
            System.out.println("Initiated data streams");

            // assigning things
            Object loadedPhonemeData = phonemeObjStream.readObject();
            Object loadedWordData = wordObjStream.readObject();

            // confirmation message
            System.out.println("Initiated loadedData");

            // loading data into the ArrayLists
            phonemes.phonemeInv = (ArrayList<Letter>) loadedPhonemeData;
            words.wordInv = (ArrayList<Word>) loadedWordData;

            // confirmation message
            System.out.println("Loaded data to ArrayList");

            // success message displayed to user
            System.out.println("Successfully loaded data: " + loadedPhonemeData + " from file: " + fileName + "-PhonemeInventory.txt");
            System.out.println("Successfully loaded data: " + loadedWordData + " from file: " + fileName + "-WordInventory.txt");
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
