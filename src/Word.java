/*
    The entire point of this class is to create a custom data type of type Word
 */

public class Word {
    String wordType;
    String wordSpelling;
    String translatesTo;

    public Word(String wordTypeInput, String wordSpellingInput, String translatesToInput) {
        this.wordSpelling = wordSpellingInput;
        this.wordType = wordTypeInput;
        this.translatesTo = translatesToInput;
    }

    @Override
    public String toString() {
        return "Word[" + "Type='" + wordType + '\'' + ", Spelling='" + wordSpelling + '\'' + ", Translation= '" + translatesTo + '\'' + ']';
    }
}
