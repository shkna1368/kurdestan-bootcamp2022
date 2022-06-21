package singltone;

public class RunOne {

    public static void main(String[] args) {
       Singleton s1=Singleton.getInstance();
       Singleton s2=Singleton.getInstance();
       RunTwo.test();
    }
}
