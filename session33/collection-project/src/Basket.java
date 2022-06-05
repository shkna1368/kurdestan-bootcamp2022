import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Basket {
    private long id;
    private Date created;
    private Customer customer;
    private List<Product> products;

    public Basket(long id, Date created, Customer customer, List<Product> products) {
        this.id = id;
        this.created = created;
        this.customer = customer;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public long calculateTotalPrice(){
        long total=0;
        for(Product product:products){
           total+=product.getPrice() ;

        }

        return total;


    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", created=" + created +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
