import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTest extends TestCase {
    private Map<String, Account> accounts = new HashMap<>();
    Bank bank = new Bank();

    @Override
    protected void setUp() throws Exception {
        for (int i = 0; i < 1000; i++) {
            accounts.put(String.valueOf(i), new Account("№" + (int) (Math.random() * 60_000), (int) (Math.random() * 60_000)));

        }
    }
    public void testTransfer(){
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add( new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    try{
                        bank.transfer("№" + ((int)(Math.random() * 1_000)),"№" +  (int) (Math.random() * 1_000),
                                (int)(Math.random() * 60_000));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }


        }));
    }
    }
}


