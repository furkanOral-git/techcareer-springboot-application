import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String userName = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
        //Veri tabanına bağlanırken hangi veritabanı olduğu önemli değil driverlara
        //ihtiyaç duyarız.

    }
    public void showErrorMassage (SQLException exception) {
        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error Code : "+ exception.getErrorCode());
    }

}

