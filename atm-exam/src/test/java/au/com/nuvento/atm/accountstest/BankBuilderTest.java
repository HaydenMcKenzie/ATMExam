package au.com.nuvento.atm.accountstest;

import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BankBuilderTest {
    ReadFile readFile;
    public static List<String[]> accountData;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        readFile = new ReadFile();
        accountData = readFile.getContentsFromFile("data/OpeningAccountsData.txt", "\\|\\|\\|");
    }

    @Test
    public void callAccountNumberAndAccountTypeFromOpeningAccountData() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount c = bankAccounts.get("002");
        assertEquals(c.getAccountNumber(), "7524155");

        BankBuilder selectAccount = new BankBuilder();
        String johnsFirstAccount = selectAccount.selectAccount("001", "1");
        String johnsSecondAccount = selectAccount.selectAccount("001", "2");

        System.out.println(johnsFirstAccount);
        System.out.println(johnsSecondAccount);
    }
}