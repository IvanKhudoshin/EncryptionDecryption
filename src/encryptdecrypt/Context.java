package encryptdecrypt;

import encryptdecrypt.algorithms.ProcessText;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Context {
    private String data;
    private String pathIn;
    private String pathOut;
    private int key;

    private ProcessText process;

    private String getFromPathIn() throws IOException {
        return Files.lines(Path.of(pathIn)).collect(Collectors.joining());
    }

    public void processText() throws IOException {
        if (data == null) {
            if (pathIn == null) {
                data = "";
            }
            else {
                data = getFromPathIn();
            }
        }

        String processedText = process.process(data, key);

        if (pathOut != null) {
            PrintStream writer = new PrintStream(pathOut);
            writer.println(processedText);
            writer.close();
        }
        else {
            System.out.println(processedText);
        }

    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPathIn(String pathIn) {
        this.pathIn = pathIn;
    }

    public void setPathOut(String pathOut) {
        this.pathOut = pathOut;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setProcess(ProcessText process) {
        this.process = process;
    }

    public String getData() {
        return data;
    }

    public String getPathIn() {
        return pathIn;
    }

    public String getPathOut() {
        return pathOut;
    }

    public int getKey() {
        return key;
    }

    public ProcessText getProcess() {
        return process;
    }
}
