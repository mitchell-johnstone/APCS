package Unit14;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {41, 15, 13, 23, 10, 8};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        a = sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    public static int[] sort(int[] a){
        return sort(a,null);
    }
    private static int[] sort(int[] a, int[] b){
        if(a.length>1) {
            int[] a1 = new int[a.length/2];
            int[] a2 = new int[a.length-a.length/2];
            System.arraycopy(a,0,a1,0,a1.length-1);
            System.arraycopy(a,a1.length,a2,0,a2.length-1);
            a = sort(a1,a2);
        }
        if(b.length>1) {
            int[] b1 = new int[b.length/2];
            int[] b2 = new int[b.length-a.length/2];
            System.arraycopy(b,0,b1,0,b1.length-1);
            System.arraycopy(a,b1.length,b2,0,b2.length-1);
            a = sort(b1,b2);
        }
        int[] comb = new int[a.length+b.length];
        int aIndex = 0;
        int bIndex = 0;
        while(aIndex<a.length&&bIndex<b.length){
            comb[aIndex+bIndex] = a[aIndex]<b[bIndex]?a[aIndex]:b[bIndex];
            if(a[aIndex]<b[bIndex]){
                aIndex++;
            }else{
                bIndex++;
            }
        }
        return comb;
    }
}
