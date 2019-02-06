package Unit14;

public class DoubleBubble {
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 99, 1,83,89,23, 10, 8};
        for (int i : a) {
            System.out.print(i + ", ");
        }
        a = merge(a);
        System.out.println();
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    private static int[] merge(int[] a){
        int[] a1 = new int[a.length/2];
        int[] a2 = new int[a.length-a.length/2];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a[a1.length+i];
        }
        a1 = bubble(a1);
        a2 = bubble(a2);

        int[] comb = new int[a1.length+a2.length];
        int index1=0, index2 = 0;
        while(index1<a1.length && index2<a2.length){
            if(a1[index1]<a2[index2]){
                comb[index1+index2] = a1[index1];
                index1++;
            }else{
                comb[index1+index2] = a2[index2];
                index2++;
            }
        }

        while(index1<a1.length){
            comb[index1+index2] = a1[index1];
            index1++;
        }

        while(index2<a2.length){
            comb[index1+index2] = a2[index2];
            index2++;
        }

        return comb;
    }

    private static int[] bubble(int[] a){
        boolean sorted;
        for (int i = 0; i < a.length-1; i++) {
            sorted = true;
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    sorted = false;
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
            if(sorted) return a;
        }
        return a;
    }
}
