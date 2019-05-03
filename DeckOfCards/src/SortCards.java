import java.util.Comparator;

public class SortCards implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return (o1.hashCode() - o2.hashCode());
    }
}
