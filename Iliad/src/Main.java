import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> punctuation = new ArrayList<>(Arrays.asList(".", ",", ":", ";", "\"", "?", "!", "-", "'", "(", ")"));
        TreeSet<String> uniqueWords = new TreeSet<>();
        FileReader fr = new FileReader("illiad.txt");
        BufferedReader br = new BufferedReader(fr);
        String stringLine;
        while ((stringLine = br.readLine()) != null){
            ArrayList<String> words = new ArrayList<>(Arrays.asList(stringLine.split(" ")));
            for (String s : words) {
                ArrayList<String> letters = new ArrayList<>(Arrays.asList(s.split("")));
                letters.removeIf(punctuation::contains);
                uniqueWords.add((String.join("", letters)).toLowerCase());
            }
        }
        for (String s : uniqueWords){
            System.out.println(s);
        }
    }
}
