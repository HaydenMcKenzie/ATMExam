package au.com.nuvento.atm.utils;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.messages.AtmMessages;

import java.io.FileNotFoundException;

public class Verification {
    public String firstInteraction(String userID) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        switch (userID) {
            case "001":
            case "002":
            case "003":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
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
        switch (userOption) {
            case "1":
            case "2":
            case "3":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
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
        switch (options) {
            case "1":
            case "2":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
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
        if (newBal < 0) {
            AtmMessages errorMessage = AtmMessages.ERROR;
            System.out.println(errorMessage.getActions());
            ATM.setup();
            ATM.userInteraction();
        }
    }
}
