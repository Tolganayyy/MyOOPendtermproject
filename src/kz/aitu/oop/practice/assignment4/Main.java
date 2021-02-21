package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.data.DB;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepos;
import kz.aitu.oop.practice.assignment4.repositories.ProjectsRepos;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepos;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepos;

public class Main {
    public static void main(String[] args) {


        IDB db = new DB();
        IEmployeeRepos repo1 = new EmployeeRepos(db);
        IProjectsRepos repo2 = new ProjectsRepos(db);
        MyApplication app = new MyApplication(repo1, repo2);
        app.start();
    }
}
