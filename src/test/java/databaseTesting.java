import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseTesting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	 // Database connection details
        String databaseURL = "jdbc:mysql://localhost:3306/org";
        String user = "root";
        String password = "Kolkata@123";
        
     // Load the MySQL JDBC driver and establish connection
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Connecting to Database");
         Connection connection = DriverManager.getConnection(databaseURL, user, password);
         
      // Check if the connection is successful
         if (connection == null) {
                System.out.println("Database Connection Failed");
            }else {
                System.out.println("Database Connection Successful");
            }
         // SQL query to retrieve worker from the database
         String query = "SELECT * FROM worker";
         Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery(query);
         
      // Iterate through the result set and print worker details
         while (resultSet.next()) {
             int empId = resultSet.getInt("WORKER_ID");
             String empFirstName = resultSet.getString("FIRST_NAME");
             String empLastName = resultSet.getString("LAST_NAME");
             int salary = resultSet.getInt("SALARY");
             String department = resultSet.getString("DEPARTMENT");
             
             // Print worker details
             System.out.println("Employee ID: " + empId + ", First Name: " + empFirstName + ", Last Name: " 
+ empLastName + ", Salary: " + salary + ", Department: " + department);
             
        }
    
	 
    if (connection != null) {
        try {
            System.out.println("Closing Database Connection...");
            connection.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
        
    }
    }
	}

	

	
