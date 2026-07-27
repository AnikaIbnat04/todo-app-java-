package TODOY_APP;
import java.util.Scanner;
public class TodoApp {

        static Node head = null;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n--- TODO APP ---");
                System.out.println("1. Add task");
                System.out.println("2. View tasks");
                System.out.println("3. Mark task as complete");
                System.out.println("4. Edit task");
                System.out.println("5. Delete task");
                System.out.println("6. Quit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter new task: ");
                    String description = scanner.nextLine();
                    addTask(description);
                    System.out.println("Task added!");

                } else if (choice == 2) {
                    viewTasks();

                } else if (choice == 3) {
                    viewTasks();
                    System.out.print("Enter task number to mark complete: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    markComplete(num);

                } else if (choice == 4) {
                    viewTasks();
                    System.out.print("Enter task number to edit: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    editTask(num, newDescription);

                } else if (choice == 5) {
                    viewTasks();
                    System.out.print("Enter task number to delete: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    deleteTask(num);

                } else if (choice == 6) {
                    running = false;
                    System.out.println("Goodbye!");

                } else {
                    System.out.println("Invalid option, try again.");
                }
            }

            scanner.close();
        }

        public static void addTask(String description) {
            Task newTask = new Task(description);
            Node newNode = new Node(newTask);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public static void viewTasks() {
            if (head == null) {
                System.out.println("No tasks yet!");
                return;
            }

            Node current = head;
            int count = 1;
            while (current != null) {
                System.out.println(count + ". " + current.data.toString());
                current = current.next;
                count++;
            }
        }

        public static void markComplete(int num) {
            Node current = head;
            int count = 1;

            while (current != null) {
                if (count == num) {
                    current.data.isDone = true;
                    System.out.println("Task marked complete!");
                    return;
                }
                current = current.next;
                count++;
            }

            System.out.println("Task number not found.");
        }

        public static void editTask(int num, String newDescription) {
            Node current = head;
            int count = 1;

            while (current != null) {
                if (count == num) {
                    current.data.description = newDescription;
                    System.out.println("Task updated!");
                    return;
                }
                current = current.next;
                count++;
            }

            System.out.println("Task number not found.");
        }

        public static void deleteTask(int num) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }

            if (num == 1) {
                head = head.next;
                System.out.println("Task deleted!");
                return;
            }

            Node current = head;
            int count = 1;

            while (current != null && count < num - 1) {
                current = current.next;
                count++;
            }

            if (current == null || current.next == null) {
                System.out.println("Task number not found.");
                return;
            }

            current.next = current.next.next;
            System.out.println("Task deleted!");
        }

}
