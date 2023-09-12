package au.com.nuvento.atm.utils;


import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;

import static au.com.nuvento.atm.ATM.bankAccount;

public class Commands {
    public double newBalance(String userName, String options, String userOption, double userAmount) {
        BankBuilder selectAccount = new BankBuilder();

        String grabAccountInfo = selectAccount.selectAccount(userName, options); // Turning 1 or 2 to accountNumber
        BankAccount b = bankAccount.get(grabAccountInfo); // getting accountNumber and Hashmapping it to an account

        double balance = Double.parseDouble(b.getOpeningBalance());

        switch (userOption) {
            case "1":
                return balance + userAmount;
            case "2":
                return balance - userAmount;
        }
        return balance;
    }
}
