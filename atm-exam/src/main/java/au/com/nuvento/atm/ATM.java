package au.com.nuvento.atm;

import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccount = bankBuilder.createBank(accountData);


        Client c = clients.get("002");
        System.out.println(c.getFirstName() + " "  + c.getSurname()); // Testing getting name from ClientBuilder


        // Testing getting OpeningBalances
        Scanner myObj = new Scanner(System.in); // Testing input values for bankaccount
        String userName = myObj.nextLine(); // test user
        String option = myObj.nextLine(); // test id

        BankBuilder selectAccount = new BankBuilder(); // import selectAccount
        String grabAccountInfo = selectAccount.selectAccount(userName, option); // Turning 1 or 2 to accountNumber


        BankAccount b = bankAccount.get(grabAccountInfo); // getting accountNumber and Hashmapping it to an account
        System.out.println(b.getOpeningBalance()); // grabs whatever I need it to.
    }


    public static void setup() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        userData = readFile.getContentsFromFile("atm-exam/data/UserInfo.txt", ",");
        accountData = readFile.getContentsFromFile("atm-exam/data/OpeningAccountsData.txt", "\\|\\|\\|");
    }
}
