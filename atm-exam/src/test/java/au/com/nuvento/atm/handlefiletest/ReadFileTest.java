package au.com.nuvento.atm.handlefiletest;


import au.com.nuvento.atm.handlefiles.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class ReadFileTest {

    // getContentsFromFile(String filePath, String remove_delim)
    @Test
    public void readUserInfoDataThenCountElements() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String[]>  userInfo = readFile.getContentsFromFile("data/UserInfo.txt", ",");

        assertEquals(userInfo.size(), 4);
    }
}

