package sample;

public class Book {

    String id;
    String book_name;
    String name;

    public Book(String id, String book_name, String name){
        this.id = id;
        this.book_name = book_name;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name of Book: " + book_name + " Borrowed by: " + name;
    }
}
