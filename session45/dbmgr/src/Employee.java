public class Employee {

    private Long id;
    private String fullName;
    private Integer age;
    private Long salary;

    public Employee(Long id, String fullName, Integer age, Long salary) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Employee setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Long getSalary() {
        return salary;
    }

    public Employee setSalary(Long salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
