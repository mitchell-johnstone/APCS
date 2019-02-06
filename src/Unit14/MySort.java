package Unit14;

public class MySort {
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 99, 1,83,89,23, 10, 8};
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
        int j;
        boolean sorted;
        for (int i = 0; i < (a.length-1)/2; i++) {
            sorted = true;
            for (j = i; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    sorted = false;
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
            if(sorted) break;

            sorted = true;
            System.out.println();
            for (int x : a) {
                System.out.print(x + ", ");
            }
            for (j--; j > i; j--) {
                if(a[j]<a[j-1]){
                    sorted = false;
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }
            }
            if(sorted) break;
            System.out.println();
            for (int x : a) {
                System.out.print(x + ", ");
            }
        }
        System.out.println();
        System.out.println();
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }
}
