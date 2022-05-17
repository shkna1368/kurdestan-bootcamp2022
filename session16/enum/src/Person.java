public class Person {

    private String name;
    private String family;
    private Gender gender;

    public Person(String name, String family,Gender gender) {
        this.name = name;
        this.family = family;
        this.gender=gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    @Override
    public boolean equals(Object obj) {
        Person person= (Person) obj;


        return  (name.equals(person.getName()) && family.equals(person.getFamily()));

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", gender=" + gender +
                '}';
    }
}
