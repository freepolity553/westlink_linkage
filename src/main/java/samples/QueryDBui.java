package samples;

import java.sql.*;

public class QueryDBui {

    public static String data() throws ClassNotFoundException, SQLException {
        // Подключение драйвера
        Class.forName("org.postgresql.Driver");

        // Создание подключения к БД
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5555/...", "", "");

        // Запрос БД
        PreparedStatement statement = con.prepareStatement("SELECT  X FROM  X ORDER  BY Id DESC LIMIT 1 ");

        // Создание переменной для запроса
        ResultSet result = statement.executeQuery();

        String numQuery = null;
        while (result.next()) {
            numQuery = result.getString("num");

            System.out.println("Номер из запроса " + numQuery);
        }
        return numQuery;
    }
}




