package librarysystem.fei.repositories.interfaces;


import librarysystem.fei.entities.Student;

import java.util.List;

public interface IStudentRepository {
    boolean createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudent();
    boolean deleteStudent(int id);
}
