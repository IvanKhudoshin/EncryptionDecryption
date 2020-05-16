package encryptdecrypt.algorithms;

public class EncryptionUnicode implements ProcessText {

    @Override
    public String process(String s, int key) {
        return Algorithms.unicodeCipher(s, key);
    }

}
