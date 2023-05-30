/*import java.sql.*;

public class DB2Test {
    public static void main(String[] args) {
        String url = "jdbc:db2://62.44.108.24:50000/SAMPLE";
        String user = "db2admin";
        String password = "db2admin";

        try {
            // Load the DB2 JDBC driver
            Class.forName("com.ibm.db2.jcc.DB2Driver");

            // Create a connection to the DB2 database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement object for executing SQL queries
            Statement statement = connection.createStatement();

            // Insert a new row into the "PEOPLE" table
            String sql = "INSERT INTO PEOPLE (EGN, EMAIL, GENDER, ADDRESS, NAME, PHONE_NUMBER) " +
                    "VALUES ('1234567890', 'john@example.com', 0, '123 Main St', 'John Doe', '1234567890')";

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("New row added successfully!");
            } else {
                System.out.println("Failed to add a new row.");
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}*/



import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;


public class DB2Test {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public void openConnection(){

// Step 1: Load IBM DB2 JDBC driver

        try {

            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());

        }

        catch(Exception cnfex) {

            System.out.println("Problem in loading or registering IBM DB2 JDBC driver");

            cnfex.printStackTrace();
        }

// Step 2: Opening database connection


        try {

            connection = DriverManager.getConnection("jdbc:db2://62.44.108.24:50000/SAMPLE", "db2admin", "db2admin");

            statement = connection.createStatement();

        }

        catch(SQLException s){

            s.printStackTrace();

        }

    }

    public void closeConnection(){

        try {

            if(null != connection) {

                // cleanup resources, once after processing

                resultSet.close();

                statement.close();


                // and then finally close connection

                connection.close();

            }

        }

        catch (SQLException s) {

            s.printStackTrace();

        }

    }

    public void select(String stmnt, int column) {

        try{

            resultSet = statement.executeQuery(stmnt);

            String result = "";

            while(resultSet.next()) {

                for (int i = 1; i <= column; i++) {

                    result += resultSet.getString(i);

                    if (i == column) result += " \n";
                    else             result += ", ";
                }
            }

            System.out.println("Executing query: " + stmnt + "\n");
            System.out.println("Result output \n");
            System.out.println("---------------------------------- \n");
            System.out.println(result);

        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }

    }

    public void insert(String stmnt) {

        try{

            statement.executeUpdate(stmnt);

        }

        catch (SQLException s){

            s.printStackTrace();

        }

        System.out.println("Successfully inserted!");

    }


    public void delete(String stmnt) {

        try{

            statement.executeUpdate(stmnt);

        }

        catch (SQLException s){

            s.printStackTrace();

        }

        System.out.println("Successfully deleted!");

    }

    public static void main(String[] args) {

        DB2Test db2Obj = new DB2Test();
        String stmnt = "";

        db2Obj.openConnection();

        stmnt = "SELECT * FROM FN5MI0700025.PEOPLE";
        db2Obj.select(stmnt, 6);
        System.out.println("\n");

        stmnt = "SELECT * FROM FN5MI0700025.ESTATES";
        db2Obj.select(stmnt, 4);
        System.out.println("\n");

        stmnt = "SELECT * FROM FN5MI0700025.COMPANIES";
        db2Obj.select(stmnt, 6);
        System.out.println("\n");

        stmnt = "SELECT * FROM FN5MI0700025.CONTRACTS";
        db2Obj.select(stmnt, 6);
        System.out.println("\n");

        db2Obj.delete(stmnt);

        db2Obj.closeConnection();

    }

}





