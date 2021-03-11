package librarysystem.fei.controllers;


import librarysystem.fei.entities.Book;
import librarysystem.fei.repositories.interfaces.IBookRepository;

import java.util.List;

public class BookController {
    private final IBookRepository bookrepo;

    public BookController(IBookRepository bookrepo) {
        this.bookrepo = bookrepo;
    }
    public String createBook(int id,String name,String author,int pages,String isbn,int amount){
              Book book = new Book(id,name,author,pages,isbn,amount);
              boolean created = bookrepo.createBook(book);
        return (created ? "Book was created!" : "Book creation was failed!");
    }
    public String getBookById(int id) {
        Book book = bookrepo.getBookById(id);

        return (book == null ? "Book was not found!" : book.toString());
    }
    public String getBookByName(String name) {
        Book book = bookrepo.getBookByName(name);

        return (book == null ? "Book was not found!" : book.toString());
    }
    public String getBookByAuthor(String author) {
        Book book = bookrepo.getBookByAuthor(author);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String getAllBook() {
        List<Book> books = bookrepo.getAllBook();

        return books.toString();
    }
    public String deleteBook(int id){
        boolean delete = bookrepo.deleteBook(id);
        return (delete ? "Book was deleted!" : "Book delete was failed!");
    }
}

