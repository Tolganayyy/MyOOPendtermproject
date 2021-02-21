package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Employees;
import kz.aitu.oop.practice.assignment4.entities.Projects;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProjectsRepos implements IProjectsRepos {
    private final IDB db;
    public ProjectsRepos(IDB db){
        this.db = db;
    }

    @Override
    public boolean createProjects(Projects project) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql ="INSERT INTO projects (pName,cost) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, project.getpName());
            st.setDouble(2,project.getCost());
            st.execute();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public Projects getProject(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql ="INSERT id ,pName ,cost FROM projects WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Projects projects = new Projects(rs.getInt("id"),
                        rs.getString("pName"),
                        rs.getDouble("cost"));
                return projects;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Employees> getEmployeeByProjects(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,salary ,gender FROM employss";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employeeList = new ArrayList<>();
            while (rs.next()) {
                Employees employees  = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getBoolean("gender")
                );

                employeeList.add(employees);
            }

            return employeeList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Projects> getAllProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,pName,cost FROM projects";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Projects> projects = new LinkedList<>();
            while (rs.next()) {
                Projects projects1 = new Projects(rs.getInt("id"),
                        rs.getString("pName"),
                        rs.getDouble("cost"));

                projects.add(projects1);
            }

            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
