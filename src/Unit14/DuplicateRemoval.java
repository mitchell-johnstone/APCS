package Unit14;

import java.util.*;
import java.util.Random;

public class DuplicateRemoval {
    public static void main(String[] args) {
//        Random r = new Random();
        int[] numbers = {2,2,7,1,9,5,5,10,1,6};
        for (int i: numbers) System.out.print(i + ", ");
        System.out.println();
        int[] duplicateFreeByFrequency = frequencyDuplicates(numbers);
        for (int i: duplicateFreeByFrequency) System.out.print(i + ", ");
        System.out.println();
        int[] duplicateFreeBySort = sortedDuplicates(numbers);
        for (int i: duplicateFreeBySort) System.out.print(i + ", ");
        System.out.println();
    }

    public static int[] frequencyDuplicates(int[] a){
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();
        for(int i: a){
            int index = -1;
            for(int j = 0; j<values.size() && index == -1; j++){
                if( values.get(j) == i) index = j;
            }
            if(index == -1){
                values.add(i);
                frequency.add(1);
            }
            else frequency.set(index,frequency.get(index)+1);
        }
        ArrayList<Integer> nonDuplicates = new ArrayList <>();
        for(int i = 0; i<values.size();i++){
            if(frequency.get(i)<2)nonDuplicates.add(values.get(i));
        }
        a = new int[nonDuplicates.size()];
        for(int i = 0; i<a.length; i++){
            a[i] = nonDuplicates.get(i);
        }
        return a;
    }

    public static int[] sortedDuplicates(int[] a){
        Arrays.sort(a);
        int numberOfSolos =a.length;
        boolean wasDuplicate = false;
        for(int i = 1; i<a.length; i++){
            if(a[i]==a[i-1]){
                a[i-1]=-1;
                wasDuplicate = true;
                numberOfSolos--;
            } else if(wasDuplicate){
                a[i-1] = -1;
                wasDuplicate = false;
                numberOfSolos--;
            }
        }
        int[] nonDuplicates = new int[numberOfSolos];
        int index = 0;
        for(int i: a){
            if(i!=-1) {
                nonDuplicates[index] = i;
                index++;
            }
        }
        return nonDuplicates;
    }
}
