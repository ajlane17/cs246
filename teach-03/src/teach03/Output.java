package teach03;


import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private static Output outputInstance = null;

    private Output() {
    }

    public static Output getInstance() {
        if (outputInstance == null) {
            outputInstance = new Output();
        }
        return outputInstance;
    }

    public boolean writeToFile(String filename, String contents) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(contents);
            fileWriter.close();
            return true;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
