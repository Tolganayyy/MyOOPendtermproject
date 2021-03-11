package librarysystem.fei.controllers;

import librarysystem.fei.entities.Student;
import librarysystem.fei.repositories.interfaces.IStudentRepository;

import java.util.List;

public class StudentController {
    private final IStudentRepository studentrepo;

    public StudentController(IStudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }
    public String createBook(int id,String name){
        Student student = new Student(id, name);
        boolean created = studentrepo.createStudent(student);
        return (created ? "Student was created!" : "Student creation was failed!");
    }
    public String getStudentById(int id){
        Student student = studentrepo.getStudentById(id);
        return (student == null ? "Student was not found!" : student.toString());
    }
    public String getAllStudent() {
        List<Student> students = studentrepo.getAllStudent();

        return students.toString();
    }
    public String deleteStudent(int id){
        boolean delete = studentrepo.deleteStudent(id);
        return (delete ? "Student was deleted!" : "Student delete was failed!");
    }
}
