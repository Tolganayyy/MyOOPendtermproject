package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employees;

import java.util.List;

public interface IEmployeeRepos {
    boolean createEmployee(Employees employee);
    Employees getEmployee(int id);
    List<Employees> getAllEmployees();
}
