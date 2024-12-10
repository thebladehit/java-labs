package task1.test;

import org.junit.jupiter.api.Test;
import task1.Account;
import task1.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    public void testBank() throws InterruptedException {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            accounts.add(new Account(i, 1000));
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                int fromIndex = random.nextInt(100);
                int toIndex;
                do {
                    toIndex = random.nextInt(100);
                } while (fromIndex == toIndex);

                int amount = random.nextInt(1000);

                Account from = accounts.get(fromIndex);
                Account to = accounts.get(toIndex);

                try {
                    bank.transfer(from, to, amount);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        int finalTotal = accounts.stream().mapToInt(Account::getBalance).sum();
        assertEquals(100 * 1000, finalTotal);
    }
}