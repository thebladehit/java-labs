package task1;

public class Bank {
    public void transfer(Account from, Account to, int amount) throws InterruptedException {
        if (from == to) {
            return;
        }

        Account first = from.getId() > to.getId() ? to : from;
        Account second = from.getId() > to.getId() ? from : to;

        first.getLock().lock();
        try {
            second.getLock().lock();
            try {
                if (from.getBalance() < amount) {
                    throw new IllegalArgumentException("No funds");
                }
                from.withdraw(amount);
                to.deposit(amount);
            } finally {
                second.getLock().unlock();
            }
        } finally {
            first.getLock().unlock();
        }
    }
}
