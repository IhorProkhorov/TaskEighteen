package eighteen;

public class Account implements Runnable {

    private int balance = 60;

    public int getBalance() {
        return balance;
    }

    public void putMoney(int amount){
        balance += amount;
    }

    public void getMoney(int amount){
        balance -= amount;
    }

    public synchronized void putMoneyOnAcc(int amount){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        putMoney(amount);
        System.out.println(Thread.currentThread().getName() + " has put money on account " + amount );
    }

    public synchronized void getMoneyFromAccount(int amount){
        if ( getBalance() >= amount){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            getMoney(amount);
            System.out.println(Thread.currentThread().getName() + " has taken money from account " + amount );
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            getMoneyFromAccount(40);
            putMoneyOnAcc(10);
        }
        System.out.println("Balance after operations " + getBalance());
    }

}
