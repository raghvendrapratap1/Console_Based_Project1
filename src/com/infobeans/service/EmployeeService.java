package com.infobeans.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.infobeans.dao.EmployeeDAO;
import com.infobeans.model.Employee;
import com.infobeans.model.User;

public class EmployeeService {

    private EmployeeDAO employeeDao;

    // Constructor
    public EmployeeService() {
        this.employeeDao = new EmployeeDAO();
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDao.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployees();
    }

    public List<Employee> getEmployeeById(int id) throws SQLException {
        return employeeDao.getEmployeeById(id); // Calls DAO method
    }

    public List<Employee> getEmployeesByName(String name) throws SQLException {
        return employeeDao.getEmployeesByName(name);
    }

    public List<Employee> getEmployeesByDepartment(String department) throws SQLException {
        return employeeDao.getEmployeesByDepartment(department);
    }

    public List<Employee> getEmployeesByDesignation(String designation) throws SQLException {
        return employeeDao.getEmployeesByDesignation(designation);
    }

    
    
    
    public List<Employee> getEmployeesSortedByName() throws SQLException {
        List<Employee> employees = employeeDao.getAllEmployees();
        employees.sort(Comparator.comparing(Employee::getName));
        return employees;
    }
    
    

    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) throws SQLException {
        return employeeDao.getEmployeesBySalaryRange(minSalary, maxSalary);
    }

    public List<Employee> getEmployeesSortedBySalary() throws SQLException {
        List<Employee> employees = employeeDao.getAllEmployees();
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        return employees;
    }
    
    public List<Employee> getEmployeesSortedByJoiningDate() throws SQLException {
        List<Employee> employees = employeeDao.getAllEmployees();
        employees.sort(Comparator.comparing(Employee::getJoiningDate)); // ✅ Sorts by joining date
        return employees;
    }


    public List<Employee> getEmployeesByJoiningDate(String joiningDate) throws SQLException {
        return employeeDao.getEmployeesByJoiningDate(joiningDate);
    }

    public int getTotalEmployeeCount() throws SQLException {
        return employeeDao.getTotalEmployeeCount();
    }

    public List<Employee> getHighestPaidEmployee() throws SQLException {
        return employeeDao.getHighestPaidEmployee();
    }

    public List<Employee> getLowestPaidEmployee() throws SQLException {
        return employeeDao.getLowestPaidEmployee();
    }

    public List<Employee> findBySalary(double salary) throws SQLException {
        return employeeDao.findEmployeeByExactSalary(salary);
    }

    public boolean updateEmployee(int empId, String field, double newValue) throws SQLException {
        return employeeDao.updateEmployee(empId, field, newValue);
    }

    public boolean updateEmployeeAllFields(int empId, Employee emp) throws SQLException {
        return employeeDao.updateEmployeeAllFields(empId, emp);
    }

    
    public void deleteEmployee(int id) throws SQLException {
        employeeDao.deleteEmployee(id);
    }
 
    public List<Employee> getActiveEmployees() throws SQLException {
        return employeeDao.getActiveEmployees();
    }

    public List<Employee> getInactiveEmployees() throws SQLException {
        return employeeDao.getInactiveEmployees();
    }

    public List<Employee> getResignedEmployees() throws SQLException {
        return employeeDao.getResignedEmployees();
    }

    public List<Employee> getTerminatedEmployees() throws SQLException {
        return employeeDao.getTerminatedEmployees();
    }

    public boolean updateEmployeeByDepartment(User user, int empId, String field, String newValue) throws Exception {
        boolean isSameDept = employeeDao.isEmployeeInSameDepartment(empId, user.getDepartment());

        if (!isSameDept) {
            throw new Exception("Access denied. You can only update employees from your department.");
        }

        return employeeDao.updateEmployeeField(empId, field, newValue);
    }

  

	public boolean updateOwnData(String email, String field, String newValue) throws Exception {
		 List<String> allowedFields = Arrays.asList("name", "phone", "email");

	        if (!allowedFields.contains(field.toLowerCase())) {
	            throw new Exception("Access denied. You can only update name, phone, or email.");
	        }

	        return employeeDao.updateEmployeeByEmail(email, field, newValue);
	}

	public boolean updateEmployee(int empId, String field, String newValue) throws SQLException{
		return employeeDao.updateEmployee(empId, field, newValue);		
	}

	public Employee getEmployeeByEmail(String email) throws Exception {
	    return employeeDao.getEmployeeByEmail(email);  // returns single employee
	}
}


//package com.infobeans.service;
//
//import java.sql.Date;
//import java.sql.SQLException;
//import java.util.Comparator;
//import java.util.List;
//import com.infobeans.dao.EmployeeDAO;
//import com.infobeans.model.Employee;
//
//public class EmployeeService {
//	
//    private  EmployeeDAO employeeDao;
//
//    public EmployeeService() {
//        this.employeeDao =new EmployeeDAO();
//    }
//
//    public void addEmployee(Employee employee) throws SQLException {
//        employeeDao.addEmployee(employee);
//    }
//
//    public List<Employee> getAllEmployees() throws SQLException {
//        return employeeDao.getAllEmployees();
//    }
//
//    public Employee getEmployeeById(int id) throws SQLException {
//        return employeeDao.getEmployeeById(id); // Calls DAO method
//    }
//
//    
//    public List<Employee> getEmployeesByName(String name) throws SQLException {
//    	return employeeDao.getEmployeesByName(name);
//    }
//
//    public List<Employee> getEmployeesByDepartment(String department) throws SQLException {
//        return employeeDao.getEmployeesByDepartment(department);
//    }
//
//    public List<Employee> getEmployeesByDesignation(String designation) throws SQLException {
//        return employeeDao.getEmployeesByDesignation(designation);
//    }
//    
//    public List<Employee> getEmployeesSortedByName() throws SQLException {
//        List<Employee> employees = employeeDao.getAllEmployees();
//        employees.sort(Comparator.comparing(Employee::getName));
//        return employees;
//    }
//
//    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) throws SQLException {
//        return employeeDao.getEmployeesBySalaryRange(minSalary, maxSalary);
//    }
//
//    public List<Employee> getEmployeesSortedBySalary() throws SQLException {
//        List<Employee> employees = employeeDao.getAllEmployees();
//        employees.sort(Comparator.comparingDouble(Employee::getSalary));
//        return employees;
//    }
//
//    public List<Employee> getEmployeesByJoiningDate(Date joiningDate) throws SQLException {
//        return employeeDao.getEmployeesByJoiningDate(joiningDate);
//    }
//
//    public int getEmployeeCount() throws SQLException {
//        return employeeDao.getTotalEmployeeCount();
//    }
//    
//    public Employee getHighestPaidEmployee() throws SQLException {
//        return employeeDao.getHighestPaidEmployee();
//    }
//    
//    public Employee getLowestPaidEmployee() throws SQLException{
//		// TODO Auto-generated method stub
//		return employeeDao.getLowestPaidEmployee();
//	}
//
//    public void updateEmployee(Employee employee) throws SQLException {
//        employeeDao.updateEmployee(employee);
//    }
//
//    public void deleteEmployee(int id) throws SQLException {
//        employeeDao.deleteEmployee(id);
//    }
//
//	public int getTotalEmployeeCount() throws SQLException {
//		// TODO Auto-generated method stub
//		return employeeDao.getTotalEmployeeCount();
//	}
//}