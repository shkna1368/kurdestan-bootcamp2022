public class DatabaseDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO=new EmployeeDAO();
        employeeDAO.connect();

        Employee e1=new Employee(null,"Rozhan amiri",25,6000000l);
        Employee e2=new Employee(null,"Rebwar ebrahimi",30,7000000l);
        Employee e3=new Employee(null,"Akam rezee",28,5000000l);
        Employee e4=new Employee(null,"Delnia  mohamadi",23,9000000l);

       Long e1Id= employeeDAO.insertNewEmployee(e1);
        System.out.println("e1Id="+e1Id);
       Long e2Id= employeeDAO.insertNewEmployee(e2);
        System.out.println("e2Id="+e2Id);

        Long e3Id= employeeDAO.insertNewEmployee(e3);
        System.out.println("e3Id="+e3Id);
       Long e4Id= employeeDAO.insertNewEmployee(e4);
        System.out.println("e4Id="+e4Id);
    }
}
