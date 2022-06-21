package singltone;

public class Singleton {
    private static  Singleton obj  = null;
    private Singleton() {

        System.out.println("constructor call");
    }

    public static Singleton getInstance()
    {
        if (obj == null)
        {
            // To make thread safe
            synchronized (Singleton.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj==null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
}
