package com.infobeans.main;
import java.util.*;
import com.infobeans.service.EmployeeService;

public class EmployeeMain {
	
	public static void main(String[] args) throws Exception {
	
		Scanner scanner= new Scanner(System.in);
		EmployeeService employeesService=new EmployeeService();
        
        System.out.println("===========================EMPLOYEE MANAGEMENT SYSTEM==============================");
        System.out.println();
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            System.out.print("");
            int choice = scanner.nextInt();
            System.out.println();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    LOGIN.login();
                    break;
                case 2:
                    USER_OPERATIONS.userOperations();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

//package com.infobeans.main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.*;
//
//import com.infobeans.model.User;
//
//public class EmployeeMain {
//	static Scanner scanner = new Scanner(System.in);
//    static Connection conn;
//
//    public static void main(String[] args) {
//        connectDatabase();
//        
//        
//        System.out.println("===========================EMPLOYEE MANAGEMENT SYSTEM==============================");
//        System.out.println();
//        while (true) {
//            System.out.println("1. Login");
//            System.out.println("2. Register");
//            System.out.println("3. Exit");
//            System.out.println();
//            System.out.print("Enter your choice: ");
//            System.out.println();
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            
//            switch (choice) {
//                case 1:
//                    login();
//                    break;
//                case 2:
//                    userOperations();
//                    break;
//                case 3:
//                    System.out.println("Exiting...");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        }
//    }
//    
//    public static void connectDatabase() {
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "raghvendra");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static User login() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter Username: ");
//        String username = scanner.nextLine();
//        System.out.print("Enter Password: ");
//        String password = scanner.nextLine();
//
//        User authenticatedUser = authenticateUser(username, password);
//
//        if (authenticatedUser != null) {
//            System.out.println("Login Successful!");
//            employeeMenu(authenticatedUser); // Redirect to employee menu after successful login
//            return authenticatedUser;
//        } else {
//            System.out.println("Invalid Credentials! Please try again.");
//            return null;
//        }
//    }
//
//
//    public static User authenticateUser(String username, String password) {
//        try {
//            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return new User(
//                    rs.getInt("id"),
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("email"),
//                    rs.getString("role"),
//                    rs.getString("department")
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null; 
//    }
//
//    public static void userOperations() {
//    	
//    	System.out.println("===============================USER MANAGEMENT SYSTEM================================");
//        while (true) {
//            System.out.println("1. Enter User Details");
//            System.out.println("2. View All Users");
//            System.out.println("3. Update User Details");
//            System.out.println("4. Delete User");
//            System.out.println("5. Back");
//            System.out.println();
//            System.out.print("Enter your choice: ");
//            System.out.println();
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            
//            switch (choice) {
//                case 1:
//                    enterUserDetails();
//                    break;
//                case 2:
//                    viewAllUsers();
//                    break;
//                case 3:
//                    updateUser();
//                    break;
//                case 4:
//                    deleteUser();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        }
//    }
//    
//    public static void enterUserDetails() {
//        try {
//            System.out.print("Enter Name: ");
//            String name = scanner.nextLine();
//            
//            System.out.print("Enter Password: ");
//            String password = scanner.nextLine();
//            
//            System.out.print("Enter Email_ID: ");
//            String email=scanner.nextLine();
//            
//            System.out.print("Enter Role (HR/Admin/Manager/Team Lead/Employee): ");
//            String role = scanner.nextLine();
//            
//            System.out.print("Enter Department: ");
//            String department = scanner.nextLine();
//            
//            String query = "INSERT INTO users (username, password, email, role, department) VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, name);
//            stmt.setString(2, password);
//            stmt.setString(3, email);
//            stmt.setString(4, role);
//            stmt.setString(5, department);
//            stmt.executeUpdate();
//            System.out.println("User Registered Successfully!");
//            System.out.println();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void viewAllUsers() {
//        try {
//            String query = "SELECT * FROM users";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);           
//            while (rs.next()) {
//            	
//            	System.out.println(rs.getInt("id") + " | " +
//                        rs.getString("username") + " | " +
//                        rs.getString("password") + " | " +
//                        rs.getString("email") + " | " +
//                        rs.getString("role") + " | " +
//                        rs.getString("department") + " | ");
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void updateUser() {
//        try {
//            System.out.print("Enter User ID to Update: ");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            boolean keepUpdating = true;
//            do {
//                System.out.println("Choose the field to update:");
//                System.out.println("1. Name");
//                System.out.println("2. Password");
//                System.out.println("3. Role");
//                System.out.println("4. Email");
//                System.out.println("5. Department");
//                System.out.println("6. Exit");
//                System.out.println();
//                System.out.print("Enter your choice: ");
//                System.out.println();
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                String query = "";
//                PreparedStatement stmt;
//
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter New Name: ");
//                        String newName = scanner.nextLine();
//                        query = "UPDATE users SET username = ? WHERE id = ?";
//                        stmt = conn.prepareStatement(query);
//                        stmt.setString(1, newName);
//                        stmt.setInt(2, id);
//                        stmt.executeUpdate();
//                        System.out.println("Name updated successfully!");
//                        System.out.println();
//                        break;
//                        
//                    case 2:
//                        System.out.print("Enter New Password: ");
//                        String newPassword = scanner.nextLine();
//                        query = "UPDATE users SET password = ? WHERE id = ?";
//                        stmt = conn.prepareStatement(query);
//                        stmt.setString(1, newPassword);
//                        stmt.setInt(2, id);
//                        stmt.executeUpdate();
//                        System.out.println("Password updated successfully!");
//                        System.out.println();
//
//                        break;
//
//                    case 3:
//                        System.out.print("Enter New Role (HR/Admin/Manager/Team Lead/Employee): ");
//                        String newRole = scanner.nextLine();
//                        query = "UPDATE users SET role = ? WHERE id = ?";
//                        stmt = conn.prepareStatement(query);
//                        stmt.setString(1, newRole);
//                        stmt.setInt(2, id);
//                        stmt.executeUpdate();
//                        System.out.println("Role updated successfully!");
//                        System.out.println();
//
//                        
//                        break;
//                        
//                    case 4:
//                    	System.out.print("Enter New Email_ID: ");
//                    	String newEmail_ID = scanner.nextLine();
//                    	query = "UPDATE users SET department = ? WHERE id = ?";
//                    	stmt = conn.prepareStatement(query);
//                    	stmt.setString(1, newEmail_ID);
//                    	stmt.setInt(2, id);
//                    	stmt.executeUpdate();
//                    	System.out.println("Email updated successfully!");
//                        System.out.println();
//
//                    	break;
//                    	
//                    case 5:
//                    	
//                    	System.out.print("Enter New Department: ");
//                    	String newDepartment = scanner.nextLine();
//                    	query = "UPDATE users SET department = ? WHERE id = ?";
//                    	stmt = conn.prepareStatement(query);
//                    	stmt.setString(1, newDepartment);
//                    	stmt.setInt(2, id);
//                    	stmt.executeUpdate();
//                    	System.out.println("Department updated successfully!");
//                        System.out.println();
//
//                    	break;
//                    	                    	
//                    case 6:
//                        keepUpdating = false;
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Try again.");
//                        System.out.println();
//
//                }
//
//            } while (keepUpdating);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void deleteUser() {
//        try {
//            System.out.print("Enter User ID to Delete: ");
//            int id = scanner.nextInt();
//            
//            String query = "DELETE FROM users WHERE id = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//            System.out.println("User Deleted Successfully!");
//            System.out.println();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//        
//    public static void employeeMenu(User user) {
//        try {
//            int choice;
//            do {
//                System.out.println("\n===========================EMPLOYEE MANAGEMENT OPERATIONS==========================");
//                System.out.println("1. Add Employee");
//                System.out.println("2. View All Employees");
//                System.out.println("3. Find Employees");
//                System.out.println("4. Sort Employees");
//                System.out.println("5. Find Employee by Salary");
//                System.out.println("6. Get Employees by Status");
//                System.out.println("7. Count Total Employees");
//                System.out.println("8. Update Employee");
//                System.out.println("9. Delete Employee");
//                System.out.println("10. Logout");
//                System.out.println();
//                System.out.print("Enter your choice: ");
//                System.out.println();
//                
//                choice = scanner.nextInt();
//                scanner.nextLine(); // Consume newline
//
//                switch (choice) {
//                    case 1:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin")) {
//                            addEmployee();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to add an employee.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 2:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            viewAllEmployees();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to view all employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 3:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            findEmployee();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to search employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 4:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            sortEmployees();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to sort employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 5:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            findEmployeeBySalary();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to find employees by salary.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 6:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            getEmployeesByStatus();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to get employee status.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 7:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            countTotalEmployees();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to count employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 8:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin")) {
//                            updateEmployee(); // HR/Admin can update anyone
//                        } else if (user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
//                            System.out.print("Enter Employee ID to update: ");
//                            int empId = scanner.nextInt();
//                            scanner.nextLine();
//                            updateEmployeeByManager(user, empId); // Implement this method to allow only updating team members
//                        } else if (user.getRole().equalsIgnoreCase("Employee")) {
//                            System.out.println("You can only update your own data.");
//                            updateOwnDetails(user.getEmail()); // Implement this method for employees to update their own info
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to update employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 9:
//                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin")) {
//                            deleteEmployee();
//                        } else {
//                            System.out.println("Access Denied: You do not have permission to delete employees.");
//                            System.out.println();
//
//                        }
//                        break;
//
//                    case 10:
//                        System.out.println("Logging out... Returning to main menu.");
//                        System.out.println();
//
//                        break; 
//
//                    default:
//                        System.out.println("Invalid choice. Try again.");
//                        System.out.println();
//
//                }
//            } while (choice != 10); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void addEmployee() {
//        try {
//            System.out.print("Enter Name: ");
//            String name = scanner.nextLine();
//            System.out.print("Enter Email: ");
//            String email = scanner.nextLine();
//            System.out.print("Enter Phone: ");
//            String phone = scanner.nextLine();
//            System.out.print("Enter Department: ");
//            String department = scanner.nextLine();
//            System.out.print("Enter Designation: ");
//            String designation = scanner.nextLine();
//            System.out.print("Enter Salary: ");
//            double salary = scanner.nextDouble();
//            scanner.nextLine(); 
//            System.out.print("Enter Joining Date (YYYY-MM-DD): ");
//            String joining_date = scanner.nextLine();
//            System.out.print("Enter Address: ");
//            String address = scanner.nextLine();
//            System.out.print("Enter Status (active/inactive/resigned/terminated): ");
//            String status = scanner.nextLine();
//            
//            scanner.nextLine();
//            
//            String query = "INSERT INTO employees (name, email, phone, department, designation, salary, joining_date, address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";            
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, name);
//            stmt.setString(2, email);
//            stmt.setString(3, phone);
//            stmt.setString(4, department);
//            stmt.setString(5, designation);
//            stmt.setDouble(6, salary);
//            stmt.setString(7, joining_date);
//            stmt.setString(8, address);
//            stmt.setString(9, status);
//            
//            int rowsInserted = stmt.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Employee added successfully!");
//                System.out.println();
//
//            } else {
//                System.out.println("Failed to add employee.");
//                System.out.println();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void viewAllEmployees() {
//        try {
//            String query = "SELECT * FROM employees";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println(" ID  | Name          | Email             | Phone       | Department    | Designation  | Salary    | Joining Date | Address      | Status  | ");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
//            
//            while (rs.next()) {
//                System.out.println(
//                    rs.getInt("id") + " | " +
//                    rs.getString("name") + " | " +
//                    rs.getString("email") + " | " +
//                    rs.getString("phone") + " | " +
//                    rs.getString("department") + " | " +
//                    rs.getString("designation") + " | " +
//                    rs.getDouble("salary") + " | " +
//                    rs.getString("joining_date") + " | " +
//                    rs.getString("address") + " | " +
//                    rs.getString("status") + " | " 
//                );
//            }
//            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void findEmployee() {
//        System.out.println("Find Employee By:");
//        System.out.println("1. ID");
//        System.out.println("2. Name");
//        System.out.println("3. Department");
//        System.out.println("4. Designation");
//        System.out.println("5. Joining Date");
//        System.out.println("6. Salary Range");
//        System.out.println();
//
//        System.out.print("Enter your choice: ");
//        System.out.println();
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            String query = "";
//            PreparedStatement stmt = null;
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter Employee ID: ");
//                    int id = scanner.nextInt();
//                    query = "SELECT * FROM employees WHERE id = ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setInt(1, id);
//                    break;
//                case 2:
//                    System.out.print("Enter Employee Name: ");
//                    String name = scanner.nextLine();
//                    query = "SELECT * FROM employees WHERE name = ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, name);
//                    break;
//                case 3:
//                    System.out.print("Enter Department: ");
//                    String department = scanner.nextLine();
//                    query = "SELECT * FROM employees WHERE department = ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, department);
//                    break;
//                case 4:
//                    System.out.print("Enter Designation: ");
//                    String designation = scanner.nextLine();
//                    query = "SELECT * FROM employees WHERE designation = ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, designation);
//                    break;
//                case 5:
//                    System.out.print("Enter Joining Date (YYYY-MM-DD): ");
//                    String date = scanner.nextLine();
//                    query = "SELECT * FROM employees WHERE joining_date = ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, date);
//                    break;
//                case 6:
//                    System.out.print("Enter Minimum Salary: ");
//                    double minSalary = scanner.nextDouble();
//                    System.out.print("Enter Maximum Salary: ");
//                    double maxSalary = scanner.nextDouble();
//                    query = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setDouble(1, minSalary);
//                    stmt.setDouble(2, maxSalary);
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//                    return;
//            }
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//            	 System.out.println("Employee Details:");
//                 System.out.println("ID: " + rs.getInt("id"));
//                 System.out.println("Name: " + rs.getString("name"));
//                 System.out.println("Email: " + rs.getString("email"));
//                 System.out.println("Phone: " + rs.getString("phone"));
//                 System.out.println("Department: " + rs.getString("department"));
//                 System.out.println("Designation: " + rs.getString("designation"));
//                 System.out.println("Salary: " + rs.getDouble("salary"));
//                 System.out.println("Joining Date: " + rs.getDate("joining_date"));
//                 System.out.println("Address: " + rs.getString("address"));
//                 System.out.println("Status: " + rs.getString("status"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void sortEmployees() {
//        System.out.println("Sort Employees By:");
//        System.out.println("1. Name");
//        System.out.println("2. Salary");
//        System.out.println();
//
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            String query = "";
//            switch (choice) {
//                case 1:
//                    query = "SELECT * FROM employees ORDER BY name ASC";
//                    break;
//                case 2:
//                    query = "SELECT * FROM employees ORDER BY salary DESC";
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//                    return;
//            }
//            
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                System.out.println( rs.getInt("id") + " | " +
//                        rs.getString("name") + " | " +
//                        rs.getString("email") + " | " +
//                        rs.getString("phone") + " | " +
//                        rs.getString("department") + " | " +
//                        rs.getString("designation") + " | " +
//                        rs.getDouble("salary") + " | " +
//                        rs.getString("joining_date") + " | " +
//                        rs.getString("address") + " | " +
//                        rs.getString("status") + " | " );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void findEmployeeBySalary() {
//        System.out.println("Find Employee by Salary:");
//        System.out.println("1. Highest Salary");
//        System.out.println("2. Lowest Salary");
//        System.out.println();
//
//        System.out.print("Enter your choice: ");
//        System.out.println();
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            String query = "";
//            switch (choice) {
//                case 1:
//                    query = "SELECT * FROM employees ORDER BY salary DESC LIMIT 1";
//                    break;
//                case 2:
//                    query = "SELECT * FROM employees ORDER BY salary ASC LIMIT 1";
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//                    return;
//            }
//            
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//            	 System.out.println("Employee Details:");
//                 System.out.println("ID: " + rs.getInt("id"));
//                 System.out.println("Name: " + rs.getString("name"));
//                 System.out.println("Email: " + rs.getString("email"));
//                 System.out.println("Phone: " + rs.getString("phone"));
//                 System.out.println("Department: " + rs.getString("department"));
//                 System.out.println("Designation: " + rs.getString("designation"));
//                 System.out.println("Salary: " + rs.getDouble("salary"));
//                 System.out.println("Joining Date: " + rs.getDate("joining_date"));
//                 System.out.println("Address: " + rs.getString("address"));
//                 System.out.println("Status: " + rs.getString("status"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    
//    public static void getEmployeesByStatus() {
//    	
//        System.out.println("\nFilter Employees by Status:");
//        System.out.println("1. Active Employees");
//        System.out.println("2. Inactive Employees");
//        System.out.println("3. Terminated Employees");
//        System.out.println("4. Resigned Employees");
//        System.out.println("5. All Employees");
//        System.out.println();
//
//        System.out.print("Enter your choice: ");
//        System.out.println();
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        String query = "";
//        String status = "";
//
//        switch (choice) {
//            case 1:
//                query = "SELECT * FROM employees WHERE status = ?";
//                status = "Active";
//                break;
//            case 2:
//                query = "SELECT * FROM employees WHERE status = ?";
//                status = "Inactive";
//                break;
//            case 3:
//                query = "SELECT * FROM employees WHERE status = ?";
//                status = "Terminated";
//                break;
//            case 4:
//                query = "SELECT * FROM employees WHERE status = ?";
//                status = "Resigned";
//                break;
//            case 5:
//                query = "SELECT * FROM employees"; // Fetch all employees
//                break;
//            default:
//                System.out.println("Invalid choice.");
//                System.out.println();
//                return;
//        }
//
//        try {
//            PreparedStatement stmt = conn.prepareStatement(query);
//            
//            if (choice != 5) { 
//                stmt.setString(1, status);
//            }
//            
//            ResultSet rs = stmt.executeQuery();
//
//            boolean hasRecords = false;
//
//            while (rs.next()) {
//                hasRecords = true;
//                System.out.println("Employee Details:");
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println("Name: " + rs.getString("name"));
//                System.out.println("Email: " + rs.getString("email"));
//                System.out.println("Phone: " + rs.getString("phone"));
//                System.out.println("Department: " + rs.getString("department"));
//                System.out.println("Designation: " + rs.getString("designation"));
//                System.out.println("Salary: " + rs.getDouble("salary"));
//                System.out.println("Joining Date: " + rs.getDate("joining_date"));
//                System.out.println("Address: " + rs.getString("address"));
//                System.out.println("Status: " + rs.getString("status"));
//            }
//
//            if (!hasRecords) {
//                if (choice == 5) {
//                    System.out.println("There are no employees in the database.");
//                } else {
//                    System.out.println("There are no " + status + " employees.");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    public static void countTotalEmployees() {
//        try {
//            String query = "SELECT COUNT(*) FROM employees";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int totalEmployees = rs.getInt(1);
//                System.out.println("Total Employees: " + totalEmployees);
//            } else {
//                System.out.println("Could not retrieve employee count.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void updateEmployee() {
//        System.out.print("Enter Employee ID to update: ");
//        int empId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        System.out.println("\nSelect the field you want to update:");
//        System.out.println("1. Name");
//        System.out.println("2. Email");
//        System.out.println("3. Phone");
//        System.out.println("4. Department");
//        System.out.println("5. Designation");
//        System.out.println("6. Salary");
//        System.out.println("7. Joining Date");
//        System.out.println("8. Address");
//        System.out.println("9. Status");
//        System.out.println("10. Update All Fields");
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); 
//
//        String query = "";
//        try {
//            PreparedStatement stmt;
//            
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter new Name: ");
//                    String newName = scanner.nextLine();
//                    query = "UPDATE employees SET name=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newName);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Name updated successfully!");
//                    System.out.println();
//
//                    
//                    break;
//                case 2:
//                    System.out.print("Enter new Email: ");
//                    String newEmail = scanner.nextLine();
//                    query = "UPDATE employees SET email=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newEmail);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Email updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 3:
//                    System.out.print("Enter new Phone: ");
//                    String newPhone = scanner.nextLine();
//                    query = "UPDATE employees SET phone=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newPhone);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Phone No. updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 4:
//                    System.out.print("Enter new Department: ");
//                    String newDept = scanner.nextLine();
//                    query = "UPDATE employees SET department=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newDept);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Department updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 5:
//                    System.out.print("Enter new Designation: ");
//                    String newDesignation = scanner.nextLine();
//                    query = "UPDATE employees SET designation=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newDesignation);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Designation updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 6:
//                    System.out.print("Enter new Salary: ");
//                    double newSalary = scanner.nextDouble();
//                    scanner.nextLine(); // Consume newline
//                    query = "UPDATE employees SET salary=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setDouble(1, newSalary);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Salery updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 7:
//                    System.out.print("Enter new Joining Date (YYYY-MM-DD): ");
//                    String newJoiningDate = scanner.nextLine();
//                    query = "UPDATE employees SET joining_date=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newJoiningDate);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Joining Date updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 8:
//                    System.out.print("Enter new Address: ");
//                    String newAddress = scanner.nextLine();
//                    query = "UPDATE employees SET address=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newAddress);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Address updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 9:
//                    System.out.print("Enter new Status (Active/Inactive/Terminated/Resigned): ");
//                    String newStatus = scanner.nextLine();
//                    query = "UPDATE employees SET status=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newStatus);
//                    stmt.setInt(2, empId);
//                    stmt.executeUpdate();
//                    System.out.println("Status updated successfully!");
//                    System.out.println();
//
//                    break;
//                case 10:
//                    System.out.print("Enter new Name: ");
//                    newName = scanner.nextLine();
//                    System.out.print("Enter new Email: ");
//                    newEmail = scanner.nextLine();
//                    System.out.print("Enter new Phone: ");
//                    newPhone = scanner.nextLine();
//                    System.out.print("Enter new Department: ");
//                    newDept = scanner.nextLine();
//                    System.out.print("Enter new Designation: ");
//                    newDesignation = scanner.nextLine();
//                    System.out.print("Enter new Salary: ");
//                    newSalary = scanner.nextDouble();
//                    scanner.nextLine(); 
//                    System.out.print("Enter new Joining Date (YYYY-MM-DD): ");
//                    newJoiningDate = scanner.nextLine();
//                    System.out.print("Enter new Address: ");
//                    newAddress = scanner.nextLine();
//                    System.out.print("Enter new Status (Active/Inactive/Terminated/Resigned): ");
//                    newStatus = scanner.nextLine();
//
//                    query = "UPDATE employees SET name=?, email=?, phone=?, department=?, designation=?, salary=?, joining_date=?, address=?, status=? WHERE id=?";
//                    stmt = conn.prepareStatement(query);
//                    stmt.setString(1, newName);
//                    stmt.setString(2, newEmail);
//                    stmt.setString(3, newPhone);
//                    stmt.setString(4, newDept);
//                    stmt.setString(5, newDesignation);
//                    stmt.setDouble(6, newSalary);
//                    stmt.setString(7, newJoiningDate);
//                    stmt.setString(8, newAddress);
//                    stmt.setString(9, newStatus);
//                    stmt.setInt(10, empId);
//                    System.out.println("Employee details updated successfully.");   
//                    System.out.println();
//
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//                    return;
//            }
//
//            int rowsUpdated = stmt.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("--------------------------------------------------------------");
//            } else {
//                System.out.println("Employee ID not found.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    
//    
//    public static void updateEmployeeByManager(User user, int empId) {
//        try {
//            String checkQuery = "SELECT id FROM employees WHERE id = ? AND department = ?";
//            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
//            checkStmt.setInt(1, empId);
//            checkStmt.setString(2, user.getDepartment()); 
//            ResultSet rs = checkStmt.executeQuery();
//
//            if (!rs.next()) { 
//                System.out.println("Access Denied: You can only update employees in your department.");
//                return;
//            }
//
//            System.out.println("What would you like to update?");
//            System.out.println("1. Phone");
//            if (user.getRole().equalsIgnoreCase("Manager")) {
//                System.out.println("2. Designation");
//            }
//            System.out.println("3. Address");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); 
//
//            String updateQuery = "";
//            PreparedStatement updateStmt = null;
//
//            switch (choice) {
//                case 1: 
//                    System.out.print("Enter new phone number: ");
//                    String phone = scanner.nextLine();
//                    updateQuery = "UPDATE employees SET phone = ? WHERE id = ?";
//                    updateStmt = conn.prepareStatement(updateQuery);
//                    updateStmt.setString(1, phone);
//                    updateStmt.setInt(2, empId);
//                    break;
//
//                case 2: 
//                    if (user.getRole().equalsIgnoreCase("Manager")) {
//                        System.out.print("Enter new designation: ");
//                        String designation = scanner.nextLine();
//                        updateQuery = "UPDATE employees SET designation = ? WHERE id = ?";
//                        updateStmt = conn.prepareStatement(updateQuery);
//                        updateStmt.setString(1, designation);
//                        updateStmt.setInt(2, empId);
//                    } else {
//                        System.out.println("Access Denied: Only Managers can update designation.");
//                        return;
//                    }
//                    break;
//
//                case 3: 
//                    System.out.print("Enter new address: ");
//                    String address = scanner.nextLine();
//                    updateQuery = "UPDATE employees SET address = ? WHERE id = ?";
//                    updateStmt = conn.prepareStatement(updateQuery);
//                    updateStmt.setString(1, address);
//                    updateStmt.setInt(2, empId);
//                    break;
//
//                default:
//                    System.out.println("Invalid option.");
//                    return;
//            }
//
//            int rowsUpdated = updateStmt.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Employee details updated successfully.");
//                System.out.println();
//
//            } else {
//                System.out.println("Error updating employee details.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void updateOwnDetails(String userEmail) {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            String checkQuery = "SELECT id FROM employees WHERE email = ?";
//            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
//            checkStmt.setString(1, userEmail);
//            ResultSet rs = checkStmt.executeQuery();
//
//            if (!rs.next()) {
//                System.out.println("Error: No employee found with this email.");
//                return;
//            }
//
//            int empId = rs.getInt("id"); 
//
//            System.out.println("What do you want to update?");
//            System.out.println("1. Phone Number");
//            System.out.println("2. Address");
//            System.out.println("3. Both");
//            System.out.println();
//
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); 
//
//            String updateQuery = "";
//            PreparedStatement pstmt = null;
//
//            if (choice == 1) {
//                System.out.print("Enter new phone number: ");
//                String newPhone = scanner.nextLine();
//                updateQuery = "UPDATE employees SET phone = ? WHERE email = ?";
//                pstmt = conn.prepareStatement(updateQuery);
//                pstmt.setString(1, newPhone);
//                pstmt.setString(2, userEmail);
//            } else if (choice == 2) {
//                System.out.print("Enter new address: ");
//                String newAddress = scanner.nextLine();
//                updateQuery = "UPDATE employees SET address = ? WHERE email = ?";
//                pstmt = conn.prepareStatement(updateQuery);
//                pstmt.setString(1, newAddress);
//                pstmt.setString(2, userEmail);
//            } else if (choice == 3) {
//                System.out.print("Enter new phone number: ");
//                String newPhone = scanner.nextLine();
//                System.out.print("Enter new address: ");
//                String newAddress = scanner.nextLine();
//                updateQuery = "UPDATE employees SET phone = ?, address = ? WHERE email = ?";
//                pstmt = conn.prepareStatement(updateQuery);
//                pstmt.setString(1, newPhone);
//                pstmt.setString(2, newAddress);
//                pstmt.setString(3, userEmail);
//            } else {
//                System.out.println("Invalid choice. No updates made.");
//                return;
//            }
//
//            int updated = pstmt.executeUpdate();
//            if (updated > 0) {
//                System.out.println("Details updated successfully!");
//                System.out.println();
//
//            } else {
//                System.out.println("Failed to update details. Please try again.");
//                return;
//            }
//
//            System.out.print("Do you want to see your updated information? (yes/no): ");
//            String response = scanner.nextLine();
//            if (response.equalsIgnoreCase("yes")) {
//                showEmployeeDetails(empId);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void showEmployeeDetails(int empId) {
//        try {
//            String selectQuery = "SELECT * FROM employees WHERE id = ?";
//            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
//            pstmt.setInt(1, empId);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                System.out.println("Employee Details:");
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println("Name: " + rs.getString("name"));
//                System.out.println("Email: " + rs.getString("email"));
//                System.out.println("Phone: " + rs.getString("phone"));
//                System.out.println("Department: " + rs.getString("department"));
//                System.out.println("Designation: " + rs.getString("designation"));
//                System.out.println("Salary: " + rs.getDouble("salary"));
//                System.out.println("Joining Date: " + rs.getDate("joining_date"));
//                System.out.println("Address: " + rs.getString("address"));
//                System.out.println("Status: " + rs.getString("status"));
//            } else {
//                System.out.println("Employee not found.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//  
//    public static void deleteEmployee() {
//        System.out.print("Enter Employee ID to delete: ");
//        int empId = scanner.nextInt();
//        scanner.nextLine(); 
//
//        try {
//            String checkQuery = "SELECT * FROM employees WHERE id = ?";
//            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
//            checkStmt.setInt(1, empId);
//            ResultSet rs = checkStmt.executeQuery();
//
//            if (!rs.next()) {
//                System.out.println("Employee ID not found.");
//                return;
//            }
//
//            System.out.print("Are you sure you want to delete this employee? (yes/no): ");
//            String confirmation = scanner.nextLine();
//            if (!confirmation.equalsIgnoreCase("yes")) {
//                System.out.println("Deletion canceled.");
//                return;
//            }
//
//            String deleteQuery = "DELETE FROM employees WHERE id = ?";
//            PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
//            deleteStmt.setInt(1, empId);
//
//            int rowsDeleted = deleteStmt.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("Employee deleted successfully.");
//            } else {
//                System.out.println("Failed to delete employee.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
