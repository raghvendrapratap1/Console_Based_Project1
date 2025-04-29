package com.infobeans.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.infobeans.db.DatabaseConnection;
import com.infobeans.model.User;

public class LOGIN {
    
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        User authenticatedUser = null;

        while (authenticatedUser == null) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine().trim();

            authenticatedUser = authenticateUser(username, password);

            if(authenticatedUser == null) {
                System.out.println("❌ Invalid Credentials! Try again or type 'exit' to quit.");
                System.out.print("Retry login? (yes/exit): ");
                String retry = scanner.nextLine().trim().toLowerCase();
                if (retry.equals("exit")) return null;
            }
        }

        System.out.println("✅ Login Successful!\n");
        EMPLOYEE_MENU.employeeMenu(authenticatedUser); // Send user to role-based menu
        return authenticatedUser;
    }

    public static User authenticateUser(String username, String password) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getString("department")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
        return null;
    }
}
