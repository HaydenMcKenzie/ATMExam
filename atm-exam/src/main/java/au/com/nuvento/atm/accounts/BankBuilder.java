package au.com.nuvento.atm.accounts;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class BankBuilder {

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
            bankAccount.put(u.getAccountOwnerID(), u);
        });
        return bankAccount;
    }

}
