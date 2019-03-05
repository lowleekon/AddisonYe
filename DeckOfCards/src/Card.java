public class Card implements Comparable<Card> {
    private int value;
    private Suite suite;

    public enum Suite{
        Diamond(1), Clover(2), Heart(3), Spade(4);
        private int multiplier;
        Suite(int multiplier){
            this.multiplier = multiplier;
        }
        public int getMultiplier(){
            return multiplier;
        }
    }

    Card(int value, Suite suite){
        this.value = value;
        this.suite = suite;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public String toString(){
        if (value == 11) {
            return suite.toString() + " Jack";
        }
        else if (value == 12){
            return suite.toString() + " Queen";
        }
        else if (value == 13){
            return suite.toString() + " King";
        }
        else{
            return suite.toString() + " " + value;
        }
    }
}
