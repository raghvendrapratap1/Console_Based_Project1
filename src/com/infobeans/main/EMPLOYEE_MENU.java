package com.infobeans.main;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.infobeans.model.Employee;
import com.infobeans.model.User;
import com.infobeans.service.EmployeeService;
import com.infobeans.util.EmployeePrinter;

public class EMPLOYEE_MENU {
	
	 public static void employeeMenu(User user) throws Exception{
		 
		 Scanner scanner = new Scanner(System.in);
		 EmployeeService employeeService=new EmployeeService();
		   
		 System.out.println("\n===========================EMPLOYEE MANAGEMENT OPERATIONS==========================");
		 
	            int choice;
	            do {
	                System.out.println("1. Add Employee");
	                System.out.println("2. View Employees");
	                System.out.println("3. Find Employees ");
	                System.out.println("4. Sort Employees");
	                System.out.println("5. Find Employee's Salary");
	                System.out.println("6. Get Employees by Status");
	                System.out.println("7. Count Total Employees");
	                System.out.println("8. Update Employee");
	                System.out.println("9. Delete Employee");
	                System.out.println("10. Logout");
	                System.out.println();
	                System.out.print("Enter your choice: ");
	                
	                choice = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                System.out.println();

	                switch (choice) {
	                    case 1:
	                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin")) {
	                        	
	                        	System.out.print("Enter Name: ");
	            	            String name = scanner.nextLine();
	            	            System.out.print("Enter Email: ");
	            	            String email = scanner.nextLine();
	            	            System.out.print("Enter Phone: ");
	            	            String phone = scanner.nextLine();
	            	            System.out.print("Enter Department: ");
	            	            String department = scanner.nextLine();
	            	            System.out.print("Enter Designation: ");
	            	            String designation = scanner.nextLine();
	            	            System.out.print("Enter Salary: ");
	            	            double salary = scanner.nextDouble();
	            	            scanner.nextLine(); 
	            	            System.out.print("Enter Joining Date (YYYY-MM-DD): ");
	            	            String joining_date = scanner.nextLine();
	            	            System.out.print("Enter Address: ");
	            	            String address = scanner.nextLine();
	            	            System.out.print("Enter Status (active/inactive/resigned/terminated): ");
	            	            String status = scanner.nextLine();
	            	            scanner.nextLine();
	            	            
	            	            Employee employee=new Employee(0, name, email, phone, department, designation, salary, joining_date, address, status);
	                            employeeService.addEmployee(employee);
	                            
	                            
	                        } else {
	                            System.out.println("Access Denied: You do not have permission to add an employee.");
	                            System.out.println();
	                        }
	                        break;

	                    case 2:
	                        String role = user.getRole();

	                        if (role.equalsIgnoreCase("HR") || 
	                            role.equalsIgnoreCase("Admin") || 
	                            role.equalsIgnoreCase("Manager") || 
	                            role.equalsIgnoreCase("Team Lead")) {
	                            
	                            List<Employee> empList = employeeService.getAllEmployees();
	                            if (empList.isEmpty()) {
	                                System.out.println("No employee records found.");
	                            } else {
	                                System.out.println("\nEmployees List:");
	                                EmployeePrinter.printEmployeeTable(empList);
	                            }
	                            System.out.println();

	                        } else if (role.equalsIgnoreCase("Employee")) {
	                            try {
	                                Employee ownData = employeeService.getEmployeeByEmail(user.getEmail());
	                                if (ownData != null) {
	                                    System.out.println("\nYour Profile:");
	                                    EmployeePrinter.printEmployeeTable(Collections.singletonList(ownData));
	                                } else {
	                                    System.out.println("No employee record found for your account.");
	                                }
	                            } catch (Exception e) {
	                                System.out.println("Error retrieving your profile: " + e.getMessage());
	                            }
	                            System.out.println();

	                        } else {
	                            System.out.println("Access Denied: You do not have permission to view employees.");
	                            System.out.println();
	                        }
	                        break;

	                    case 3:
	                        if (user.getRole().equalsIgnoreCase("HR") ||
	                            user.getRole().equalsIgnoreCase("Admin") ||
	                            user.getRole().equalsIgnoreCase("Manager") ||
	                            user.getRole().equalsIgnoreCase("Team Lead")) {

	                            boolean keepSearching = true;

	                            do {
	                                System.out.println("1. ID");
	                                System.out.println("2. Name");
	                                System.out.println("3. Department");
	                                System.out.println("4. Designation");
	                                System.out.println("5. Joining Date");
	                                System.out.println("6. Salary Range");
	                                System.out.println("7. Back");
	                                System.out.print("Enter your choice: ");

	                                int subChoice = scanner.nextInt();
	                                scanner.nextLine();
	                                System.out.println();

	                                switch (subChoice) {
	                                    case 1:
	                                        System.out.print("Enter ID to find Employees: ");
	                                        int id = scanner.nextInt();
	                                        scanner.nextLine();
	                                        List<Employee> empById = employeeService.getEmployeeById(id);
	                                        if (empById.isEmpty()) {
	                                            System.out.println("No Employees found with this ID.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empById);
	                                        }
	                                        break;

	                                    case 2:
	                                        System.out.print("Enter Name to find Employees: ");
	                                        String name = scanner.nextLine();
	                                        List<Employee> empByName = employeeService.getEmployeesByName(name);
	                                        if (empByName.isEmpty()) {
	                                            System.out.println("No Employees found with this name.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empByName);
	                                        }
	                                        break;

	                                    case 3:
	                                        System.out.print("Enter Department to find Employees: ");
	                                        String department = scanner.nextLine();
	                                        List<Employee> empByDept = employeeService.getEmployeesByDepartment(department);
	                                        if (empByDept.isEmpty()) {
	                                            System.out.println("No Employees found in this department.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empByDept);
	                                        }
	                                        break;

	                                    case 4:
	                                        System.out.print("Enter Designation to find Employees: ");
	                                        String designation = scanner.nextLine();
	                                        List<Employee> empByDesig = employeeService.getEmployeesByDesignation(designation);
	                                        if (empByDesig.isEmpty()) {
	                                            System.out.println("No Employees found with this designation.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empByDesig);
	                                        }
	                                        break;

	                                    case 5:
	                                        System.out.print("Enter Joining Date (YYYY-MM-DD) to find Employees: ");
	                                        String joiningDate = scanner.nextLine();
	                                        List<Employee> empByDate = employeeService.getEmployeesByJoiningDate(joiningDate);
	                                        if (empByDate.isEmpty()) {
	                                            System.out.println("No Employees found with this joining date.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empByDate);
	                                        }
	                                        break;

	                                    case 6:
	                                        System.out.print("Enter Minimum Salary: ");
	                                        double minSalary = scanner.nextDouble();
	                                        System.out.print("Enter Maximum Salary: ");
	                                        double maxSalary = scanner.nextDouble();
	                                        scanner.nextLine();
	                                        List<Employee> empBySalary = employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
	                                        if (empBySalary.isEmpty()) {
	                                            System.out.println("No Employees found within this salary range.");
	                                        } else {
	                                            EmployeePrinter.printEmployeeTable(empBySalary);
	                                        }
	                                        break;

	                                    case 7:
	                                        keepSearching = false;
	                                        break;

	                                    default:
	                                        System.out.println("Invalid choice. Try again.");
	                                        break;
	                                }
	                            } while (keepSearching);

	                        } else {
	                            System.out.println("Access Denied: You do not have permission to search employees.");
	                            System.out.println();
	                        }
	                        break;

	                    case 4:
	                        if (user.getRole().equalsIgnoreCase("HR") || 
	                            user.getRole().equalsIgnoreCase("Admin") || 
	                            user.getRole().equalsIgnoreCase("Manager") || 
	                            user.getRole().equalsIgnoreCase("Team Lead")) {
	                            
	                            boolean keepUpdating2 = true;
	                            do {
	                                System.out.println("1. Name");
	                                System.out.println("2. Salary");
	                                System.out.println("3. Back");
	                                System.out.println();
	                                System.out.print("Enter your choice: ");
	                                int choice2 = scanner.nextInt();
	                                scanner.nextLine();  // consume newline
	                                System.out.println();

	                                switch (choice2) {
	                                    case 1:
	                                        List<Employee> empByName = employeeService.getEmployeesSortedByName();
	                                        System.out.println("Employees sorted by Name:");
	                                        EmployeePrinter.printEmployeeTable(empByName);  // 🟢 Utility method
	                                        System.out.println();
	                                        break;

	                                    case 2:
	                                        List<Employee> empBySalary = employeeService.getEmployeesSortedBySalary();
	                                        System.out.println("Employees sorted by Salary:");
	                                        EmployeePrinter.printEmployeeTable(empBySalary);  // 🟢 Utility method
	                                        System.out.println();
	                                        break;

	                                    case 3:
	                                        keepUpdating2 = false;
	                                        break;

	                                    default:
	                                        System.out.println("Invalid choice. Try again.");
	                                        System.out.println();
	                                }
	                            } while (keepUpdating2);
	                        } else {
	                            System.out.println("Access Denied: You do not have permission to sort employees.");
	                            System.out.println();
	                        }
	                        break;

	                    case 5:
	                        if (user.getRole().equalsIgnoreCase("HR") || 
	                            user.getRole().equalsIgnoreCase("Admin") || 
	                            user.getRole().equalsIgnoreCase("Manager") || 
	                            user.getRole().equalsIgnoreCase("Team Lead")) {

	                            boolean keepChecking = true;

	                            while (keepChecking) {
	                                System.out.println("1. Highest");
	                                System.out.println("2. Lowest");
	                                System.out.println("3. Back");
	                                System.out.println();
	                                System.out.print("Enter your choice: ");
	                                int choice2 = scanner.nextInt();
	                                scanner.nextLine(); // consume newline
	                                System.out.println();

	                                switch (choice2) {
	                                    case 1:
	                                        List<Employee> highestPaid = employeeService.getHighestPaidEmployee();
	                                        System.out.println("Highest Paid Employee(s):");
	                                        EmployeePrinter.printEmployeeTable(highestPaid);  // 🟢 Utility used here
	                                        System.out.println();
	                                        break;

	                                    case 2:
	                                        List<Employee> lowestPaid = employeeService.getLowestPaidEmployee();
	                                        System.out.println("Lowest Paid Employee(s):");
	                                        EmployeePrinter.printEmployeeTable(lowestPaid);  // 🟢 Utility used here
	                                        System.out.println();
	                                        break;

	                                    case 3:
	                                        keepChecking = false;
	                                        continue;

	                                    default:
	                                        System.out.println("Invalid choice. Try again.");
	                                        System.out.println();
	                                        continue;
	                                }

	                                System.out.print("Do you want to check again? (yes/no): ");
	                                String again = scanner.nextLine();
	                                if (!again.equalsIgnoreCase("yes")) {
	                                    keepChecking = false;
	                                }
	                            }

	                        } else {
	                            System.out.println("Access Denied: You do not have permission to find employees by salary.");
	                            System.out.println();
	                        }
	                        break;


	                    case 6:
	                        if (user.getRole().equalsIgnoreCase("HR") || 
	                            user.getRole().equalsIgnoreCase("Admin") || 
	                            user.getRole().equalsIgnoreCase("Manager") || 
	                            user.getRole().equalsIgnoreCase("Team Lead")) {

	                            String repeat;
	                            do {
	                                boolean keepUpdating4 = true;

	                                do {
	                                    System.out.println("1. Active");
	                                    System.out.println("2. Inactive");
	                                    System.out.println("3. Resigned");
	                                    System.out.println("4. Terminated");
	                                    System.out.println("5. Back");
	                                    System.out.println();
	                                    System.out.print("Enter your choice: ");
	                                    int choice2 = scanner.nextInt();
	                                    scanner.nextLine(); // consume newline
	                                    System.out.println();

	                                    switch (choice2) {

	                                        case 1:
	                                            List<Employee> activeList = employeeService.getActiveEmployees();
	                                            if (activeList.isEmpty()) {
	                                                System.out.println("No active employees found.");
	                                            } else {
	                                                System.out.println("Active Employees:");
	                                                EmployeePrinter.printEmployeeTable(activeList);
	                                            }
	                                            break;

	                                        case 2:
	                                            List<Employee> inactiveList = employeeService.getInactiveEmployees();
	                                            if (inactiveList.isEmpty()) {
	                                                System.out.println("No inactive employees found.");
	                                            } else {
	                                                System.out.println("Inactive Employees:");
	                                                EmployeePrinter.printEmployeeTable(inactiveList);
	                                            }
	                                            break;

	                                        case 3:
	                                            List<Employee> resignedList = employeeService.getResignedEmployees();
	                                            if (resignedList.isEmpty()) {
	                                                System.out.println("No resigned employees found.");
	                                            } else {
	                                                System.out.println("Resigned Employees:");
	                                                EmployeePrinter.printEmployeeTable(resignedList);
	                                            }
	                                            break;

	                                        case 4:
	                                            List<Employee> terminatedList = employeeService.getTerminatedEmployees();
	                                            if (terminatedList.isEmpty()) {
	                                                System.out.println("No terminated employees found.");
	                                            } else {
	                                                System.out.println("Terminated Employees:");
	                                                EmployeePrinter.printEmployeeTable(terminatedList);
	                                            }
	                                            break;

	                                        case 5:
	                                            keepUpdating4 = false;
	                                            break;

	                                        default:
	                                            System.out.println("Invalid choice. Try again.");
	                                    }
	                                    System.out.println();

	                                } while (keepUpdating4);

	                                System.out.print("Do you want to get employee by status again? (yes/no): ");
	                                repeat = scanner.nextLine().trim().toLowerCase();
	                                System.out.println();

	                            } while (repeat.equals("yes"));

	                        } else {
	                            System.out.println("Access Denied: You do not have permission to get employee status.");
	                            System.out.println();
	                        }
	                        break;


	                    case 7:
	                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin") || user.getRole().equalsIgnoreCase("Manager") || user.getRole().equalsIgnoreCase("Team Lead")) {
	                            int totalCount = employeeService.getTotalEmployeeCount();
	                            System.out.println("Total number of employees: " + totalCount);
	                            System.out.println();
	                        } else {
	                            System.out.println("Access Denied: You do not have permission to count employees.");
	                            System.out.println();
	                        }
	                        break;

	                    case 8:
	                    	
	                        String role1 = user.getRole();  // e.g., "hr", "admin", etc.

	                        if (role1.equals("HR") || role1.equals("Admin")) {

	                            boolean keepUpdating5 = true;
	                            while (keepUpdating5) {
	                                System.out.print("Enter Employee ID to update: ");
	                                int empId = scanner.nextInt();
	                                scanner.nextLine();

	                                boolean updateMoreFields = true;

	                                while (updateMoreFields) {
	                                    System.out.println("\nSelect the field you want to update:");
	                                    System.out.println("1. Name");
	                                    System.out.println("2. Email");
	                                    System.out.println("3. Phone");
	                                    System.out.println("4. Department");
	                                    System.out.println("5. Designation");
	                                    System.out.println("6. Salary");
	                                    System.out.println("7. Joining Date");
	                                    System.out.println("8. Address");
	                                    System.out.println("9. Status");
	                                    System.out.println("10. Update All Fields");
	                                    System.out.println("11. Back");

	                                    System.out.print("Enter your choice: ");
	                                    int choice1 = scanner.nextInt();
	                                    scanner.nextLine();

	                                    switch (choice1) {
	                                        case 1:
	                                            System.out.print("Enter new Name: ");
	                                            String newName = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "name", newName);
	                                            System.out.println("Name updated successfully!");
	                                            break;
	                                        case 2:
	                                            System.out.print("Enter new Email: ");
	                                            String newEmail = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "email", newEmail);
	                                            System.out.println("Email updated successfully!");
	                                            break;
	                                        case 3:
	                                            System.out.print("Enter new Phone number: ");
	                                            String newPhone = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "phone", newPhone);
	                                            System.out.println("Phone number updated successfully!");
	                                            break;
	                                        case 4:
	                                            System.out.print("Enter new Department: ");
	                                            String newDept = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "department", newDept);
	                                            System.out.println("Department updated successfully!");
	                                            break;
	                                        case 5:
	                                            System.out.print("Enter new Designation: ");
	                                            String newDesg = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "designation", newDesg);
	                                            System.out.println("Designation updated successfully!");
	                                            break;
	                                        case 6:
	                                            System.out.print("Enter new Salary: ");
	                                            double newSalary = scanner.nextDouble();
	                                            scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "salary", newSalary);
	                                            System.out.println("Salary updated successfully!");
	                                            break;
	                                        case 7:
	                                            System.out.print("Enter new Joining Date (YYYY-MM-DD): ");
	                                            String newJoin = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "joining_date", newJoin);
	                                            System.out.println("Joining Date updated successfully!");
	                                            break;
	                                        case 8:
	                                            System.out.print("Enter new Address: ");
	                                            String newAddr = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "address", newAddr);
	                                            System.out.println("Address updated successfully!");
	                                            break;
	                                        case 9:
	                                            System.out.print("Enter new Status: ");
	                                            String newStatus = scanner.nextLine();
	                                            employeeService.updateEmployee(empId, "status", newStatus);
	                                            System.out.println("Status updated successfully!");
	                                            break;
	                                        case 10:
	                                            Employee updated = new Employee();

	                                            System.out.print("Enter new Name: ");
	                                            updated.setName(scanner.nextLine());

	                                            System.out.print("Enter new Email: ");
	                                            updated.setEmail(scanner.nextLine());

	                                            System.out.print("Enter new Phone: ");
	                                            updated.setPhone(scanner.nextLine());

	                                            System.out.print("Enter new Department: ");
	                                            updated.setDepartment(scanner.nextLine());

	                                            System.out.print("Enter new Designation: ");
	                                            updated.setDesignation(scanner.nextLine());

	                                            System.out.print("Enter new Salary: ");
	                                            updated.setSalary(scanner.nextDouble());
	                                            scanner.nextLine();

	                                            System.out.print("Enter new Joining Date: ");
	                                            updated.setJoiningDate(scanner.nextLine());

	                                            System.out.print("Enter new Address: ");
	                                            updated.setAddress(scanner.nextLine());

	                                            System.out.print("Enter new Status: ");
	                                            updated.setStatus(scanner.nextLine());

	                                            employeeService.updateEmployeeAllFields(empId, updated);
	                                            System.out.println("Employee details updated successfully!");
	                                            break;
	                                        case 11:
	                                            updateMoreFields = false;
	                                            continue;
	                                        default:
	                                            System.out.println("Invalid choice.");
	                                            continue;
	                                    }

	                                    // Ask after each update
	                                    System.out.print("Do you want to update another field for this employee? (yes/no): ");
	                                    String again = scanner.nextLine();
	                                    if (!again.equals("yes")) {
	                                        updateMoreFields = false;
	                                    }
	                                }

	                                // Ask to update another employee
	                                System.out.print("Do you want to update another employee? (yes/no): ");
	                                String againEmp = scanner.nextLine();
	                                if (!againEmp.equals("yes")) {
	                                    keepUpdating5 = false;
	                                }
	                            }
	                        }
	                        
	                        
	                        else if (role1.equals("Manager") || role1.equals("Team lead")) {
	                            boolean keepUpdating6 = true;

	                            while (keepUpdating6) {
	                                System.out.print("Enter Employee ID to update: ");
	                                int empId = scanner.nextInt();
	                                scanner.nextLine();

	                                boolean updateMoreFields = true;

	                                while (updateMoreFields) {
	                                    System.out.println("Choose field to update:");
	                                    System.out.println("1. Phone");
	                                    System.out.println("2. Address");
	                                    System.out.println("3. Designation");
	                                    System.out.println("4. Back");

	                                    System.out.print("Enter your choice: ");
	                                    int choice1 = scanner.nextInt();
	                                    scanner.nextLine();

	                                    String field = "";
	                                    String newValue = "";

	                                    switch (choice1) {
	                                        case 1:
	                                            field = "phone";
	                                            System.out.print("Enter new Phone: ");
	                                            newValue = scanner.nextLine();
	                                            break;
	                                        case 2:
	                                            field = "address";
	                                            System.out.print("Enter new Address: ");
	                                            newValue = scanner.nextLine();
	                                            break;
	                                        case 3:
	                                            field = "designation";
	                                            System.out.print("Enter new Designation: ");
	                                            newValue = scanner.nextLine();
	                                            break;
	                                        case 4:
	                                            updateMoreFields = false;
	                                            continue;
	                                        default:
	                                            System.out.println("Invalid choice.");
	                                            continue;
	                                    }

	                                    boolean success = employeeService.updateEmployeeByDepartment(user, empId, field, newValue);
	                                    if (success) {
	                                        System.out.println("Employee data updated successfully!");
	                                    } else {
	                                        System.out.println("Update failed. Make sure the employee is in your department.");
	                                    }

	                                    System.out.print("Do you want to update another field for the same employee? (yes/no): ");
	                                    String again = scanner.nextLine();
	                                    if (!again.equals("yes")) {
	                                        updateMoreFields = false;
	                                    }
	                                }

	                                System.out.print("Do you want to update another employee? (yes/no): ");
	                                String againEmp = scanner.nextLine();
	                                if (!againEmp.equals("yes")) {
	                                    keepUpdating6 = false;
	                                }
	                            }
	                        }
	                        
	                        else if (role1.equals("Employee")) {
	                            System.out.println("You can only update your own data.");
	                            System.out.print("Enter your registered email: ");
	                            String email = scanner.nextLine();

	                            boolean keepUpdating7 = true;

	                            while (keepUpdating7) {
	                                System.out.println("Which detail would you like to update?");
	                                System.out.println("1. Name");
	                                System.out.println("2. Phone");
	                                System.out.println("3. Email");
	                                System.out.println("4. Back");

	                                System.out.print("Enter choice: ");
	                                int choice1 = scanner.nextInt();
	                                scanner.nextLine();

	                                String field = "";
	                                String newValue = "";

	                                switch (choice1) {
	                                    case 1:
	                                        field = "name";
	                                        System.out.print("Enter new name: ");
	                                        newValue = scanner.nextLine();
	                                        break;
	                                    case 2:
	                                        field = "phone";
	                                        System.out.print("Enter new phone: ");
	                                        newValue = scanner.nextLine();
	                                        break;
	                                    case 3:
	                                        field = "email";
	                                        System.out.print("Enter new email: ");
	                                        newValue = scanner.nextLine();
	                                        break;
	                                    case 4:
	                                        keepUpdating7 = false;
	                                        continue;
	                                    default:
	                                        System.out.println("Invalid choice.");
	                                        continue;
	                                }

	                                boolean success = employeeService.updateOwnData(email, field, newValue);
	                                if (success) {
	                                    System.out.println("Your "+field+"  was updated successfully!");
	                                } else {
	                                    System.out.println("Update failed.");
	                                }

	                                System.out.print("Do you want to update another field? (yes/no): ");
	                                String again = scanner.nextLine();
	                                if (!again.equals("yes")) {
	                                    keepUpdating7 = false;
	                                }
	                            }
	                        }break;
                        
	                    case 9:
	                        if (user.getRole().equalsIgnoreCase("HR") || user.getRole().equalsIgnoreCase("Admin")) {
	                           
	                        	System.out.println("Enter employee for deleting");
	                        	int id5=scanner. nextInt();
	                        	scanner.nextLine();
	                        	
	                        	employeeService.deleteEmployee(id5);
	                        } else {
	                            System.out.println("Access Denied: You do not have permission to delete employees.");
	                            System.out.println();
	                        }
	                        break;

	                    case 10:
	                    	System.out.println("👋 Exiting USER MANAGEMENT SYSTEM. Goodbye!");
	                        System.out.println("==============================================================");
	                        System.out.println();

	                        break; 

	                    default:
	                        System.out.println("Invalid choice. Try again.");
	                        System.out.println();  
	            }
	      }while (choice != 10);        
	 }
}







