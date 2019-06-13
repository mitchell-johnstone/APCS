package FinalProject;

import java.util.Random;

public class FinalExamMitchellJohnstone {
    public static boolean D = false;
    public static void main(String[] args) {
        //initial set up
        int[][]Due = new int[5][5];
        Random r = new Random();

        //loading the array
        for (int i = 0; i < Due.length; i++) {
            for (int j = 0; j < Due[0].length; j++) {
                Due[i][j] = r.nextInt(21)+5;
            }
        }

        /**
         * PART 1
         */
        System.out.println("Original");
        print2D(Due);
        System.out.println();

        //A:
        int[] a = to1D(Due);
        a = sort(a);
        Due = from1D(a);
        System.out.println("Sorted");
        print2D(Due);

        //B
        int[] f = calcFreq(a);
        printFreq(f);

        //C
        System.out.println("\n");
        System.out.println("First Quartile:  " + (Due[0][1] + Due[1][1]) / 2.0 );
        System.out.println("Median:          " + Due[2][2]);
        System.out.println("Second Quartile: " + (Due[3][3] + Due[3][4]) / 2.0 );

        /**
         * Part 2
         */
        System.out.println("\n\n");
        System.out.println("!!!!!!!!!!!! ONTO PART 2 !!!!!!!!!!!!!\n");

        //load the arr with 5, 15, or 20
        resetPart2(Due);
        print2D(Due);

        //A
        check3(Due);

        //B
        D = false;
        check5(Due);

        //C
        shuffle(Due);
        System.out.println("\nShuffled array");
        print2D(Due);

        //D
        D = true;
        while (!check5(Due)){
            resetPart2(Due);
        }
        System.out.println("\nArray w/ both middle lines or both diagonals");
        print2D(Due);
    }

    public static void shuffle(int[][] a){
        Random r = new Random();
        for (int i = a.length-1; i >=0 ; i--) {
            for (int j = a[0].length-1; j >= 0; j--) {
                int x = r.nextInt(5);
                int y = r.nextInt(5);

                int tmp = a[i][j];
                a[i][j] = a[x][y];
                a[x][y] = tmp;
            }
        }
    }

    public static void check3(int[][] a){
        System.out.println("\nChecking runs of 3!!\n");
        //first, check H and V
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length-2; j++) {
                //Horizontal
                if(a[i][j] == a[i][j+1] && a[i][j] == a[i][j+2]){
                    System.out.println("Run of 3 found!");
                    System.out.println("Row " + i + ", Cols "+ j + " - " + (j+2));
                }

                //Vertical

                if(a[j][i] == a[j+1][i] && a[j][i] == a[j+2][i]){
                    System.out.println("Run of 3 found!");
                    System.out.println("Rows " + j + " - " + (j+2) + ", Col "+ i);
                }

            }
        }

        //finally, check diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(a[i][j] == a[i+1][j+1] && a[i][j] == a[i+2][j+2]){
                    System.out.println("\nDiagonal found in \\ formation");
                    System.out.println("Row " + i + " , Col " + j);
                    System.out.println("Row " + (i+1) + " , Col " + (j+1));
                    System.out.println("Row " + (i+2) + " , Col " + (j+2));
                }

                if(a[4-i][j] == a[3-i][j+1] && a[4-i][j] == a[2-i][j+2]){
                    System.out.println("\nDiagonal found in / formation");
                    System.out.println("Row " + (2-i) + " , Col " + (j+2));
                    System.out.println("Row " + (3-i) + " , Col " + (j+1));
                    System.out.println("Row " + (4-i) + " , Col " + j);

                }
            }
        }
    }

    //will return true if condition D is met
    // if both diagonals 1 number
    // OR if both center lines are 1 number
    public static boolean check5(int[][] a){
        if(!D)
            System.out.println("\n\nChecking 5 in a row!\n");
        boolean middleV = true;
        boolean middleH = true;
        boolean D1 = false;
        boolean D2 = false;

        boolean pass;
        for (int i = 0; i < a.length; i++) {
            //Horizontally
            int cVal = a[i][0];
            pass = true;
            for (int j = 1; j < a.length && pass; j++)
                if(cVal != a[i][j])
                    pass = false;


            if(pass && !D){
                System.out.println("5 in a row in Row " + i);
            }

            if(i == 2) middleH = pass;

            //Vertically
            cVal = a[0][i];
            pass = true;
            for (int j = 1; j < a.length && pass; j++)
                if(cVal != a[j][i])
                    pass = false;

            if(pass && !D){
                System.out.println("5 in a row in Col " + i);
            }

            if(i == 2) middleV = pass;
        }

        int cVal = a[0][0];
        pass = true;
        for (int i = 1; i < a.length && pass; i++)
            if(a[i][i] != cVal) pass = false;

        if(pass && !D)
            System.out.println("Diagonal 1 has a 5 in a row!");
        D1 = pass;



        cVal = a[4][0];
        pass = true;
        for (int i = 1; i < a.length && pass; i++)
            if(a[4-i][i] != cVal) pass = false;

        if(pass && !D)
            System.out.println("Diagonal 2 has a 5 in a row!");
        D2 = pass;


        return (middleH && middleV) || (D1 && D2);
    }

    public static void resetPart2(int[][] Due){
        Random r = new Random();
        for (int i = 0; i < Due.length; i++) {
            for (int j = 0; j < Due[0].length; j++) {
                Due[i][j] = 10 * (r.nextInt(3)) + 5;
            }
        }
    }

    //calculate the frequency of each number
    public static int[] calcFreq(int[] a){
        int[] f = new int[21];
        for(int i : a){
            f[i-5]++;
        }
        return f;
    }

    //Printing the frequency array
    public static void printFreq(int[] arr){
        System.out.println("\n\nFrequency Chart");
        System.out.println("------------------------");
        System.out.println("Any # not listed \nisn't present in chart");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0)
                System.out.println((i+5) + " : " + arr[i]);
        }
    }

    //printing a 2D array
    public static void print2D(int[][] arr){

        System.out.println("2D Array");
        System.out.println("------------------------");
        for(int[] a : arr){
            for (int i : a){
                if(i<10) System.out.print(i + "  | ");
                else System.out.print(i + " | ");
            }
            System.out.println();
            System.out.println("------------------------");
        }
    }

    //printing a 1D array
    public static void print1D(int[] arr){
        for (int i : arr){
            System.out.println(i);
        }
    }

    //turning 1D into 2D
    public static int[] to1D(int[][] arr){
        if(arr == null) return null;
        int len = arr.length * arr[0].length;
        int[] newArr = new int[len];
        for(int [] a : arr){
            for ( int i : a){
                newArr[--len] = i;
            }
        }
        return newArr;
    }

    //turning 2D into 1D
    public static int[][] from1D(int[] arr){
        if(arr == null) return null;
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = arr[i*5 + j];
            }
        }
        return a;
    }

    //Merge Sort Method
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
//            System.out.println();
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
}
