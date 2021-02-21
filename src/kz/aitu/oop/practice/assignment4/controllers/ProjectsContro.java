package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Projects;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepos;

import java.util.List;

public class ProjectsContro {
    private final IProjectsRepos repo;

    public ProjectsContro(IProjectsRepos repo) {
        this.repo = repo;
    }

    public String createProjects(String pName, double cost) {
        Projects projects = new Projects(pName, cost);

        boolean created = repo.createProjects(projects);

        return (created ? "Project was created!" : "Project creation was failed!");
    }

    public String getProject(int id) {
        Projects projects = repo.getProject(id);

        return (projects == null ? "Projects was not found!" : projects.toString());
    }

    public String getAllProjects() {
        List<Projects> project = repo.getAllProjects();

        return project.toString();
    }

}
