package Services;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection
{
    public DBConnection()
    {
    }

    public ArrayList<String> getDbUsers()
    {
        ArrayList<String> data = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/secretaryApp",
                    "student", "student");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            String finalRecord = "";

            while (resultSet.next()) {
                finalRecord += resultSet.getString("name") + " ";
                finalRecord += resultSet.getString("surname") + " ";
                finalRecord += resultSet.getString("address") + " ";
                finalRecord += resultSet.getString("phone") + " ";
                finalRecord += resultSet.getString("email");

                data.add(finalRecord);
                finalRecord = "";
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return data;
    }
}