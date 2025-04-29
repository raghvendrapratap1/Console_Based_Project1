package com.infobeans.util;

import java.util.List;
import com.infobeans.model.User;

public class UserPrinter {

    public static void printUserTable(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No user data available.");
            return;
        }

        String format = "| %-5s | %-25s | %-15s | %-30s | %-22s | %-15s |\n";
        String line = "+-------+---------------------------+-----------------+--------------------------------+------------------------+-----------------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Username", "Password", "Email", "Role", "Department");
        System.out.println(line);

        for (User user : users) {
            System.out.printf(format,
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getDepartment()
            );
        }

        System.out.println(line);
    }
}
