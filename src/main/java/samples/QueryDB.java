package samples;

import java.sql.*;

import static org.assertj.core.api.BDDAssumptions.given;

public class QueryDB {

    // Declaration of the variables

    private final String url = "jdbc:postgresql://localhost:5555/...";
    private final String user = "";
    private final String password = "";
    public static String fnum = null;
    public static Statement stmt;

    // Method to initalize connection to the database and execute query

    public void connect() {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            {
                if (conn != null) {

                    PreparedStatement pst = conn.prepareStatement("Select num from environ.pmc where id=1");
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {

                            fnum = rs.getString("num");
                            System.out.println("The value from the table is : "+ fnum);
                        }
                    }

                } else
                    System.out.println("Failed to connect");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
