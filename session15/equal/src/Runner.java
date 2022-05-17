public class Runner {

    public static void main(String[] args) {
        Person hawzhin=new Person("Hawzhin","kordestani");
        Person hawzhinAgain=new Person("Hawzhin","kordestani");
        Person delnia=new Person("Delnia","sanandaji");

        System.out.println(hawzhin.equals(hawzhinAgain));
        System.out.println(hawzhin.equals(delnia));
    }
}
