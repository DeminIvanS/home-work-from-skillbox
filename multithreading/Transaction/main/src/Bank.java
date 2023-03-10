import java.util.Map;
import java.util.Random;


public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();



    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        Account lowSyncAccount;
        Account topSyncAccount;
        if(accounts.get(fromAccountNum).hashCode() > accounts.get(toAccountNum).hashCode()){
            lowSyncAccount = toAccount;
            topSyncAccount = fromAccount;
        }else{
            lowSyncAccount = fromAccount;
            topSyncAccount = toAccount;
        }

        if(getBalance(fromAccountNum) > amount && accounts.get(fromAccountNum).getAccNumber().charAt(0) != '!' &&accounts.get(toAccountNum).getAccNumber().charAt(0) != '!'){
            if(amount > 50_000){
                try {
                    boolean confirm = isFraud(fromAccountNum, toAccountNum, amount);
                    if(confirm){
                        if(fromAccountNum.equals(toAccountNum)){
                            accounts.get(fromAccountNum).setAccNumber("!" + fromAccountNum);
                        }
                        synchronized (lowSyncAccount) {
                            synchronized (topSyncAccount){
                            accounts.get(fromAccountNum).setAccNumber("!" + fromAccountNum);
                            accounts.get(toAccountNum).setAccNumber("!" + toAccountNum);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            synchronized (lowSyncAccount) {
                synchronized (topSyncAccount) {
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                }
            }


        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        long balance = accounts.get(accountNum).getMoney();


        return balance;
    }

    public long getSumAllAccounts() {
        long sumAllAccounts = 0;
        for(Object allAccounts : accounts.keySet())
        sumAllAccounts = sumAllAccounts + accounts.get(allAccounts).getMoney();

        return 0;
    }
}

