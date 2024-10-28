package modul2.tugas.sesudahrefactor;

import java.util.ArrayList;
import java.util.Scanner;

interface TaskManager {
    void addTask(String task);
    void displayAllTasks();
    void removeTaskByIndex(int index);
}

public class TodoList implements TaskManager {
    private ArrayList<String> tasks;
    private static final int EXIT_OPTION = 4;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(String task) {
        tasks.add(task);
    }

    @Override
    public void displayAllTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    @Override
    public void removeTaskByIndex(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void handleUserInput(TodoList todo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Display tasks");
            System.out.println("3. Remove task");
            System.out.println(EXIT_OPTION + ". Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.println("Enter task:");
                String task = scanner.nextLine();
                todo.addTask(task);
            } else if (choice == 2) {
                todo.displayAllTasks();
            } else if (choice == 3) {
                System.out.println("Enter task number to remove:");
                int index = scanner.nextInt();
                todo.removeTaskByIndex(index);
            } else if (choice == EXIT_OPTION) {
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TodoList todo = new TodoList();
        handleUserInput(todo);
    }
}

