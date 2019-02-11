package Unit14;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class SearchComparison {
    public static void main(String[] args) {
        int[] randomNumbers = new int[100];
        Random r = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(100)+1;
            System.out.print(randomNumbers[i]+", ");
        }
        Scanner in = new Scanner(System.in);
        int searchVal=0;
        while(searchVal!=-1) {
            System.out.println("\nWhat value would you like to search for? enter -1 to close");
            searchVal = in.nextInt();
            if(searchVal!=-1) {
                //normal sort
                //first index will be the index value of the number
                //second index will be the number of comparisons.
                int[] resultOfSearch = regularSearch(randomNumbers, searchVal);
                if (resultOfSearch[0] != -1)
                    System.out.print("Number " + searchVal + "was found at index " + resultOfSearch[0] + " , ");
                else System.out.print("Number " + searchVal + "was not found. ");
                System.out.println(resultOfSearch[1] + " comparisons were made.\n");

                //binary sort
                Arrays.sort(randomNumbers);

                resultOfSearch = binarySearch(randomNumbers, searchVal);
                if (resultOfSearch[0] != -1)
                    System.out.print("Number " + searchVal + "was found at index " + resultOfSearch[0] + " , ");
                else System.out.print("Number " + searchVal + "was not found. ");
                System.out.println(resultOfSearch[1] + " comparisons were made.\n");
            }
        }
    }
    public static int[] binarySearch(int[] values, int searchVal){
        int low = 0;
        int high = values.length-1;
        int mid;
        int comparisons = 0;
        while(low<=high){
            mid = (low+high)/2;
            int diff = values[mid]-searchVal;
            comparisons++;

            if (diff==0){
                int[] result = {mid,comparisons};
                return  result;
            } else if (diff<0){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        int[] result ={-1,comparisons};
        return result;
    }
    public static int[] regularSearch(int[] values, int searchVal){
        int comparisons = 0;
        int index;
        for (index=0; index<values.length; index++) {
            comparisons++;
            if(values[index] == searchVal){
                int[] result = {index,comparisons};
                return result;
            }
        }
        int[] result = {-1,comparisons};
        return result;
    }
}
