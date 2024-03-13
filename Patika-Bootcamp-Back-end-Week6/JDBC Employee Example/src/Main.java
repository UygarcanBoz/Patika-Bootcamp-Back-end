import java.sql.*;

public class Main {
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/employee";
    static final String USER = "root";
    static final String PASS = "mysql";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Register JDBC driver
            //Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            statement = connection.createStatement();

            // Create the 'employees' table
            createEmployeesTable(statement);

            // Insert sample data into 'employees' table
            insertSampleData(statement);

            // Retrieve and display data from 'employees' table
            retrieveAndDisplayData(statement);

        } /*catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/ catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createEmployeesTable(Statement statement) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "position VARCHAR(255)," +
                "salary DOUBLE)";
        statement.executeUpdate(createTableSQL);
    }

    private static void insertSampleData(Statement statement) throws SQLException {
        String insertDataSQL = "INSERT INTO employees (name, position, salary) VALUES " +
                "('John Doe', 'Software Engineer', 75000.0), " +
                "('Jane Smith', 'Project Manager', 90000.0), " +
                "('Bob Johnson', 'System Analyst', 80000.0), " +
                "('Alice Williams', 'Database Administrator', 85000.0), " +
                "('Charlie Brown', 'Network Engineer', 70000.0)";
        statement.executeUpdate(insertDataSQL);
    }

    private static void retrieveAndDisplayData(Statement statement) throws SQLException {
        String selectDataSQL = "SELECT id, name, position, salary FROM employees";
        ResultSet resultSet = statement.executeQuery(selectDataSQL);

        // Display the data
        System.out.println("\nEmployee Data:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String position = resultSet.getString("position");
            double salary = resultSet.getDouble("salary");

            System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
        }

        resultSet.close();
    }
}
