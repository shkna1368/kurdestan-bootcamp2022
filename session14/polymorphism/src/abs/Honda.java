package abs;

public class Honda extends Bike{


    @Override
    void run() {
        System.out.println("Honda");
    }

    @Override
    public void speed() {
        System.out.println("speed in Honda");
    }
}
