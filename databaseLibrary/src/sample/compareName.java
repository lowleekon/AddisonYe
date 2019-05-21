package sample;

import java.util.Comparator;

public class compareName implements Comparator<Book> {
    public int compare(Book o1, Book o2){
        return o1.name.compareTo(o2.name);
    }
}
