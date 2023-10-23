package au.com.nuvento.atm.utils;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.messages.AtmMessages;
import au.com.nuvento.atm.messages.ClosingMessage;

import java.io.FileNotFoundException;

public class Verification {

    public String firstInteraction(String userID) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (userID) {
            case "001":
            case "002":
            case "003":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
        }
        return userID;
    }

    public String secondInteraction(String userOption) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (userOption) {
            case "1":
            case "2":
            case "3":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
        }
        return userOption;
    }

    public String thirdInteraction(String options) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (options) {
            case "1":
            case "2":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
                break;
        }
        return options;
    }

    public void fourthInteraction(double newBal) throws FileNotFoundException {
        ClosingMessage closingMessage = new ClosingMessage();
        AtmMessages errorMessage = AtmMessages.ERROR;

        if (newBal < 0) {
            System.out.println(errorMessage.getActions());
            closingMessage.endMessage();
            ATM.setup();
            ATM.userInteraction();
        }
    }
}
