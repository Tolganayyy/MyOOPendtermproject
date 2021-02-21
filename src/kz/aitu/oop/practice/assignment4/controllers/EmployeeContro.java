package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employees;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepos;

import java.util.List;

public class EmployeeContro {
    private final IEmployeeRepos empl;
    public EmployeeContro(IEmployeeRepos empl){
        this.empl = empl;
    }
    public String createEmployees(String name ,double salary ,String gender){
        boolean male = (gender.toLowerCase().equals("male"));
        Employees employees = new Employees(name , salary , male);
        boolean created = empl.createEmployee(employees);
        return (created ? "Employees was created!" : "Employees creations was failed!");

    }
    public String getEmployees(int id){
        Employees employees = empl.getEmployee(id);

        return (employees == null ? "Employees was not found" : employees.toString());
    }
    public String getAllEmployees(){
        List<Employees> employees = empl.getAllEmployees();

    return employees.toString();
    }
}
