package au.com.nuvento.atm;

import au.com.nuvento.atm.handlefiles.ReadFile;

import java.io.*;
import java.util.*;

/**
 *
 *
 */
public class ATM
{
    public static void main( String[] args ) throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        readFile.getContentsFromFile("data/UserInfo.txt", ",");
    }
}
