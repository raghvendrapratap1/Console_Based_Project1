package com.infobeans.service;

import com.infobeans.dao.UserDAO;
import com.infobeans.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    
    private UserDAO userDAO;

    public UserService() {
    	this.userDAO=new UserDAO()	;
    }

	public User login(String username, String password) throws SQLException {
        return userDAO.authenticateUser(username, password);
    }
	
	public boolean addUser(User user) throws SQLException {
		return  userDAO.addUser(user);		
	}

    public List<User> getAllUsers() throws SQLException {
        return userDAO.viewAllUsers();    
    }

    public List<User> getUserById(int userId) throws SQLException {
        return userDAO.getUserById(userId);
    }

    public List<User> getUserByName(String userName) throws SQLException {
        return userDAO.getUserByName(userName);
    }
    
    public List<User> getUserByPassword(String userPassword) throws SQLException {
        return userDAO.getUserByPassword(userPassword);
    }
    
    public List<User> getUserByEmail(String userEmail) throws SQLException {
        return userDAO.getUserByEmail(userEmail);
    }

    public List<User> getUserByDepartment(String userDepartment) throws SQLException {
        return userDAO.getUserByDepartment(userDepartment);
    }

    public List<User> getUserByRole(String userRole) throws SQLException {
        return userDAO.getUsersByRole(userRole);
    }

    public void updateUser(int userId, String field, String newValue) throws SQLException {
        userDAO.updateUser(userId, field, newValue);
    }

    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }
    
    public User authenticateUser(String username, String password) throws Exception {
        return userDAO.authenticateUser(username, password);
    }
}


//package com.infobeans.service;
//import com.infobeans.dao.UserDAO;
//import com.infobeans.model.User;
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserService {
//    
//    private UserDAO userDAO;
//
//    // Constructor to initialize UserDAO
//    public UserService(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//    
//    public UserService() {
//        // Default constructor
//    }
//
//    // 1️⃣ Authenticate user (Login)
//    public User login(String username, String password) throws SQLException {
//        return userDAO.authenticateUser(username, password);
//    }
//    
// // 2️⃣ Add a new user
//    public void addUser(String username, String role, String department,  String password) throws SQLException {
//        User user = new User(0, username, role, department, password); // ID is auto-generated in DB
//        userDAO.addUser(user);
//    }
//    
// // 3️⃣ Get all users (for GUI table)
//    public List<User> getAllUsers() throws SQLException {
//        return userDAO.viewAllUsers();
//    }
//
//    // 4️⃣ Get a user by ID
//    public User getUserById(int userId) throws SQLException {
//        return userDAO.getUserById(userId);
//    }
//    
// // 5 Get a user by Name
//    public User getUserByName(String userName) throws SQLException {
//        return userDAO.getUserByName(userName);
//    }
//
// // 6 Get a user by Department
//    public User getUserByDepartment(String userDepartment) throws SQLException {
//        return userDAO.getUserByDepartment(userDepartment);
//    }
//    
//    // 7 Update user details (asks which field to update)
//    public void updateUser(int userId, String field, String newValue) throws SQLException {
//        userDAO.updateUser(userId, field, newValue);
//    }
//
//    // 8 Delete a user
//    public void deleteUser(int userId) throws SQLException {
//        userDAO.deleteUser(userId);
//    }
//}