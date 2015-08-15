import java.sql.*;
import java.util.Properties;

/**
 * Program Title: Database Object
 * Programmer: Harsha Kuchampudi
 * Date: August 15, 2015
 *
 * Description:
 */


public class DatabaseConnection {

    // Driver Class Name
    private static final String dbClassName = "com.mysql.jdbc.Driver";

    // MySQL Connection Object
    private static Connection masterConnection;

    /**
     * The default constructor to obtain the database credentials so a successful connection can
     * be established to the database.
     * @param database_name String that contains the database name for the connection.
     * @param databaseUsername String containing the username to connect to the database.
     * @param databasePassword String containing the password to connect to the database.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    DatabaseConnection(String database_name, String databaseUsername, String databasePassword) throws ClassNotFoundException, SQLException {

        // Set the Connection Route
        String CONNECTION = "jdbc:mysql://localhost/" + database_name;

        // Initialize the Classes for the DB Driver
        Class.forName(dbClassName);

        // Establish Connection Parameters
        Properties connectProperties = new Properties();
        connectProperties.put("user", databaseUsername);
        connectProperties.put("password", databasePassword);

        // Set the Connection
        masterConnection = DriverManager.getConnection(CONNECTION, connectProperties);

    }

    /**
     * This method queries the database as per the input SQL query and then outputs the result in the
     * form of a string.
     * @param sqlQuery String containing a SQL query command.
     * @return String containing the results of the SQL query.
     * @throws SQLException
     */
    public String queryDatabase(String sqlQuery) throws SQLException {

        // Output String
        String queryResult;

        // Create Statement
        Statement queryStatement = masterConnection.createStatement();

        // Get the ResultSet from the Statement Execution
        ResultSet rs = queryStatement.executeQuery(sqlQuery);

        // Get the ResultSet Metadata
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberColumns = rsmd.getColumnCount();

        // Create an Array to Hold the Column Names
        String[] colunmNameArray = new String[numberColumns];

        // Loop Through the Metadata and Add the Column Names to the Array
        for(int counter = 1; counter <= numberColumns; counter++){

            // Add Column Names to Column Name Array
            colunmNameArray[counter - 1] = rsmd.getColumnName(counter);

        }

        // Create String Builder
        StringBuilder sb = new StringBuilder();

        // Iterate Through the Result Set
        while(rs.next()){

            // Temp String to Hold the Data for a Row
            StringBuilder tempString = new StringBuilder();

            // Iterate Through the Column Array
            for(String column : colunmNameArray){

                // Column Data
                String columnData = rs.getString(column);
                tempString.append(columnData);
                tempString.append("\t");

            }

            // Append a New Line to the End of the Temp String
            tempString.append("\n");

            // Add the Row Data to the String Builder
            sb.append(tempString);

        }

        // Close Statement and ResultSet Connection
        rs.close();
        queryStatement.close();

        // String Builder to String
        queryResult = String.valueOf(sb);

        // Return Statement
        return queryResult;

    }

    /**
     * This method allows the user to modify the database using input SQL statements that utilize INSERT, DELETE, or UPDATE
     * SQL commands.
     * @param executeQuery The INSERT, DELETE, or UPDATE SQL command statement entered as a string.
     * @return If any rows are modified, the return is an integer of the number of rows affected.
     * @throws SQLException
     */
    public int executeDatabase(String executeQuery) throws SQLException {

        // Boolean Result of the SQL Statement Execution
        int executeResult;

        // Statement Creation
        Statement executeStatement = masterConnection.createStatement();

        // Execute Statement
        executeResult = executeStatement.executeUpdate(executeQuery);

        // Evaluating Results of the Execution
        System.out.println(executeResult + " Row(s) Affected");

        // Return Number of Rows Affected
        return executeResult;

    }

    /**
     * Closes the connection to the database.
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {

        // Close Database Connection
        masterConnection.close();

    }

    /**
     * Returns a string containing the column names separated by '\t's.
     * @param tableName String containing the name of the table to get the column names for.
     * @return String separated by '\t' containing the column names for the table.
     * @throws SQLException
     */
    public String describeTable(String tableName) throws SQLException {

        // Statement Storage
        Statement describeStatement = masterConnection.createStatement();

        // ResultSet Storage
        ResultSet rsResult = describeStatement.executeQuery("select * from " + tableName);

        // Get the ResultSet Metadata
        ResultSetMetaData rsmd = rsResult.getMetaData();
        int numberColumns = rsmd.getColumnCount();

        // Create an Array to Hold the Column Names
        String colunmNames = "";

        // Loop Through the Metadata and Add the Column Names to the Array
        for(int counter = 1; counter <= numberColumns; counter++){

            // Add Column Names to Column Name Array
            colunmNames += (rsmd.getColumnName(counter) + "\t");

        }

        // Return Column Names
        return colunmNames;

    }

}
