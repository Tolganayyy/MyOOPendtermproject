package librarysystem.fei.entities;

public class Book {
    private int id;
    private String name;
    private String author;
    private int pages;
    private String isbn;
    private int amount;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", ISBN='" + isbn + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Book() {
    }

    public Book(int id, String name, String author, int pages, String isbn, int amount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
