package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Friend {

    String name;
    int age;

    Friend(String name, int age){
        this.name = name;
        this.age = age;
    }

    int compareToName(Friend f){
        ArrayList<String> first = new ArrayList<>(Arrays.asList(this.name.split(" ")[1].split("")));
        ArrayList<String> second = new ArrayList<>(Arrays.asList(f.name.split(" ")[1].split("")));
        if (first.size() > second.size()){
            for (int i = 0; i < (first.size() - second.size()); i ++) {
                second.add("a");
            }
        }else if (second.size() > first.size()){
            for (int i = 0; i < (second.size() - first.size()); i ++) {
                first.add("a");
            }
        }
        for (int i = 0; i < first.size(); i++){
            if (first.get(i).charAt(0) > second.get(i).charAt(0)){
                return 1;
            }else if (second.get(i).charAt(0) > first.get(i).charAt(0)){
                return -1;
            }
        }
        return 0;
    }

    int compareToAge(Friend f){
        return this.age - f.age;
    }

    public String toString() {
        return name;
    }
}
