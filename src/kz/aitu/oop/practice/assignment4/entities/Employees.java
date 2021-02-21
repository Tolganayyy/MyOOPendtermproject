package kz.aitu.oop.practice.assignment4.entities;

public class Employees {
    private int id;
    private String name;
    private double salary;
    private boolean gender;
    public Employees(){

    }
    public Employees( String name, double salary,  boolean gender){
       setName(name);
       setSalary(salary);
       setGender(gender);
    }
    public Employees( int id, String name, double salary, boolean gender){
        setId(id);
        setName(name);
        setSalary(salary);
        setGender(gender);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + (gender ? "male" : "female") +
                '}';
    }
}
