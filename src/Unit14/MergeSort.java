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
        if(a.length<2){
            return a;
        } else if(a.length<3){
            if(a[0]>a[1]){
                int tmp = a[0];
                a[0]=a[1];
                a[1]=tmp;
            }
            return a;
        } else{
            int[] a1 = new int[a.length/2];
            int[] a2 = new int[a.length-a.length/2];
            for (int i = 0; i < a1.length; i++) {
                a1[i] = a[i];
            }
            System.out.println();
            for (int i = 0; i < a2.length; i++) {
                a2[i]=a[i+a1.length];
            }
            a1 = sort(a1);
            a2 = sort(a2);
            int[] comb = new int[a1.length+a2.length];
            int aIndex = 0;
            int bIndex = 0;
            while(aIndex<a1.length&&bIndex<a2.length){
                comb[aIndex+bIndex] = a1[aIndex]<a2[bIndex]?a1[aIndex]:a2[bIndex];
                if(a1[aIndex]<a2[bIndex]){
                    aIndex++;
                }else{
                    bIndex++;
                }
            }
            while(aIndex<a1.length){
                comb[aIndex+bIndex]=a1[aIndex];
                aIndex++;
            }
            while(bIndex<a2.length){
                comb[aIndex+bIndex]=a2[bIndex];
                bIndex++;
            }
            return comb;
        }
    }
    /*private static int[] sort(int[] a, int[] b){
        if(a.length>1) {
            int[] a1 = new int[a.length/2];
            int[] a2 = new int[a.length-a.length/2];
            for (int i = 0; i < a1.length; i++) {
                a1[i]=a[i];
            }
            for (int i = 0; i < a2.length; i++) {
                a2[i]=a[i+a1.length];
            }
            a = sort(a1,a2);
        }
        if(b.length>1) {
            int[] b1 = new int[b.length/2];
            int[] b2 = new int[b.length-b.length/2];
            for (int i = 0; i < b1.length; i++) {
                b1[i]=b[i];
            }
            for (int i = 0; i < b2.length; i++) {
                b2[i]=b[i+b1.length];
            }
            b = sort(b1,b2);
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
    }*/
}
