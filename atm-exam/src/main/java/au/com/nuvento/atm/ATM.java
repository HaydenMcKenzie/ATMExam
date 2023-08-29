package au.com.nuvento.atm;

import au.com.nuvento.atm.handlefiles.ReadFile;

import java.io.FileNotFoundException;
//import java.util.Arrays;
import java.util.List;

/**
 *
 *
 */
public class ATM
{
    public static void main( String[] args ) throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String[]> userData = readFile.getContentsFromFile("atm-exam/data/UserInfo.txt", ",");
    }
}
