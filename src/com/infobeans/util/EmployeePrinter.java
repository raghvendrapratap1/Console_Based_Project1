package com.infobeans.util;
import java.util.List;
import com.infobeans.model.Employee;

public class EmployeePrinter {

    public static void printEmployeeTable(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        String format = "| %-4s | %-24s | %-27s | %-13s | %-16s | %-20s | %-10s | %-15s | %-27s | %-10s |%n";

        String line = "+------+--------------------------+-----------------------------+---------------+------------------+----------------------+------------+-----------------+-----------------------------+------------+";

        System.out.println("Employees List:");
        System.out.println(line);
        System.out.format(format, "ID", "Name", "Email", "Phone", "Department", "Designation", "Salary", "Joining Date", "Address", "Status");
        System.out.println(line);

        for (Employee e : employees) {
            System.out.format(format,
                    e.getId(),
                    e.getName(),
                    e.getEmail(),
                    e.getPhone(),
                    e.getDepartment(),
                    e.getDesignation(),
                    e.getSalary(),
                    e.getJoiningDate(),
                    e.getAddress(),
                    e.getStatus());
        }
        System.out.println(line);
    }
}
