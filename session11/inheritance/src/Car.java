public class Car extends Vehicle{

    private int wheel;

    public Car(String model, String make, int age, int wheel) {
        super(model, make, age);

        this.wheel = wheel;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public void describe() {
        System.out.println("This is a car");
        super.describe();
    }

}
