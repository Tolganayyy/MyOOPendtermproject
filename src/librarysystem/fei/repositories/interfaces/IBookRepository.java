package librarysystem.fei.repositories.interfaces;


import librarysystem.fei.entities.Book;

import java.util.List;

public interface IBookRepository {
    boolean createBook(Book book);
    Book getBookById(int id);
    Book getBookByName(String name);
    Book getBookByAuthor(String author);
    List<Book> getAllBook();
    boolean deleteBook(int id);

}
