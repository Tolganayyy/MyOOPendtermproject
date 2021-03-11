package librarysystem.fei.repositories;

import librarysystem.fei.data.interfaces.IDB;
import librarysystem.fei.entities.Student;
import librarysystem.fei.repositories.interfaces.IStudentRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final IDB db;

    public StudentRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "INSERT INTO student(id,name) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, student.getId());
            st.setString(2, student.getName());
            st.execute();
            return true;
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
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM student WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"));
                return student;
            }

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
    public List<Student> getAllStudent() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM student";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> students = new LinkedList<Student>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"));

                students.add(student);
            }

            return students;
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
    public boolean deleteStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "delete from student where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            return true;
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
        return false;
    }
}
