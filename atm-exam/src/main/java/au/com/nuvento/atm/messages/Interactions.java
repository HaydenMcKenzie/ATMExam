package au.com.nuvento.atm.messages;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;

import java.io.FileNotFoundException;

import static au.com.nuvento.atm.ATM.bankAccount;
import static au.com.nuvento.atm.ATM.clients;

public class Interactions {

    public void welcomeInteraction() {
        AtmMessages welcomeMessage = AtmMessages.INITAL;

        System.out.println(welcomeMessage.getActions());
    }

    public void userDecision(String userName) {
        AtmMessages myOptions = AtmMessages.OPTIONS;

        Client c = clients.get(userName);
        System.out.println("Welcome " + c.getFirstName() + " "  + c.getSurname() + ". Please enter an Option"); // Testing getting name from ClientBuilder
        System.out.println(myOptions.getActions());
    }

    public String grabInfo(String userOption) {
        BankBuilder selectAccount = new BankBuilder(); // import selectAccount
        return selectAccount.accountSelect(userOption);
    }

    public void showAccount(String userName, String userOption) {
        BankBuilder account = new BankBuilder(); // import selectAccount

        System.out.println("Which account do you want to " + grabInfo(userOption) + " from:");

        String firstAccount = account.selectAccount(userName, "1");
        String secondAccount = account.selectAccount(userName, "2");
        BankAccount x = bankAccount.get(firstAccount);
        BankAccount y = bankAccount.get(secondAccount);

        switch (userName) {
            case "001":
            case "002":
                System.out.println("1 for " + x.getAccountNumber() + " (" + x.getAccountType() + ")");
                System.out.println("2 for " + y.getAccountNumber() + " (" + y.getAccountType() + ")");
                break;
            case "003":
                System.out.println("1 for " + x.getAccountNumber() + " (" + x.getAccountType() + ")");
                break;
        }

    }

    public void enterInAccount(String userName, String options, String userOption) throws FileNotFoundException {
        BankBuilder selectAccount = new BankBuilder(); // import selectAccount

        String grabAccountInfo = selectAccount.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        switch (userOption) {
            case "1":
            case "2":
                System.out.println("How much do you wish to " + grabInfo(userOption) + "? Balance = $" + b.getOpeningBalance());
                break;
            case "3":
                System.out.println("Your account balance is: $" + b.getOpeningBalance());
                ATM.setup();
                ATM.userInteraction();
        }
    }
}
