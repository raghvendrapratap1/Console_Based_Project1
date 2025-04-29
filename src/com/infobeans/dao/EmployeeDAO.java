package com.infobeans.dao;
import com.infobeans.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmployeeDAO {
	
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String USER = "root";
    private static final String PASSWORD = "raghvendra";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (name, email, phone, department, designation, salary, joining_date, address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getEmail());
        stmt.setString(3, employee.getPhone());
        stmt.setString(4, employee.getDepartment());
        stmt.setString(5, employee.getDesignation());
        stmt.setDouble(6, employee.getSalary());
        stmt.setString(7, employee.getJoiningDate());
        stmt.setString(8, employee.getAddress());
        stmt.setString(9, employee.getStatus());
        stmt.executeUpdate();
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            employees.add(new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                rs.getString("joining_date"),
                rs.getString("address"),
                rs.getString("status")
            ));
        }
        return employees;
    }

    public List<Employee> getEmployeeById(int id) throws SQLException {
    	 List<Employee> employees = new ArrayList<>();
    	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(id)) = LOWER(TRIM(?))";
        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        
        return employees; // Return null if no employee is found
    }
    
    
    public List<Employee> getEmployeesByName(String name) throws SQLException {
    	List<Employee> employees = new ArrayList<>();
   	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(name)) = LOWER(TRIM(?))";
        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    
    public List<Employee> getEmployeesByDepartment(String department) throws SQLException {
    	List<Employee> employees = new ArrayList<>();
   	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(department)) = LOWER(TRIM(?))";

        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, department);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    
    public List<Employee> getEmployeesByDesignation(String designation) throws SQLException {
    	List<Employee> employees = new ArrayList<>();
   	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(designation)) = LOWER(TRIM(?))";
        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, designation);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    
    
    public List<Employee> getEmployeesSortedByName() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees ORDER BY name ASC";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            employees.add(new Employee(
            		 rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }

    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, minSalary);
        ps.setDouble(2, maxSalary);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            employees.add(new Employee(
            		 rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }

    public List<Employee> getEmployeesSortedBySalary() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees ORDER BY salary";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	 employees.add(new Employee(
        			 rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    
    public List<Employee> getEmployeesSortedByJoiningDate() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees ORDER BY joining_date";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	 employees.add(new Employee(
        			 rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    public List<Employee> getEmployeesByJoiningDate(String joiningDate) throws SQLException {
    	List<Employee> employees = new ArrayList<>();
   	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(joining_date)) = LOWER(TRIM(?))";
        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, joiningDate);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }

    public List<Employee> getHighestPaidEmployee() throws SQLException {
    	List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM employees ORDER BY salary DESC LIMIT 1";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }

    public List<Employee> getLowestPaidEmployee() throws SQLException {
    	List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM employees ORDER BY salary ASC LIMIT 1";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }


    public List<Employee> findEmployeeByExactSalary(double salary) throws SQLException {
    	List<Employee> employees = new ArrayList<>();
   	 
        String query = "SELECT * FROM employees WHERE LOWER(TRIM(salary)) = LOWER(TRIM(?))";
        Connection conn = getConnection();  // Ensure this method exists
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setDouble(1, salary);
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	employees.add(new Employee(
        			rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("email"),
                     rs.getString("phone"),
                     rs.getString("department"),
                     rs.getString("designation"),
                     rs.getDouble("salary"),
                     rs.getString("joining_date"),
                     rs.getString("address"),
                     rs.getString("status")
            ));
        }
        return employees;
    }
    
    
    public int getTotalEmployeeCount() throws SQLException {
        String query = "SELECT COUNT(*) FROM employees";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int count = 0;
        while (rs.next()) { 
            count = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        conn.close();

        return count;
    }

    
    public List<Employee> getActiveEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE status = 'Active'";
        
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Employee employee = new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                rs.getString("joining_date"),
                rs.getString("address"),
                rs.getString("status")
            );
            employees.add(employee);
        }
        
        return employees;
    }

    public List<Employee> getInactiveEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE status = 'Inactive'";
        
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Employee employee = new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                rs.getString("joining_date"),
                rs.getString("address"),
                rs.getString("status")
            );
            employees.add(employee);
        }
        
        return employees;
    }

    public List<Employee> getResignedEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE status = 'Resigned'";
        
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Employee employee = new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                rs.getString("joining_date"),
                rs.getString("address"),
                rs.getString("status")
            );
            employees.add(employee);
        }
        
        return employees;
    }
    
    public List<Employee> getTerminatedEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE status = 'Terminated'";
        
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Employee employee = new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                rs.getString("joining_date"),
                rs.getString("address"),
                rs.getString("status")
            );
            employees.add(employee);
        }
        
        return employees;
    } 

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    
 

    public boolean updateEmployee(int empId, String field, double newValue) throws SQLException{
        String query = "UPDATE employees SET " + field + " = ? WHERE id = ?";
         
        	 Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             
            pstmt.setDouble(1, newValue);
            pstmt.setInt(2, empId);

            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0) {
            	
            }else {
            	
            }
       
            return false;
        }
    

    public boolean updateEmployeeAllFields(int empId, Employee emp) throws SQLException {
        String query = "UPDATE employees SET name = ?, email = ?, phone = ?, department = ?, designation = ?, salary = ?, joining_date = ?, address = ?, status = ? WHERE id = ?";
        
        	
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
             
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getEmail());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getDepartment());
            pstmt.setString(5, emp.getDesignation());
            pstmt.setDouble(6, emp.getSalary());
            pstmt.setString(7, emp.getJoiningDate());
            pstmt.setString(8, emp.getAddress());
            pstmt.setString(9, emp.getStatus());
            pstmt.setInt(10, empId);

            int rowsAffected = pstmt.executeUpdate();
            if( rowsAffected > 0) {
            	
            }else {
            	
            }
        
            return false;
    }

    public boolean isEmployeeInSameDepartment(int empId, String userDept) throws Exception {
        String query = "SELECT department FROM employees WHERE id = ?";
        
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, empId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String empDept = rs.getString("department");
                return empDept.equalsIgnoreCase(userDept); // ✅ Compare
            } else {
                throw new Exception("Employee not found.");
            }   
    }
    
    
    public boolean updateEmployeeField(int empId, String field, String newValue) throws Exception {
        // ✅ Allow only safe fields to be updated
        List<String> allowedFields = Arrays.asList("phone", "address", "designation");

        if (!allowedFields.contains(field.toLowerCase())) {
            throw new Exception("Field not allowed to update.");
        }

        String query = "UPDATE employees SET " + field + " = ? WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        

            pstmt.setString(1, newValue);
            pstmt.setInt(2, empId);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
    }	
    
    public boolean updateEmployeeByEmail(String email, String field, String newValue) throws Exception {
    	
        String query = "UPDATE employees SET " + field + " = ? WHERE email = ?";
        
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, newValue);
        pstmt.setString(2, email);

        int rowsAffected = pstmt.executeUpdate();

        return rowsAffected > 0;
    }

	public boolean updateEmployee(int empId, String field, String newValue) throws SQLException {
		String query = "UPDATE employees SET " + field + " = ? WHERE id = ?";
        
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newValue);
            pstmt.setInt(2, empId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
            	
            }
            else {
            	
            }
            return false;
	}
	
	
	public Employee getEmployeeByEmail(String email) throws Exception {
	    String query = "SELECT * FROM employees WHERE email = ?";
	    Connection conn =getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, email);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return new Employee(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getString("phone"),
	                rs.getString("department"),
	                rs.getString("designation"),
	                rs.getDouble("salary"),
	                rs.getString("joining_date"),
	                rs.getString("address"),
	                rs.getString("status")
	            );
	        }
	    return null;
	}
}


