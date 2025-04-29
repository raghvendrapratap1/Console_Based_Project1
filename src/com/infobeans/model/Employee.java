package com.infobeans.model;

public class Employee {
	
    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;
    private String joiningDate;
    private String address;
    private String status;
   

    public Employee() {}

    public Employee(int id, String name, String email, String phone, String department, String designation, 
                    double salary, String joiningDate, String address, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.address = address;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

  

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + 
               ", department=" + department + ", designation=" + designation + ", salary=" + salary + 
               ", joiningDate=" + joiningDate + ", address=" + address + ", status=" + status + ", userId="  + "]";
    }
}
