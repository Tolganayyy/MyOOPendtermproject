package librarysystem.fei.controllers;

import librarysystem.fei.entities.BorrowRecord;
import librarysystem.fei.repositories.interfaces.IBookRepository;
import librarysystem.fei.repositories.interfaces.IBorrowRecordRepository;

import java.util.List;

public class BorrowRecordController {
    private final IBorrowRecordRepository recordrepo;
    private final IBookRepository bookrepo;
    public BorrowRecordController(IBorrowRecordRepository recordrepo, IBookRepository bookrepo) {
        this.recordrepo = recordrepo;
        this.bookrepo = bookrepo;
    }

    public  String borrowBooks(int id ,int sid, int bid, int amount) {
        if(bookrepo.getBookById(sid)!= null) {
            System.out.println("Please enter borrow book id");
            System.out.println("Please enter borrow  number");
            boolean b = recordrepo.borrowBooks(id,sid, bid, amount);
            return (b ? "Borrow Book Succeed!" : "Borrow Book Fail*");
        }
         else return "Borrow Book Fail, the student id is incorrect";
    }
    public String ReturnBooks(int sid, int bid) {
        boolean b = recordrepo.ReturnBooks(sid, bid);
        return (b ? "Return Book Succeed!" : "Return Book Fail");
    }
    public String SelectBorrowRecord(int id) {
        List<BorrowRecord> list = recordrepo.SelectBorrowRecord(id);
        return list.toString();
    }
}
