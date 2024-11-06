package archive;

import java.sql.*;

public class QueryDBui {

    public static String data() throws ClassNotFoundException, SQLException {
        // Подключение драйвера
        Class.forName("org.postgresql.Driver");

        // Создание подключения к БД
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5555/stg", "sreda", "s0D-@!");

        // Запрос БД
        PreparedStatement statement = con.prepareStatement("SELECT num FROM environ.pmc ORDER  BY Id DESC LIMIT 1 ");

        // Создание переменной для запроса
        ResultSet result = statement.executeQuery();

        String numQuery = null;
        while (result.next()) {
            numQuery = result.getString("num");

            System.out.println("Номер РВИ из запроса " + numQuery);
        }
        return numQuery;
    }
}




