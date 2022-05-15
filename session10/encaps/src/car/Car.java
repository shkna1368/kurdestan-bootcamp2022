package car;

public class Car {
    private String model;
    private String brand;
    private int age;

    public Car(String model, String brand, int age) {
        this.model = model;
        this.brand = brand;
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void printDetail(){
        System.out.println(age+"-"+model+"-"+brand);
    }

}
