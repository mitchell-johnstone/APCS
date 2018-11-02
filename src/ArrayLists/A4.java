package ArrayLists;

import java.util.Random;

public class A4 {
    public static void main(String[] args) {
        double[] arr1 = new double[4];
        double[] arr2 = new double[6];
        Random r = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextDouble()*10;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextDouble()*10;
        }
        System.out.println("Array 1:");
        print(arr1);
        System.out.println("Array 2:");
        print(arr2);

        double[] tmp = arr1;
        arr1=arr2;
        arr2=tmp;
        /*double[] tmp1 = new double[arr1.length];
        double[] tmp2 = new double[arr2.length];
        System.arraycopy(arr1,0,tmp1,0,arr1.length);
        System.arraycopy(arr2,0,tmp2,0,arr2.length);

//        System.out.println("\n" + arr1.length + "\n" + arr2.length);

        arr2 = new double[tmp1.length];
        arr1 = new double[tmp2.length];
//        System.out.println("\n" + arr1.length + "\n" + arr2.length);

        System.arraycopy(tmp1,0,arr2,0,tmp1.length);
        System.arraycopy(tmp2,0,arr1,0,tmp2.length);*/

        System.out.println("Array 1:");
        print(arr1);
        System.out.println("Array 2:");
        print(arr2);
    }

    public static void print(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void switchThem(double [] arr1, double [] arr2){

    }
}
