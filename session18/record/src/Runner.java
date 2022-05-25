public class Runner {
    public static void main(String[] args) {
        BancAccount bancAccount=new BancAccount(1,"zhowan",3232.25);

        System.out.println(bancAccount.accountNumber());
        System.out.println(bancAccount.balance());
        System.out.println(bancAccount.name());
    }
}
