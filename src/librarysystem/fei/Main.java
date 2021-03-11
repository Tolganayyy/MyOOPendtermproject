package librarysystem.fei;


import librarysystem.fei.controllers.AdminController;
import librarysystem.fei.controllers.BookController;
import librarysystem.fei.controllers.BorrowRecordController;
import librarysystem.fei.controllers.StudentController;
import librarysystem.fei.data.PostgresDB;
import librarysystem.fei.data.interfaces.IDB;
import librarysystem.fei.repositories.AdminRepository;
import librarysystem.fei.repositories.BookRepository;
import librarysystem.fei.repositories.BorrowRecordRepository;
import librarysystem.fei.repositories.StudentRepository;
import librarysystem.fei.repositories.interfaces.IAdminRepository;
import librarysystem.fei.repositories.interfaces.IBookRepository;
import librarysystem.fei.repositories.interfaces.IBorrowRecordRepository;
import librarysystem.fei.repositories.interfaces.IStudentRepository;

public class Main {

    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            // Here we load the driver’s class file into memory at the runtime
//            Class.forName("org.postgresql.Driver");
//
//            // Establish the connection
//            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
//
//            // The object of statement is responsible to execute queries with the database
//            stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
//            rs = stmt.executeQuery("select mistake * from users");
//
//            while (rs.next()) // Processing the result
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        }
//        catch (Exception e) {
//            System.out.println("Exception occurred!");
//        } finally {
//
//            try { // Close connection - clean up the system resources
//                con.close();
//            } catch (Exception e) {
//                System.out.println("Exception occurred!");
//            }
//        }
//
//        System.out.println("Finished!");

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
        IBookRepository bookrepo = new BookRepository(db);
        IBorrowRecordRepository borrowrepo = new BorrowRecordRepository(db);
        IAdminRepository adminrepo = new AdminRepository(db);
        IStudentRepository studentrepo = new StudentRepository(db);
        BookController bookController = new BookController(bookrepo);
        BorrowRecordController recordController = new BorrowRecordController(borrowrepo,bookrepo);
        AdminController adminController = new AdminController(adminrepo);
        StudentController studentController = new StudentController(studentrepo);
        librarysystem.fei.MyApplication app = new librarysystem.fei.MyApplication(bookController,recordController,adminController,studentController);
        app.start();
    }
}
