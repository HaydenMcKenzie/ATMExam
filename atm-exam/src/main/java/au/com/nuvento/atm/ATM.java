package au.com.nuvento.atm;

// Import Classes
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import au.com.nuvento.atm.messages.*;
import au.com.nuvento.atm.utils.Verification;

// Import Java Classes
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ATM
{
    public static HashMap<String, Client> clients;
    public static HashMap<String, BankAccount> bankAccount;


    public static void userInteraction() throws FileNotFoundException {
        // Imports
        Scanner sc = new Scanner(System.in); // Testing input values for bankaccount
        Verification verification = new Verification(); // first validation
        Interactions interactions = new Interactions();

        // Intro
        interactions.welcomeInteraction();
        String userName = sc.nextLine();
        verification.firstInteraction(userName);

        // Printing Name with Options
        interactions.userDecision(userName);
        String userOption = sc.nextLine();
        verification.secondInteraction(userOption);

        // Showing the accounts
        interactions.showAccount(userName, userOption);
        String options = sc.nextLine(); // test id
        verification.thirdInteraction(options);

        // Showing Balance and enter amount
        interactions.enterInAccount(userName, options, userOption);
        ATM.userInteraction();
    }

    public static void main( String[] args ) throws FileNotFoundException {
        setup();
        userInteraction();
        // Write to File
    }


    public static void setup() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String[]> userData = readFile.getContentsFromFile("atm-exam/data/UserInfo.txt", ",");
        List<String[]> accountData = readFile.getContentsFromFile("atm-exam/data/OpeningAccountsData.txt", "\\|\\|\\|");

        ClientBuilder clientBuilder = new ClientBuilder();
        clients = clientBuilder.createUser(userData);

        BankBuilder bankBuilder = new BankBuilder();
        bankAccount = bankBuilder.createBank(accountData);
    }
}
