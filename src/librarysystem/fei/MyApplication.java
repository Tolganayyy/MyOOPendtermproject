package librarysystem.fei;


import librarysystem.fei.controllers.AdminController;
import librarysystem.fei.controllers.BookController;
import librarysystem.fei.controllers.BorrowRecordController;
import librarysystem.fei.controllers.StudentController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final BookController controller;
    private final BorrowRecordController borrowcontroller;
    private final AdminController adminController;
    private final StudentController studentController;
    private final Scanner scanner;

    public MyApplication(BookController controller,BorrowRecordController borrowcontroller,AdminController adminController,StudentController studentController) {
        this.controller = controller;
        this.borrowcontroller = borrowcontroller;
        this.adminController = adminController;
        this.studentController = studentController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Library System");
            System.out.println("Select option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by id / name / author");
            System.out.println("3. creat book ");
            System.out.println("4. delete book");
            System.out.println("5. borrow books");
            System.out.println("6. return books");
            System.out.println("7. select borrow book record");
            System.out.println("8. select admin");
            System.out.println("9. creat student");
            System.out.println("10. Select student");
            System.out.println("11. get student");
            System.out.println("12. delete student");
            System.out.println("13. creat Admin");
            System.out.println("14. select Admin By Id");
            System.out.println("15. get Admin");
            System.out.println("16. delete Admin");

            System.out.println("0. Exit");
            try {
                System.out.print("Enter option (1-16): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllBookMenu();
                } else if (option == 2) {
                    getBookMenu();
                }else if (option == 3) {
                    createBookMenu();
                } else if (option == 4) {
                    deleteBookMenu();
                }else if (option == 5) {
                    borrowBooksMenu();
                }else if (option == 6) {
                    ReturnBooksMenu();
                }else if (option == 7) {
                    SelectBorrowRecordMenu();
                }else if (option == 8) {
                    SelectAdminMenu();
                }else if (option == 9) {
                    createStudentMenu();
                }else if (option == 10) {
                    selectStudentByIdMenu();
                }else if (option == 11) {
                    getStudentMenu();
                }else if (option == 12) {
                    deleteStudentMenu();
                }else if (option == 13) {
                    createAdminMenu();
                }else if (option == 14) {
                    selectAdminByIdMenu();
                }else if (option == 15) {
                    getAdminMenu();
                }else if (option == 16) {
                    deleteAdminMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }


    public void getAllBookMenu() {
        String response = controller.getAllBook();
        System.out.println(response);
    }

    public void getBookMenu(){
        System.out.println("Please enter query mode 1 by id /2 by name /3  by  author");
        int number = scanner.nextInt();
        if (number == 1){
            getBookByIdMenu();
        }else if (number == 2){
            getBookByNameMenu();
        }
        else if (number == 3){
            getBookByAuthorMenu();
        }
    }
    public void getBookByIdMenu() {

        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getBookById(id);
        System.out.println(response);
    }
    public void getBookByNameMenu(){
        System.out.println("Please enter name");

        String name = scanner.next();
        String response = controller.getBookByName(name);
        System.out.println(response);
    }
    public void getBookByAuthorMenu(){
        System.out.println("Please enter author");

        String author= scanner.next();
        String response = controller.getBookByAuthor(author);
        System.out.println(response);
    }

    public void createBookMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter author");
        String author = scanner.next();
        System.out.println("Please enter pages");
        int pages = scanner.nextInt();
        System.out.println("Please enter isbn");
        String isbn = scanner.next();
        System.out.println("Please enter amount");
        int amount = scanner.nextInt();
        String response = controller.createBook(id,name,author,pages,isbn,amount);
        System.out.println(response);
    }
    private void deleteBookMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.deleteBook(id);
        System.out.println(response);
    }



    public void borrowBooksMenu() {
        System.out.println("Please enter borrow student id");
        int sid = scanner.nextInt();
        System.out.println("Please enter borrow book id");
        int bid = scanner.nextInt();
        System.out.println("Please enter borrow  number");
        int amount = scanner.nextInt();
        System.out.println("Please enter borrow borrow id");
        int id = scanner.nextInt();
        String s = borrowcontroller.borrowBooks(id ,bid, sid, amount);
        System.out.println(s);
    }

    public void ReturnBooksMenu() {
        System.out.println("Please enter  return student id");
        int sid = scanner.nextInt();
        System.out.println("Please enter return book id");
        int bid = scanner.nextInt();
        String s = borrowcontroller.ReturnBooks(sid, bid);
        System.out.println(s);

    }

    public void SelectBorrowRecordMenu(){
        System.out.println("Please enter book id");
        int id = scanner.nextInt();
        String s = borrowcontroller.SelectBorrowRecord(id);
        System.out.println(s);
    }
    public void SelectAdminMenu(){
        System.out.println("Please enter admin id");
        int id = scanner.nextInt();
        String admin = adminController.getAdminById(id);
        System.out.println(admin);
    }
    private void createStudentMenu() {
        System.out.println("Please enter student id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name= scanner.next();
        System.out.println("Please enter borrow  number");
        String student = studentController.createBook(id, name);
        System.out.println(student);
    }
    private void selectStudentByIdMenu() {
        System.out.println("Please enter student id");
        int id = scanner.nextInt();
        String student = studentController.getStudentById(id);
        System.out.println(student);
    }
    private void getStudentMenu() {
        String students = studentController.getAllStudent();
        System.out.println(students);
    }
    private void deleteStudentMenu() {
        System.out.println("Please enter student id");
        int id = scanner.nextInt();
        String s = studentController.deleteStudent(id);
        System.out.println(s);
    }
    private void createAdminMenu() {
        System.out.println("Please enter admin id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name= scanner.next();
        System.out.println("Please enter pwd");
        String pwd= scanner.next();
        String admin = adminController.createBook(id, name, pwd);
        System.out.println(admin);
    }
    private void selectAdminByIdMenu() {
        System.out.println("Please enter student id");
        int id = scanner.nextInt();
        String admin = adminController.getAdminById(id);
        System.out.println(admin);
    }
    private void getAdminMenu() {
        String admins = adminController.getAllAdmin();
        System.out.println(admins);
    }
    private void deleteAdminMenu() {
        System.out.println("Please enter student id");
        int id = scanner.nextInt();
        String s = adminController.deleteAdmin(id);
        System.out.println(s);
    }

}
