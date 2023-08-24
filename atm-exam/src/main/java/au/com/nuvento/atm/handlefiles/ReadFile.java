package au.com.nuvento.atm.handlefiles;


import java.io.*;
import java.util.*;


public class ReadFile {

    public List<String[]> getContentsFromFile(String filePath, String remove_delim) throws FileNotFoundException {

        List<String[]> fileData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath));) {
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine().split(remove_delim));
            }
        }
        return fileData;
    }

}
