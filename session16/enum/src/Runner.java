public class Runner {

    public static void main(String[] args) {
        Person hawzhin=new Person("Hawzhin","kordestani",Gender.FEMALE);
        Person hawzhinAgain=new Person("Hawzhin","kordestani",Gender.FEMALE);
        Person delnia=new Person("Delnia","sanandaji",Gender.FEMALE);

        System.out.println(hawzhin.equals(hawzhinAgain));
        System.out.println(hawzhin.equals(delnia));
        System.out.println(hawzhin.getGender().getValue());
    }
}
