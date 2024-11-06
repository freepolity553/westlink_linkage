package archive;

import java.sql.*;

import static org.assertj.core.api.BDDAssumptions.given;

public class QueryDB {

    // Declaration of the variables

    private final String url = "jdbc:postgresql://localhost:5555/stg";
    private final String user = "sreda";
    private final String password = "s0D-@!";
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

//    // Main method and Rest Assured Code
//    public static void main(String[] args) {
//        QueryDB app = new QueryDB();
//        app.connect();
//        //given().when().get("https://reqres.in/api/users/2").then().body("data.first_name", equalTo(fname));
//        System.out.println("Execution Successful" + fname);
//    }

}
