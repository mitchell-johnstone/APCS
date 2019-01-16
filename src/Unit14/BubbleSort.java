package Unit14;
public class BubbleSort{
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 23, 10, 8};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        for (int i = a.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
    }
}