/*
    This class handles phonemes and the phoneme inventory
 */

import java.util.ArrayList;

public class Phonemes {

    // initiating ArrayList of phonemes
    ArrayList<Letter> phonemeInv;
    public Phonemes() {
        phonemeInv = new ArrayList<>();
    }

    public void addPhoneme(String addPhonemeType, String addPhonemeInp, String addPhonemeIPA) {
        phonemeInv.add(new Letter(addPhonemeType, addPhonemeInp, addPhonemeIPA));
        System.out.println("Added letter '" + addPhonemeInp + "' of type '" + addPhonemeType + "' to inventory with value [" + addPhonemeIPA + "]");
    }

    public void removePhoneme(int index) {
        if (index > phonemeInv.size()) {
            System.out.println("That index is too large (array size: " + phonemeInv.size() + "), please pick a smaller number");
        }
        else if (index <= 0) {
            System.out.println("That index is too small, only positive values are permitted");
        }
        else {
            System.out.println("Successfully removed " + phonemeInv.get(index-1) + " at index " + (index));
            phonemeInv.remove(index - 1);
        }

    }

    public void outputPhonemeList() {

        // displaying message if inventory is empty
        if(phonemeInv.isEmpty()) {
            System.out.println("No phonemes currently in inventory");
        }

        else {
            System.out.println("\nIPA symbols may not appear correctly depending on the font used\nSemivowels are also synonymous with approximants in this instance\n");
            System.out.println(phonemeInv);
        }
    }
}
