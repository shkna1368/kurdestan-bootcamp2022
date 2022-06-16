import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private final String url="jdbc:postgresql://localhost:5432/dbemployee";
    private final String user="postgres";
    private final String password="Shkna1368";

    private Connection connection;

    public EmployeeDAO() {
    }

    public Connection connect(){
        try {
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("successfully connect");
        } catch (SQLException e) {
            System.out.println("Can not connect to db");
            System.out.println(e.toString());
        }
     return  connection;
    }

    public Long insertNewEmployee(Employee employee){
     String query=" INSERT INTO tblemployee(full_name,age,salary) "
             + "VALUES (?,?,?)";

     Long id=0l;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1,employee.getFullName());
            preparedStatement.setInt(2,employee.getAge());
            preparedStatement.setLong(3,employee.getSalary());

            int affectedRows=preparedStatement.executeUpdate();

            if (affectedRows>0){
                ResultSet rs=preparedStatement.getGeneratedKeys();
                if (rs.next()){
                    id=rs.getLong(1);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

return  id;
    }


    public int updateEmployee(Long id,Long amount){
        String query=" UPDATE tblemployee"
                +" SET salary = ? "
                +" WHERE  id = ? ";


        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(query);
      preparedStatement .setLong(1,amount);
      preparedStatement .setLong(2,id);
      int affectedRows= preparedStatement.executeUpdate();

      return affectedRows;

        } catch (SQLException e) {


            e.printStackTrace();
        }


       return  0;
    }
    public int deleteEmployee(Long id){
        String query=" DELETE  from tblemployee"
                +" WHERE  id = ? ";


        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(query);

      preparedStatement .setLong(1,id);
      int affectedRows= preparedStatement.executeUpdate();

      return affectedRows;

        } catch (SQLException e) {


            e.printStackTrace();
        }


       return  0;
    }



    public List<Employee> filterByAge(int candidAge){

        List<Employee> employees=new ArrayList<>();
        String query=" select * from tblemployee"

                +" WHERE  age >= ? ";


        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(query);
      preparedStatement .setInt(1,candidAge);
      ResultSet resultSet= preparedStatement.executeQuery();

      while (resultSet.next()){

         long id=resultSet.getLong("id") ;
         long salary=resultSet.getLong("salary") ;
         int age=resultSet.getInt("age") ;
         String fullName =resultSet.getString("full_Name") ;

         Employee employee=new Employee(id,fullName,age,salary);
         employees.add(employee);



      }

        } catch (SQLException e) {


            e.printStackTrace();
        }


       return  employees;
    }



    public List<Employee> getAll(){

        List<Employee> employees=new ArrayList<>();
        String query=" select * from tblemployee";



        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(query);

      ResultSet resultSet= preparedStatement.executeQuery();

      while (resultSet.next()){

         long id=resultSet.getLong("id") ;
         long salary=resultSet.getLong("salary") ;
         int age=resultSet.getInt("age") ;
         String fullName =resultSet.getString("full_Name") ;

         Employee employee=new Employee(id,fullName,age,salary);
         employees.add(employee);



      }

        } catch (SQLException e) {


            e.printStackTrace();
        }


       return  employees;
    }

    public Employee getById(Long candidId){

        String query=" select * from tblemployee"

                +" WHERE  id >= ? ";


        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(query);
            preparedStatement .setLong(1,candidId);
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){

                long id=resultSet.getLong("id") ;
                long salary=resultSet.getLong("salary") ;
                int age=resultSet.getInt("age") ;
                String fullName =resultSet.getString("full_Name") ;

                Employee employee=new Employee(id,fullName,age,salary);

return employee;

            }

        } catch (SQLException e) {


            e.printStackTrace();
        }


        return  null;
    }







}
