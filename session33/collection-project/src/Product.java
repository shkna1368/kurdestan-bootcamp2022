import java.util.Arrays;
import java.util.List;

public class Product {

    private long id;
    private String title;
    private double price;

    private Category category;
    private List<Provider> providers;
    private Brand brand;

    public Product(long id, String title, double price, Category category, List<Provider> providers, Brand brand) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.providers = providers;
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", providers=" + providers +
                ", brand=" + brand +
                '}';
    }
}
