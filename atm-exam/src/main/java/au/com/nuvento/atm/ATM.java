package au.com.nuvento.atm;

import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 */
public class ATM
{
    public static List<String[]> userData;
    public static List<String[]> accountData;



    public static void main( String[] args ) throws FileNotFoundException {
        setup();
        ClientBuilder clientBuilder = new ClientBuilder();
        HashMap<String, Client> clients = clientBuilder.createUser(userData);
    }


    public static void setup() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        userData = readFile.getContentsFromFile("atm-exam/data/UserInfo.txt", ",");
        accountData = readFile.getContentsFromFile("atm-exam/data/OpeningAccountsData.txt", "\\|\\|\\|");
    }
}
