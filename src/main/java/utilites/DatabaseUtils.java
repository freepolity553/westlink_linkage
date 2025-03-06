package utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {


    private static final String URL_USERS = "jdbc:postgresql://ln2-pg01-dev.int.linkage.ru:5432/ln_user__dev";
    private static final String USER_USERS = "ln_user__dev";
    private static final String PASSWORD_USERS = "y0zbY89L";

    private static final String URL_NAVIGATOR = "jdbc:postgresql://ln2-pg01-dev.int.linkage.ru:5432/navigator__dev";
    private static final String USER_NAVIGATOR = "navigator__dev";
    private static final String PASSWORD_NAVIGATOR = "Metrics87634";

    public static Connection getConnectionUsers() throws SQLException {
        return DriverManager.getConnection(URL_USERS, USER_USERS, PASSWORD_USERS);
    }

    public static Connection getConnectionNavigator() throws SQLException {
        return DriverManager.getConnection(URL_NAVIGATOR, USER_NAVIGATOR, PASSWORD_NAVIGATOR);
    }

}
