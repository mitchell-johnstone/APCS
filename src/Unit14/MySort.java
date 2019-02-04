package Unit14;

public class MySort {
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 23, 10, 8};
        for (int i : a) {
            System.out.print(i + ", ");
        }
        int j;
        for (int i = 0; i < (a.length-1)/2; i++) {
            for (j = i; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
            for (j--; j > i; j--) {
                if(a[j]<a[j-1]){
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }
            }
        }
        System.out.println();
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }
}
