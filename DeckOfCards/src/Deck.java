import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Deck {

    private ArrayList<Card> DOC = new ArrayList<>();

    Deck(){
        ArrayList<Card.Suite> suites = new ArrayList<>(
                Arrays.asList(Card.Suite.Diamond, Card.Suite.Clover, Card.Suite.Heart, Card.Suite.Spade));
        for (int s = 0; s < 4; s++){
            for (int v = 1; v < 14; v++){
                DOC.add(new Card(v, suites.get(s)));
            }
        }
    }

    void resetDeck(){
        DOC.sort(new SortCards());
    }

    void print(){
        for (Card c : DOC){
            System.out.println(c);
        }
    }

    void shuffle(){
        Collections.shuffle(DOC);
    }
}
