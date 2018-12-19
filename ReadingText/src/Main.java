import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> exceptions = new ArrayList<>(Arrays.asList("e.g.", "Mr.", "Ms."));
        ArrayList<String> sentences = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String stringLine;
        while ((stringLine = br.readLine()) != null){
            if (!stringLine.isEmpty()) {
                ArrayList<String> line = new ArrayList<>(Arrays.asList(stringLine.split(" ")));
                while (line.size() > 1) {
                    if (line.get(1).substring(line.get(1).length() - 1).equals("]")){
                        ArrayList<String> temp = new ArrayList<>(Arrays.asList(line.get(1).split("")));
                        while ((temp.size() > 0) && (!temp.get(0).equals("."))){temp.remove(0);}
                        if (temp.size() != 0){
                            line.set(0, line.get(0) + " " + line.get(1));
                            line.remove(1);
                            sentences.add(line.get(0));
                            line.remove(0);
                        }
                    }
                    if (line.size() > 0) {
                        if (line.get(0).substring(line.get(0).length() - 1).equals(".") && !exceptions.contains(line.get(0))){
                            sentences.add(line.get(0));
                            line.remove(0);
                        }else {
                            if (line.get(1).substring(line.get(1).length() - 1).equals(".") && !exceptions.contains(line.get(1))) {
                                line.set(0, line.get(0) + " " + line.get(1));
                                line.remove(1);
                                sentences.add(line.get(0));
                                line.remove(0);
                            } else {
                                line.set(0, line.get(0) + " " + line.get(1));
                                line.remove(1);
                            }
                        }
                    }
                } } }
        for (String s : sentences){
            System.out.println(s);
        }
    }
}
