package que.zad1.main;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TaskManager {

    private Queue<Task> tasks = new PriorityQueue<>();
    private Scanner sc = new Scanner(System.in);

    void mainLoop() {
        Options option;
        do {
            printOptions();
            System.out.println("Wybierz opcję:");
            option = createFromInt(sc.nextInt());
            sc.nextLine();
            switch (option) {

                case EXIT -> System.out.println("EXIT");
                case ADD -> {
                    tasks.offer(readAndCreateTask());
                    System.out.println("Zadanie dodane do kolejki");
                }
                case TAKE -> takeTask();
            }
        } while (option != Options.EXIT);


    }

    private void takeTask() {
        if (tasks.isEmpty()) {
            throw new IllegalStateException("Queue task is empty");
        } else {
            Task nextTask = tasks.poll();
            System.out.println("Zadanie do wykonania");
            System.out.println(nextTask);
        }

    }

    private Task readAndCreateTask() {
        System.out.println("Podaj nazwę zadania");
        String name = sc.nextLine();
        System.out.println("Podaj opis zadania");
        String description = sc.nextLine();
        System.out.println("Podaj priorytet zadamia, ");
        for (Priority value : Priority.values()) {
            System.out.print(value + " ");
        }
        Priority priority = Priority.valueOf(sc.nextLine());
        return new Task(name, description, priority);
    }

    static Options createFromInt(int option) {
        return Options.values()[option];
    }


    void printOptions() {
        Options[] values = Options.values();
        for (Options value : values) {
            System.out.println(value);
        }
    }


}

