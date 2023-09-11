package au.com.nuvento.atm;

import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import au.com.nuvento.atm.messages.AtmMessages;
import au.com.nuvento.atm.utils.verification;

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
    public static HashMap<String, Client> clients;
    public static HashMap<String, BankAccount> bankAccount;


    public static void userInteraction() throws FileNotFoundException {
        AtmMessages welcomeMessage = AtmMessages.INITAL;
        AtmMessages myOptions = AtmMessages.OPTIONS;

        // Scanner
        Scanner myObj = new Scanner(System.in); // Testing input values for bankaccount

        // Verification
        verification Verification = new verification(); // first validication

        // Bank Account
        BankBuilder selectAccount = new BankBuilder(); // import selectAccount

        System.out.println(welcomeMessage.getActions());
        String userName = myObj.nextLine();
        String result = Verification.firstInteraction(userName);


        Client c = clients.get(userName);
        System.out.println("Welcome " + c.getFirstName() + " "  + c.getSurname() + ". Please enter an Option"); // Testing getting name from ClientBuilder
        System.out.println(myOptions.getActions());
        String userOption = myObj.nextLine();


        //
        String grabAccount = selectAccount.accountSelect(userOption);
        System.out.println("Which account do you want to " + grabAccount + " from:");

        String firstAccount = selectAccount.selectAccount(userName, "1");
        String secondAccount = selectAccount.selectAccount(userName, "2");
        BankAccount x = bankAccount.get(firstAccount);
        BankAccount y = bankAccount.get(secondAccount);

        System.out.println("1 for " + x.getAccountNumber() + " (" + x.getAccountType() + ")");
        System.out.println("2 for " + y.getAccountNumber() + " (" + y.getAccountType() + ")");


        // Testing getting OpeningBalances
        String option = myObj.nextLine(); // test id

        String grabAccountInfo = selectAccount.selectAccount(userName, option); // Turning 1 or 2 to accountNumber
        BankAccount b = bankAccount.get(grabAccountInfo); // getting accountNumber and Hashmapping it to an account

        System.out.println("How much do you wish to " + grabAccount + "? Balance = $" + b.getOpeningBalance()); // grabs whatever I need it to.
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
