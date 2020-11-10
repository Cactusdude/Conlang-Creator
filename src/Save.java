/*
    This class handles the save routine
 */

import java.io.*;
import java.io.Serializable;

public class Save implements Serializable {
    public void save(String fileName, Phonemes phonemes, Words words) {

        try {
            // initiating and generating the files based off of user input
            FileOutputStream filePhonemeInv = new FileOutputStream(fileName + "-PhonemeInventory.txt");
            FileOutputStream fileWordInv = new FileOutputStream(fileName + "-WordInventory.txt");

            ObjectOutputStream outputPhonemeInv = new ObjectOutputStream(filePhonemeInv);
            ObjectOutputStream outputWordInv = new ObjectOutputStream(fileWordInv);

            // displaying success message
            System.out.println("Initiated filestream");

            // writing data to file
            outputPhonemeInv.writeObject(phonemes.phonemeInv);
            outputWordInv.writeObject(words.wordInv);

            // displaying success message
            System.out.println("Wrote data to file");

            // closing streams
            outputPhonemeInv.close();
            outputWordInv.close();
            filePhonemeInv.close();
            fileWordInv.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
