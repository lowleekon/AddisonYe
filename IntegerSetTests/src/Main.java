public class Main {
    public static void main(String[] args) {
        IntegerSet mySet = new IntegerSet();
        mySet.insert(3);
        mySet.remove(3);
        mySet.get();
        System.out.println(mySet.size());
        System.out.println(mySet.contains(3));
    }
}
