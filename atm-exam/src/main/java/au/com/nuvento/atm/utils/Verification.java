package au.com.nuvento.atm.utils;

import au.com.nuvento.atm.messages.AtmMessages;

public class Verification {
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
