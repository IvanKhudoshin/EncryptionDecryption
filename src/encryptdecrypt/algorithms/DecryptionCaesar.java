package encryptdecrypt.algorithms;

public class DecryptionCaesar implements ProcessText {

    @Override
    public String process(String s, int key) {
        return Algorithms.caesarCipher(s, 26 - key);
    }

}
