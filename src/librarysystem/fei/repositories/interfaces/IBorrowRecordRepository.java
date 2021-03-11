package librarysystem.fei.repositories.interfaces;

import librarysystem.fei.entities.BorrowRecord;

import java.util.List;

public interface IBorrowRecordRepository {
    public boolean borrowBooks(int id,int sid,int bid,int amount);
    public boolean ReturnBooks(int sid,int bid);
    public List<BorrowRecord> SelectBorrowRecord(int id);
}
