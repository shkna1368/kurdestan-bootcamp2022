import java.sql.*;

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
}
