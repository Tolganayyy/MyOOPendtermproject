package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employees;
import kz.aitu.oop.practice.assignment4.entities.Projects;

import java.util.List;

public interface IProjectsRepos {
    boolean createProjects(Projects project);
    Projects getProject(int id);
    List<Employees> getEmployeeByProjects(int id);
    List<Projects> getAllProjects();


}
