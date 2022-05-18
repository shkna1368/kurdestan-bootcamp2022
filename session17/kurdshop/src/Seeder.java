import java.util.Date;

public class Seeder {

    public static void main(String[] args) {
        Category categoryMob=new Category(1,"Mobile");
        Category categoryTV=new Category(2,"TV");

        Brand brandSony=new Brand(1,"Sony");
        Brand brandSamsung=new Brand(2,"Samsung");

        Provider providerSarir=new Provider(1,"Sarir");
        Provider providerHamgam=new Provider(2,"Hamgam");
        Provider providerTose=new Provider(3,"Tose");

        Provider[] providers1={providerTose,providerSarir};
        Provider[] providers2={providerHamgam};

        Product product=new Product(1,"S22",6500000,categoryMob,providers1,brandSamsung);
        Product product2=new Product(2,"W600",9000000,categoryTV,providers2,brandSony);

        Product[] products={product,product2};


        Customer customer=new Customer(1,"Hiwa","Kurdestani","Sna-");

        Basket basket=new Basket(1,new Date(),customer,products);

        System.out.println(basket);

        System.out.println("Total price of basket:"+basket.calculateTotalPrice());




    }
}
