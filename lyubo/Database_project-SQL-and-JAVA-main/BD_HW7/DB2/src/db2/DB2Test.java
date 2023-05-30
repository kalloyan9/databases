package db2;

import java.sql.*;


public class DB2Test {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public void openConnection() {

// Step 1: Load IBM DB2 JDBC driver	

        try {

            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());

        } catch (Exception cnfex) {

            System.out.println("Problem in loading or registering IBM DB2 JDBC driver");

            cnfex.printStackTrace();
        }

// Step 2: Opening database connection


        try {

            connection = DriverManager.getConnection("jdbc:db2://62.44.108.24:50000/SAMPLE", "db2admin", "db2admin");

            statement = connection.createStatement();

        } catch (SQLException s) {

            s.printStackTrace();

        }

    }

    public void closeConnection() {

        try {

            if (null != connection) {

                // cleanup resources, once after processing

                resultSet.close();

                statement.close();


                // and then finally close connection

                connection.close();

            }

        } catch (SQLException s) {

            s.printStackTrace();

        }

    }

    public String select(String stmnt) {

        try {

            resultSet = statement.executeQuery(stmnt);
            StringBuilder result = new StringBuilder();
            int columnNum = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {

                for (int i = 1; i <= columnNum; i++) {

                    result.append(resultSet.getString(i));

                    if (i == columnNum) result.append(" \n");
                    else result.append(", ");
                }
            }

            return result.toString();
        } catch (SQLException s) {

            s.printStackTrace();
            return "INVALID SELECT STATEMENT!";
        }

    }

    public boolean insert(String stmnt) {

        try {

            statement.executeUpdate(stmnt);
            return true;

        } catch (SQLException s) {

            s.printStackTrace();
            return false;
        }
    }


    public boolean delete(String stmnt) {

        try {

            statement.executeUpdate(stmnt);
            return true;

        } catch (SQLException s) {

            s.printStackTrace();
            return false;
        }
    }
}
   
    
     
   

 