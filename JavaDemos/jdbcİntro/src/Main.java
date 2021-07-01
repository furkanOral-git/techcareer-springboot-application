import javax.naming.Name;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {


    public static void main(String[] args) throws SQLException {

        DBHelper helper = new DBHelper();
        helper.getConnection();


    }
    public void connection() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;

//Veritabanına erişim ve intellijde yazdırma
        try {
            connection = helper.getConnection();
            //statement ifade demek sql serverdaki kodu buraya entegre etmek için gerekli ifade.
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
            ArrayList<Country> countries = new ArrayList<Country>();

            while (resultSet.next()) {
                //next ifadesi tek tek gez demek.
                System.out.println(resultSet.getString("Name"));
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        } finally {
            connection.close();
    }

    //ınsert operasyonu
    public void ınsertData() throws SQLException {
           Connection connection = null;
           DBHelper helper = new DBHelper();
        PreparedStatement statment = null;

            try {
            connection = helper.getConnection();
            String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
            statment = connection.prepareStatement(sql);
            statment.setString(1, "Düzce 2");
            statment.setString(2, "TUR");
            statment.setString(3, "Turkey");
            statment.setInt(4, 70000);
            System.out.println("Kayıt Eklendi...");
        } catch (SQLException exception) {
            helper.showErrorMassage(exception);
        } finally {
            statment.close();
            connection.close();
        }
    }

    //Update Operasyonu
    public void updateData() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "update city set population=80000 where id=4080";
            statement = connection.prepareStatement(sql);
            int result = statement.executeUpdate();
            System.out.println("Kayıt Güncellendi...");
        } catch (SQLException exception) {

        }finally {
            statement.close();
            connection.close();
        }
    }

}

