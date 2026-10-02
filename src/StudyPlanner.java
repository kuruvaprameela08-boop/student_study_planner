import java.util.ArrayList;
import java.util.Scanner;

public class StudyPlanner {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT STUDY PLANNER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter Deadline: ");
        String deadline = sc.nextLine();

        System.out.print("Enter Priority (High/Medium/Low): ");
        String priority = sc.nextLine();

        Task task = new Task(
            id,
            title,
            subject,
            deadline,
            priority
        );

        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nID | Title | Subject | Deadline | Priority | Status");

        for (Task task : tasks) {
            task.displayTask();
        }
    }

    static void completeTask() {

        System.out.print("Enter Task ID to complete: ");
        int id = sc.nextInt();

        for (Task task : tasks) {

            if (task.getId() == id) {

                task.markCompleted();

                System.out.println("Task completed successfully!");
                return;
            }
        }

        System.out.println("Task not found!");
    }

    static void deleteTask() {
    System.out.print("Enter Task ID to delete: ");
    int id = sc.nextInt();
    boolean removed = tasks.removeIf(task -> task.getId() == id);
    if (removed) {
        System.out.println("Task deleted successfully!");
    } else {
        System.out.println("Task not found!");
    }
}
    }