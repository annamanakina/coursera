package sportsprogramming.week1;

import java.util.ArrayList;

public class Task1 {

    static int n=3, m=2;
    static int [] arr = new int[n];
    static int count = 0;

    static boolean [] used = new boolean[n+1];


    static void sort(int index){
        if (index == n){
            count++;
            print(arr);
           System.out.println("count: "+count);
           return;
        }

        for (int i = 1; i <= m; i++) {
            arr[index]=i;
            sort(index+1);
        }
    }

    static int[] chars = new int[]{-1, -1, -1, -1,-1};
    static boolean isFree = true;
    //static boolean[] flag = new boolean[5];

    static void sortChip(int index, boolean flag){

        if (index == chars.length){
            count++;
            print(chars);
            System.out.println("count: "+count);
            return;
        }

        for (int i = 0; i <= 1; i++) {
           /* if (used[i]) continue;

            arr[index]=i;
            used[i] = true;

            rearrangement(index+1);
            used[i] = false;*/

            System.out.println("i: "+i);
           /*- if (chars[i] == 0) {
                chars[index] = 1;
                System.out.println("if flag index: "+index);
                continue;
            }

            chars[index]=i;*/

            sortChip(index+1, flag);
            flag = true;
        }
    }


    /*task 2*/
    static void rearrangement(int index){

        if (index == n){
            count++;
            print(arr);
            //System.out.println("count: "+count);
            return;
        }

        //используем числа до размера переставноки
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            arr[index]=i;
            used[i] = true;

            rearrangement(index+1);
            used[i] = false;
        }
    }

    //не можем добавлять слагаемое меньше числа last
    //index - индекс в массиве, куда помещаем очередное слагаемое
    static ArrayList<Integer> list = new ArrayList<>(n);

    static void split(int index, int sum, int last){
        if (sum == n){
            count++;
            System.out.println("count: "+count);
            printList();
            return;
        }

        //n - сумма, которую хотим  набрать
        //sum - сумма, которую уже набрали
        //n-m разница, которую необходимо добрать

        for (int i=last; i <= n - sum; i++){
           list.add(index, i);
           split(index+1, sum+i, i);
           list.remove(index);
        }
    }

    static void printList(){
        for ( Integer number : list ) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
         // sort(0);
        //rearrangement(0);
       // split(0, 0, 1);
        sortChip(0, true);
    }
}
