package sportsprogramming.week1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Task1Main {


    static char[] chars = new char[]{'a', 'b', 'c'};
    static int m = chars.length;
    static int sequenceLength = 3;
    static Set<String> sequences = new LinkedHashSet<String>();
    //todo где задать длину последовательности (использовать отд.класс?)
    static StringBuilder stringBuilder = new StringBuilder();


    public static void sort(int index){
        System.out.println("index: "+index);
        if (index == sequenceLength){
            System.out.println("stringBuilder 1: " + stringBuilder.toString());
            sequences.add(stringBuilder.toString());
            stringBuilder.delete(0, 1);
            System.out.println("stringBuilder 2: " + stringBuilder.toString());

            return;
        }


        for (int i = 0; i < m; i++) {
            System.out.println("inner char: "+chars[i]+", index: "+index);
            stringBuilder.append(chars[i]);
            sort(index+1);
        }
    }

    public static void print(){
        sequences.forEach(System.out::println);
    }


    public static void main(String[] args) {

        for (int i = 0; i < m; i++) {
            sort(0);
        }
        print();
    }
}
