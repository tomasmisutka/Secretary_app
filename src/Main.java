import java.util.ArrayList;

import Frames.Login;
import Services.DBConnection;

public class Main
{
    public static void main(String[] args)
    {
//        DBConnection connection = new DBConnection();
//        ArrayList<String> test = connection.getDbUsers();
//
//        for (String record: test)
//            System.out.println(record);
        new Login();
    }
}