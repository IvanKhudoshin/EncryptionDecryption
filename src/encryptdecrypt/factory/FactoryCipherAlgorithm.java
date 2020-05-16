package encryptdecrypt.factory;

import encryptdecrypt.algorithms.*;

public class FactoryCipherAlgorithm {

    private Algorithm algorithm;
    private Mode mode;

    public FactoryCipherAlgorithm(String algorithm, String mode) {
        this(Algorithm.toAlgorithm(algorithm), Mode.toMode(mode));
    }

    public FactoryCipherAlgorithm() {
        algorithm = Algorithm.SHIFT;
        mode = Mode.ENCRYPTION;
    }

    public FactoryCipherAlgorithm(Algorithm algorithm, Mode mode) {
        this.algorithm = algorithm;
        this.mode = mode;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(String algorithm) {
        setAlgorithm(Algorithm.toAlgorithm(algorithm));
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(String mode) {
        setMode(Mode.toMode(mode));
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public ProcessText getCipherAlgorithm() {
        if (algorithm == Algorithm.SHIFT) {
            if (mode == Mode.ENCRYPTION) {
                return new EncryptionCaesar();
            } else if (mode == Mode.DECRYPTION) {
                return new DecryptionCaesar();
            }
        } else if (algorithm == Algorithm.UNICODE) {
            if (mode == Mode.ENCRYPTION) {
                return new EncryptionUnicode();
            } else if (mode == Mode.DECRYPTION) {
                return new DecryptionUnicode();
            }
        }

        throw new IllegalArgumentException();
    }

    private enum Algorithm {
        SHIFT,
        UNICODE;

        public static Algorithm toAlgorithm(String s) {
            s = s.toUpperCase();

            switch (s) {
                case "SHIFT":
                    return SHIFT;
                case "UNICODE":
                    return UNICODE;
            }

            throw new IllegalArgumentException();
        }

    }

    private enum Mode {
        ENCRYPTION,
        DECRYPTION;

        public static Mode toMode(String s) {
            s = s.toUpperCase();

            switch (s) {
                case "ENC":
                case "ENCRYPTION":
                    return ENCRYPTION;
                case "DEC":
                case "DECRYPTION":
                    return DECRYPTION;
            }

            throw new IllegalArgumentException();
        }
    }
}
