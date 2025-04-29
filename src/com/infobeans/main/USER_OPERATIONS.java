package com.infobeans.main;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.infobeans.model.User;
import com.infobeans.service.UserService;
import com.infobeans.util.UserPrinter;
public class USER_OPERATIONS {

    public static void userOperations() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("=============================== USER MANAGEMENT SYSTEM ===============================");

        String repeatOperation;

        do {
            boolean continueUpdating = true;

            do {
                System.out.println("\n1. Enter User Details");
                System.out.println("2. View All Users");
                System.out.println("3. Find Users By");
                System.out.println("4. Update User Details");
                System.out.println("5. Delete User");
                System.out.println("6. Back");
                System.out.print("\nEnter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();

                        System.out.print("Enter Email_ID: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Role (HR/Admin/Manager/Team Lead/Employee): ");
                        String role = scanner.nextLine();

                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();

                        User user = new User(0, username, password, email, role, department);
                        userService.addUser(user);
                        System.out.println("✅ User added successfully!");
                        break;

                    case 2:
                        List<User> userList = userService.getAllUsers();
                        UserPrinter.printUserTable(userList);
                        break;

                    case 3:
                        boolean keepSearching = true;
                        do {
                            System.out.println("\n1. ID\n2. Name\n3. Password\n4. Email\n5. Role\n6. Department\n7. Back");
                            System.out.print("Enter your choice: ");
                            int choice1 = scanner.nextInt();
                            scanner.nextLine();

                            switch (choice1) {
                                case 1:
                                    System.out.print("Enter ID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    UserPrinter.printUserTable(userService.getUserById(id));
                                    break;
                                case 2:
                                    System.out.print("Enter Name: ");
                                    UserPrinter.printUserTable(userService.getUserByName(scanner.nextLine()));
                                    break;
                                case 3:
                                    System.out.print("Enter Password: ");
                                    UserPrinter.printUserTable(userService.getUserByPassword(scanner.nextLine()));
                                    break;
                                case 4:
                                    System.out.print("Enter Email: ");
                                    UserPrinter.printUserTable(userService.getUserByEmail(scanner.nextLine()));
                                    break;
                                case 5:
                                    System.out.print("Enter Role: ");
                                    UserPrinter.printUserTable(userService.getUserByRole(scanner.nextLine()));
                                    break;
                                case 6:
                                    System.out.print("Enter Department: ");
                                    UserPrinter.printUserTable(userService.getUserByDepartment(scanner.nextLine()));
                                    break;
                                case 7:
                                    keepSearching = false;
                                    break;
                                default:
                                    System.out.println("❌ Invalid choice. Try again.");
                            }
                        } while (keepSearching);
                        break;

                    case 4:
                        System.out.print("Enter User ID to Update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        String updateMore = null;
                        do {
                            System.out.println("\n1. Username\n2. Password\n3. Role\n4. Email\n5. Department\n6. Exit");
                            System.out.print("Enter your choice: ");
                            int updateChoice = scanner.nextInt();
                            scanner.nextLine();

                            String field = "";
                            String newValue = "";

                            switch (updateChoice) {
                                case 1:
                                    field = "username";
                                    System.out.print("Enter New Username: ");
                                    break;
                                case 2:
                                    field = "password";
                                    System.out.print("Enter New Password: ");
                                    break;
                                case 3:
                                    field = "role";
                                    System.out.print("Enter New Role: ");
                                    break;
                                case 4:
                                    field = "email";
                                    System.out.print("Enter New Email: ");
                                    break;
                                case 5:
                                    field = "department";
                                    System.out.print("Enter New Department: ");
                                    break;
                                case 6:
                                    System.out.println("🔙 Returning to main menu...");
                                    continue;
                                default:
                                    System.out.println("❌ Invalid choice. Try again.");
                                    continue;
                            }

                            newValue = scanner.nextLine();
                            userService.updateUser(updateId, field, newValue);
                            System.out.println("✅ " + field + " updated successfully!");

                            System.out.print("Do you want to update another field for this user? (yes/no): ");
                            updateMore = scanner.nextLine().trim().toLowerCase();

                        } while (updateMore.equals("yes"));
                        break;


                    case 5:
                        System.out.print("Enter User ID to Delete: ");
                        int deleteId = scanner.nextInt();
                        userService.deleteUser(deleteId);
                        System.out.println("✅ User deleted successfully!");
                        break;

                    case 6:
                        continueUpdating = false;
                        break;

                    default:
                        System.out.println("❌ Invalid choice. Try again.");
                }

            } while (continueUpdating);

            System.out.print("\nDo you want to perform more operations? (yes/no): ");
            repeatOperation = scanner.nextLine().trim().toLowerCase();

        } while (repeatOperation.equals("yes"));

        System.out.println("👋 Exiting USER MANAGEMENT SYSTEM. Goodbye!");
    }
}
