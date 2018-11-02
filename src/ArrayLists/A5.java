package ArrayLists;

import java.sql.Array;
import java.util.Collections;
import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        String [] words = new String[5];
        words[0]="Hey";
        words[1]="There";
        words[2]="Person";
        Scanner in = new Scanner(System.in);
        String test;
        do{
            System.out.println("what word to search? q to exit");
            test = in.next();
            boolean found = false;
            boolean open = false;
            int i;
            for(i = 0;!found&& i<words.length; i++){

                if(words[i]==null){
                    open = true;
                }else{
                    if(words[i].equalsIgnoreCase(test)){
                        found = true;
                    }
                }
            }
            if(found){
                System.out.println("found at " + (i-1));
            } else {
                if(open){
                    for (int j = 0; j < words.length && !found; j++) {
                        if(words[j]==null){
                            words[j] = test;
                            found = true;
                        }
                    }
                } else {
                    String[]tmp = words;
                    words = new String[tmp.length+1];
                    System.arraycopy(tmp,0,words,0,tmp.length);
                    words[words.length-1] = test;
                }
            }
            for (String s : words) {
                System.out.print( s + " , ");
            }
            System.out.println();
        } while(!test.equalsIgnoreCase("q"));

    }
}
