/*
    The entire point of this class is to create a custom data type of type Letter
 */

import java.io.Serializable;

public class Letter implements Serializable {
    String phonemeType;
    String phonemeInput;
    String phonemeIPA;

    public Letter(String phonemeType, String phonemeInput, String phonemeIPA) {
        this.phonemeType = phonemeType;
        this.phonemeInput = phonemeInput;
        this.phonemeIPA = phonemeIPA;
    }

    // some formatting stuff
    @Override
    public String toString() {
        return "Phoneme[" + "Type=\"" + phonemeType + '\"' + ", Letter=<" + phonemeInput + '>' + ", IPA=[" + phonemeIPA + ']' + '}';
    }
}
