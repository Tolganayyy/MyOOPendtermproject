package librarysystem.fei.entities;

import java.util.Date;

public class BorrowRecord {
    private int borrowId;
    private int bookId;
    private int studentId;
    private Date borrowdate;
    private Date returndate;
    private int borrowAmount;


    @Override
    public String toString() {
        return "BorrowRecord{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", borrowdate=" + borrowdate +
                ", returndate=" + returndate +
                ", borrowAmount=" + borrowAmount +
                '}';
    }

    public BorrowRecord() {
    }

    public BorrowRecord(int id,int bookId, int studentId, Date borrowdate, Date returndate, int borrowAmount) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.borrowdate = borrowdate;
        this.returndate = returndate;
        this.borrowAmount = borrowAmount;

    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(int borrowAmount) {
        this.borrowAmount = borrowAmount;
    }
}
