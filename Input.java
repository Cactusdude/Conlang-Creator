/*
    This class handles input from the user
 */

import java.util.Scanner;

public class Input {

    // initiating various things
    Scanner scanner = new Scanner(System.in);
    Phonemes phonemes = new Phonemes();
    Save save = new Save();
    Load load = new Load();
    Words words = new Words(phonemes);

    public void getInput() {
        while(true) {
            // getting user input
            System.out.println("Enter command/number [add letter (1), remove letter (2), wordlist (3), create word automatically (4), create word manually (5), remove word(6), output letters (7), save (8), load (9), exit (10)]: ");
            String userInput = scanner.nextLine();
            
            switch (userInput) {

                // allows user to add a new phoneme/letter
                case "add letter":
                case "1":
                    System.out.println("Enter phoneme type:");
                    String addPhonemeType = scanner.nextLine();

                    System.out.println("Enter letter: ");
                    String addPhonemeInp = scanner.nextLine();

                    System.out.println("Enter IPA to assign to letter (Only valid IPA should be used, copy and paste if needed): ");
                    String addPhonemeIPA = scanner.nextLine();

                    phonemes.addPhoneme(addPhonemeType, addPhonemeInp, addPhonemeIPA);
                    break;

                // allows user to remove a phoneme at an index specified by the user
                case "remove letter":
                case "2":
                    if (phonemes.phonemeInv.size() == 0) {
                        System.out.println("The inventory is currently empty");
                    }
                    else {
                        System.out.println("Enter index of phoneme to remove (Indexes 1-" + phonemes.phonemeInv.size() + "): ");
                        String index = scanner.nextLine();

                        phonemes.removePhoneme(Integer.parseInt(index));
                    }
                    break;

                // allows user to output wordlist
                case "wordlist":
                case "3":
                    words.outputWordList();
                    break;

                // allows user to create a new, randomly generated, word
                case "create word automatically":
                case "4":
                    System.out.println("Enter the word type: ");
                    String wordType = scanner.nextLine();

                    System.out.println("Enter the word's length: ");
                    int wordSize = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter English translation: ");
                    String translatesTo = scanner.nextLine();

                    words.autoCreateWord(wordType, wordSize, translatesTo);
                    break;

                // allows the user to manually create a new word
                case "create word manually":
                case "5":
                    System.out.println("Enter word type: ");
                    wordType = scanner.nextLine();

                    System.out.println("Enter English translation: ");
                    translatesTo = scanner.nextLine();

                    System.out.println("Enter word: ");
                    String wordEntry = scanner.nextLine();

                    words.manualCreateWord(wordType, wordEntry, translatesTo);
                    break;

                // allows user to manually remove words at a given index
                case "remove word":
                case "6":
                    if (words. wordInv.size() == 0) {
                        System.out.println("The inventory is currently empty");
                    }
                    else {
                        System.out.println("Enter index of word to remove (Indexes 1-" + words.wordInv.size() + "): ");
                        String index = scanner.nextLine();

                        words.removeWord(Integer.parseInt(index));
                    }
                    break;

                // allows user to output phonemeList
                case "output letters":
                case "7":
                    phonemes.outputPhonemeList();
                    break;

                // saving
                case "save":
                case "8":
                    System.out.println("Enter save file name (remember to check for excess files before creating new ones): ");
                    String saveInput = scanner.nextLine();

                    save.save(saveInput, phonemes, words); // saving to file with name saveInput
                    break;

                case "load":
                case "9":
                    System.out.println("Enter file name to load: ");
                    String loadInput = scanner.nextLine();

                    load.load(loadInput, phonemes, words); // loading file of name loadInput
                    break;

                // exiting
                case "exit":
                case "10":
                    System.exit(0);
                    break;

                // displaying unknown input error
                default:
                    System.out.println("Unexpected input, please try again");
                    break;
            }
        }
    }
}
