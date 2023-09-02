package au.com.nuvento.atm.accounts;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class BankBuilder {
    public String selectAccount(String userID, String accountSelect)  {
        switch (userID) {
            case "001":
                switch (accountSelect) {
                    case "1":
                        return "9264945";
                    case "2":
                        return "7814135";
                }
            case "002":
                switch (accountSelect) {
                    case "1":
                        return "9676422";
                    case "2":
                        return "7524155";
                }
            case "003":
                if (accountSelect.equals("1")) {
                    return "9042221";
                } else {
                    System.out.println("Error");
                }
            default:
                System.out.println("Error");
        }
        return userID;
    }

    public BankAccount createBank(String[] accountInfo) {
        HashMap<String, BankAccount> bankAccount = new HashMap<>();
        if (accountInfo.length == 4) {
            return new BankAccount(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
        }
        return null;
    }

    public HashMap<String, BankAccount> createBank( List<String[]> info ) throws FileNotFoundException {
        HashMap<String, BankAccount> bankAccount = new HashMap<>();
        info.stream().forEach(x -> {
            BankAccount u = createBank(x);
            bankAccount.put(u.getAccountNumber(), u);
        });
        return bankAccount;
    }
}
