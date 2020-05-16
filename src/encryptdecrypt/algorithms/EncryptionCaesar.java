package encryptdecrypt.algorithms;

public class EncryptionCaesar implements ProcessText {

    @Override
    public String process(String s, int key) {
        return Algorithms.caesarCipher(s, key);
    }

}
