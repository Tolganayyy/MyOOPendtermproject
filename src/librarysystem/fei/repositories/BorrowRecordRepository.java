package librarysystem.fei.repositories;


import librarysystem.fei.data.interfaces.IDB;
import librarysystem.fei.entities.BorrowRecord;
import librarysystem.fei.repositories.interfaces.IBorrowRecordRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRecordRepository implements IBorrowRecordRepository {

    private final IDB db;

    public BorrowRecordRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean borrowBooks(int id ,int bid, int sid, int amount) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "INSERT INTO borrowrecord(id,bookId,studentId,borrowdate,borrowAmount) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);
            st.setInt(2,bid);
            st.setInt(3,sid );
            st.setDate(4,new Date(new java.util.Date().getTime()) );
            st.setInt(5,amount);
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
    public boolean ReturnBooks(int sid, int bid) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "UPDATE borrowrecord set returndate= ? where studentId = ? and bookId = ?  ";
            PreparedStatement st = con.prepareStatement(sql);

            st.setDate(1, new Date(new java.util.Date().getTime()));
            st.setInt(2, sid);
            st.setInt(3, bid);
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
    public List<BorrowRecord> SelectBorrowRecord(int bid) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM borrowrecord WHERE bookid=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, bid);
            List<BorrowRecord> list = new ArrayList<BorrowRecord>();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BorrowRecord borrowRecord= new BorrowRecord(rs.getInt("Id"),
                        rs.getInt("bookId"),
                        rs.getInt("studentId"),
                        rs.getDate("borrowdate"),
                        rs.getDate("returndate"),
                        rs.getInt("borrowAmount"));

                list.add(borrowRecord);
            }
            return list;
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
}
