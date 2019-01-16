package Unit14;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 23, 10, 8};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println();
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[minIndex]>a[j])minIndex = j;
            }
            int t = a[minIndex];
            a[minIndex] = a[i];
            a[i] = t;
            for (int l = 0; l < a.length; l++) {
                System.out.print(a[l]+", ");
            }
            System.out.println();
        }
    }
}
