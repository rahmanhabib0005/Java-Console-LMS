import java.util.ArrayList;
import java.util.Scanner;

public class LMS {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter role (admin/instructor/student or 'exit' to quit): ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("exit")) {
                System.out.println("Exiting LMS. Goodbye!");
                break;
            }

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            User user;
            if (role.equals("admin")) {
                user = new Admin(name);
                adminMenu(scanner);
            } else if (role.equals("instructor")) {
                user = new Instructor(name);
                instructorMenu(scanner, name);
            } else if (role.equals("student")) {
                user = new Student(name);
                studentMenu(scanner);
            } else {
                System.out.println("Invalid role! Try again.");
                continue;
            }

            users.add(user);
            user.showMenu();
        }
    }

    private void adminMenu(Scanner scanner) {
        while (true) {
            System.out
                    .println("\n1. Add Course\n2. Assign Instructor\n3. View All Courses\n4. Export as JSON\n5. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter course title: ");
                    courses.add(new Course(scanner.nextLine()));
                    break;
                case 2:
                    listCourses();
                    System.out.print("Choose course index: ");
                    int i = safeIndex(scanner, courses.size());
                    if (i == -1)
                        break;
                    System.out.print("Enter instructor name: ");
                    courses.get(i).setInstructor(scanner.nextLine());
                    break;
                case 3:
                    listCourses();
                    break;
                case 4:
                    for (Course c : courses) {
                        System.out.println(c.toJson());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void instructorMenu(Scanner scanner, String instructorName) {
        while (true) {
            System.out.println("\n1. Add Content\n2. Assign Grade\n3. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                case 2:
                    ArrayList<Integer> indices = new ArrayList<>();
                    for (int i = 0; i < courses.size(); i++) {
                        if (courses.get(i).getInstructor().equalsIgnoreCase(instructorName)) {
                            System.out.println(i + ". " + courses.get(i).getTitle());
                            indices.add(i);
                        }
                    }
                    if (indices.isEmpty()) {
                        System.out.println("No assigned courses.");
                        break;
                    }
                    System.out.print("Select course index: ");
                    int idx = safeIndex(scanner, courses.size());
                    if (idx == -1)
                        break;
                    if (choice == 1) {
                        System.out.print("Enter content: ");
                        courses.get(idx).setContent(scanner.nextLine());
                    } else {
                        System.out.print("Enter grade: ");
                        courses.get(idx).setGrade(scanner.nextLine());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void studentMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n1. View Courses\n2. View Content\n3. View Grades\n4. Exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                case 3:
                    listCourses();
                    System.out.print("Select course index: ");
                    int idx = safeIndex(scanner, courses.size());
                    if (idx == -1)
                        break;
                    if (choice == 2)
                        System.out.println("Content: " + courses.get(idx).getContent());
                    else
                        System.out.println("Grade: " + courses.get(idx).getGrade());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            System.out.println(i + ". " + c.getTitle() + " | Instructor: " + c.getInstructor());
        }
    }

    private int safeIndex(Scanner scanner, int size) {
        try {
            int idx = Integer.parseInt(scanner.nextLine());
            if (idx >= 0 && idx < size)
                return idx;
            System.out.println("Invalid index.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
        return -1;
    }
}
