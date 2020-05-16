package encryptdecrypt;

import encryptdecrypt.factory.FactoryCipherAlgorithm;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        FactoryCipherAlgorithm factory = new FactoryCipherAlgorithm();
        Context context = new Context();

        try {
            for (int i = 0; i < args.length; i += 2) {
                if (!args[i].startsWith("-") || args[i + 1].startsWith("-")) {
                    System.out.println("Error: Illegal Arguments");
                    break;
                }

                switch (args[i]) {
                    case "-mode":
                        factory.setMode(args[i + 1]);
                        break;
                    case "-alg":
                        factory.setAlgorithm(args[i + 1]);
                        break;
                    case "-key":
                        context.setKey(Integer.parseInt(args[i + 1]));
                        break;
                    case "-data":
                        context.setData(args[i + 1]);
                        break;
                    case "-in":
                        context.setPathIn(args[i + 1]);
                        break;
                    case "-out":
                        context.setPathOut(args[i + 1]);
                        break;
                }

            }

            context.setProcess(factory.getCipherAlgorithm());

            context.processText();
        }
        catch (IllegalArgumentException | IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }
}
