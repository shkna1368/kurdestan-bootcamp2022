public class TwoGen<T,V> {
   private T ob1;
  private   V ob2;

    public TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    public T getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }

    public void showType(){
        System.out.println("Type of T is:"+ob1.getClass().getName());
        System.out.println("Type of V is:"+ob2.getClass().getName());
    }
}
