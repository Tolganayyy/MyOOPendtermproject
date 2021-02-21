package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeContro;
import kz.aitu.oop.practice.assignment4.controllers.ProjectsContro;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepos;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepos;

import java.util.Scanner;

public class MyApplication {
    private final EmployeeContro controller1;
    private final ProjectsContro controller2;
    private final Scanner scanner;

    public MyApplication(IEmployeeRepos employeeRepository, IProjectsRepos projectRepository) {
        this.controller1 = new EmployeeContro(employeeRepository);
        this.controller2 = new ProjectsContro(projectRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Add a new employee");
            System.out.println("4. Get all projects");
            System.out.println("5. Get project by code");
            System.out.println("6. Create a new project");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    getAllProjectsMenu();
                } else if (option == 5) {
                    getProjectByCodeMenu();
                } else if (option == 6) {
                    createProjectMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("*************************");
        }
    }

    public void getAllEmployeesMenu() {
        String response = controller1.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller1.getEmployees(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter salary");
        Double salary = Double.valueOf(scanner.next());
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();
        String response = controller1.createEmployees(name, salary, gender);
        System.out.println(response);
    }

    public void getAllProjectsMenu() {
        String response = controller2.getAllProjects();
        System.out.println(response);
    }

    public void getProjectByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller2.getProject(code);
        System.out.println(response);
    }

    public void createProjectMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter application:");
        Double cost = Double.valueOf(scanner.next());
        String response = controller2.createProjects(name, cost);
        System.out.println(response);
    }





}
