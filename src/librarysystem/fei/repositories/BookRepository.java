package librarysystem.fei.repositories;


import librarysystem.fei.data.interfaces.IDB;
import librarysystem.fei.entities.Book;
import librarysystem.fei.repositories.interfaces.IBookRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository  implements IBookRepository {


    private final IDB db;

    public BookRepository(IDB db) {
        this.db = db;
    }
    @Override
    public boolean createBook(Book book) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "INSERT INTO book(id,name,author,pages,isbn,amount) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, book.getId());
            st.setString(2, book.getName());
            st.setString(3, book.getAuthor());
            st.setInt(4,book.getPages());
            st.setString(5, book.getIsbn());
            st.setInt(6,book.getAmount());
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
    public Book getBookById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,author,pages,isbn,amount FROM book WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("pages"),
                        rs.getString("isbn"),
                        rs.getInt("amount"));

                return book;
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
    public Book getBookByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,author,pages,isbn,amount FROM book WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("pages"),
                        rs.getString("isbn"),
                        rs.getInt("amount"));

                return book;
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
    public Book getBookByAuthor(String author) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,author,pages,isbn,amount FROM book WHERE author=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, author);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("pages"),
                        rs.getString("isbn"),
                        rs.getInt("amount"));

                return book;
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
    public List<Book> getAllBook() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,author,pages,isbn,amount FROM book";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("pages"),
                        rs.getString("isbn"),
                        rs.getInt("amount"));

                books.add(book);
            }

            return books;
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
    public boolean deleteBook(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "delete from book where id = ?";
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
