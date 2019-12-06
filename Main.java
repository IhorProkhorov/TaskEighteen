package eighteen;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Thread one = new Thread(account);
        Thread two = new Thread(account);
        one.setName("First");
        two.setName("Second");
        one.start();
        two.start();
    }
}
