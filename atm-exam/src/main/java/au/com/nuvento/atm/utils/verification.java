package au.com.nuvento.atm.utils;

import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.messages.AtmMessages;

import java.util.Scanner;

public class verification {
    public String firstInteraction(String userID) {
        switch (userID) {
            case "001":
            case "002":
            case "003":
                return "";
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                return userID;
        }
    }

}
