package encryptdecrypt.algorithms;

public class Algorithms {

    public static String caesarCipher(String s, int key) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                int let = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - let + key) % 26) + let);
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static String unicodeCipher(String s, int key) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            c += key;
            sb.append(c);
        }

        return sb.toString();
    }

}
