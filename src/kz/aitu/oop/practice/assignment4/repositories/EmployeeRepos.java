package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Employees;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepos;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepos implements IEmployeeRepos {
    private final IDB db;
    public EmployeeRepos(IDB db){
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employees employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql ="INSERT INTO employees (name,salary,gender) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, employee.getName());
            st.setDouble(2,employee.getSalary());
            st.setBoolean(3,employee.isGender());
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
    public Employees getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql ="INSERT id ,name ,salary,gender FROM employees WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Employees employees = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getBoolean("gender"));
                return employees;
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
    public List<Employees> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,salary,gender FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employees = new LinkedList<>();
            while (rs.next()) {
                Employees employees1 = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getBoolean("gender"));

                employees.add(employees1);
            }

            return employees;
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


