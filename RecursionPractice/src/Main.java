import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Node> nodes = new ArrayList<>();

    public static void setup() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Tree.txt"));
        while(scan.hasNextLine()){
            String[] temp = scan.nextLine().split(" ");
            int id = Integer.parseInt(temp[0]);
            int left = Integer.parseInt(temp[1]);
            int right = Integer.parseInt(temp[2]);
            nodes.add(new Node(id,left,right));
        }
    }

    public static int nodeFinder(ArrayList<Node> nodes, int n){
        for (Node o : nodes){
            if(o.id == n){
                return nodes.indexOf(o);
            }
        }
        return 0;
    }

    public static void leafFinder(ArrayList<Node> nodes, int n){
        if(nodes.get(n).checkEnd()){
            System.out.println(nodes.get(n).id);
        }
        else{
            if (nodes.get(n).left != 0) {
                leafFinder(nodes, nodeFinder(nodes, nodes.get(n).left));
            }
            if (nodes.get(n).right != 0) {
                leafFinder(nodes, nodeFinder(nodes, nodes.get(n).right));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        setup();
        leafFinder(nodes, 0);
    }
}
