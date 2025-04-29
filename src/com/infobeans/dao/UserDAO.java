package com.infobeans.dao;
import com.infobeans.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.infobeans.db.*;

public class UserDAO {

    public User authenticateUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";
        Connection conn= DatabaseConnection.getConnection();
       PreparedStatement pstmt = conn.prepareStatement(query);
        	
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),                 
                    rs.getString("department"),
                    rs.getString("role")
                );
            }
        
        return null; // User not found
    }

    public boolean addUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password, email,  role, department) VALUES (?, ?, ?, ?, ?)";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());         
            pstmt.setString(4, user.getRole());
            pstmt.setString(5, user.getDepartment());
            pstmt.executeUpdate();
        
        return false;
    }

    public List<User> viewAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        Connection conn= DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }

 
    
    
    public List<User> getUserById(int id) throws SQLException {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(id)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }

    public List<User> getUserByName(String username) throws SQLException {
    	List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(username)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }
    
    public List<User> getUserByPassword(String password) throws SQLException {
    	List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(password)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setString(1, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }

    public List<User> getUserByEmail(String email) throws SQLException {
    	List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(email)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }
    public List<User> getUserByDepartment(String department) throws SQLException {
    	List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(department)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setString(1,department);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }

    public List<User> getUsersByRole(String role) throws SQLException {
    	List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE LOWER(TRIM(role)) = LOWER(TRIM(?))";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        
            pstmt.setString(1, role);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                		rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),                 
                        rs.getString("department"),
                        rs.getString("role")
                ));
            }
        
        return users;
    }

    public void updateUser(int userId, String field, String newValue) throws SQLException {
        String query = "UPDATE users SET " + field + " = ? WHERE id = ?";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newValue);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
    }
    

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        Connection conn= DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userId);
        pstmt.executeUpdate();
        
    }
}
