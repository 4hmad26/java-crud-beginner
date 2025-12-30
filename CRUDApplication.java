import java.util.ArrayList;
import java.util.Scanner;


class User {
int id;
String name;
String email;


User(int id, String name, String email) {
this.id = id;
this.name = name;
this.email = email;
}
}


public class CRUDApplication {
static ArrayList<User> users = new ArrayList<>();
static Scanner sc = new Scanner(System.in);


public static void main(String[] args) {
int choice;


do {
System.out.println("\n===== CRUD MENU =====");
System.out.println("1. Add User");
System.out.println("2. View Users");
System.out.println("3. Update User");
System.out.println("4. Delete User");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");


choice = sc.nextInt();


switch (choice) {
case 1 -> addUser();
case 2 -> viewUsers();
case 3 -> updateUser();
case 4 -> deleteUser();
case 5 -> System.out.println("Exiting application...");
default -> System.out.println("Invalid choice!");
}
} while (choice != 5);
};


// CREATE
static void addUser() {
System.out.print("Enter ID: ");
int id = sc.nextInt();
sc.nextLine();



System.out.print("Enter Name: ");
String name = sc.nextLine();


System.out.print("Enter Email: ");
String email = sc.nextLine();


users.add(new User(id, name, email));
System.out.println("User added successfully!");
}


// READ
static void viewUsers() {
if (users.isEmpty()) {
System.out.println("No users found!");
return;
}


System.out.println("\n--- User List ---");
for (User user : users) {
System.out.println("ID: " + user.id + ", Name: " + user.name + ", Email: " + user.email);
}
}


// UPDATE
static void updateUser() {
System.out.print("Enter User ID to update: ");
int id = sc.nextInt();
sc.nextLine();


for (User user : users) {
if (user.id == id) {
System.out.print("Enter new Name: ");
user.name = sc.nextLine();


System.out.print("Enter new Email: ");
user.email = sc.nextLine();


System.out.println("User updated successfully!");
return;
}
}
System.out.println("User not found!");
}


// DELETE
static void deleteUser() {
System.out.print("Enter User ID to delete: ");
int id = sc.nextInt();


for (User user : users) {
if (user.id == id) {
users.remove(user);
System.out.println("User deleted successfully!");
return;
}
}
System.out.println("User not found!");
}
}