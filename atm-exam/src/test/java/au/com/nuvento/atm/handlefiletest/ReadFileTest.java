package au.com.nuvento.atm.handlefiletest;


import au.com.nuvento.atm.handlefiles.ReadFile;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadFileTest {

    // getContentsFromFile(String filePath, String remove_delim)
    @Test
    public void readUserInfoDataThenCountElements() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String[]>  userInfo = readFile.getContentsFromFile("data/UserInfo.txt", ",");

        assertEquals(userInfo.size(), 4);
        assertEquals(userInfo.get(0).length, 4);
    }
}

