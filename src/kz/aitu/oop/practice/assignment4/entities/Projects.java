package kz.aitu.oop.practice.assignment4.entities;

import java.util.List;

public class Projects {
    private int id;
    private String pName;
    private double cost;
    private List<Employees> employeeList;

    public Projects (){

    }
    public Projects ( String pName ,double cost){
     setpName(pName);
     setCost(cost);
    }
    public Projects (int id , String pName ,double cost ){
        setId(id);
        setpName(pName);
        setCost(cost);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpName() {
        return pName;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public List<Employees> getEmployeeList() {
        return employeeList;
    }
    public void setEmployeeList(List<Employees> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
