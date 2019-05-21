package sample;

import java.util.Comparator;

public class compareID implements Comparator<Book> {
    public int compare(Book o1, Book o2){
        return o1.id.compareTo(o2.id);
    }
}
