public class IntegerSet {
    int[] intSet = new int[5];
    int size = 0;
    //requires: int
    //Modifies: this
    //Effects: inserts integer into set unless it's already there, in which case do nothing
    public void insert(Integer num){
        if (contains(num)){
            System.out.println("Integer is already in set!");
        }
        else {
            intSet[size] = num;
            size++;
        }
    }
    //requires: int
    //Modifies: this
    //Effects: removes integer from set
    public void remove(Integer num){
        size --;
        for (int i = 0; i < intSet.length; i++){
            if (intSet[i] == num){
                intSet[i] = 0;
            }
        }
    }
    //requires: none
    //Modifies: none
    //Effects: prints out size of set
    public int size(){
        return size;
    }
    //requires: int
    //Modifies: none
    //Effects: prints out whether the set contains the given int
    public boolean contains(Integer num){
        for (int i = 0; i < intSet.length; i++){
            if (intSet[i] == num){
                return true;
            }
        }
        return false;
    }
    //requires: none
    //Modifies: none
    //Effects: prints out the integer set
    public void get(){
        for (int i = 0; i < intSet.length; i++){
            System.out.println(intSet[i]);
        }
    }
}
