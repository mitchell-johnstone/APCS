package Unit14;

import java.util.ArrayList;
import java.util.Collections;
// Short example using sort method of ArrayList class
// Develop a method to determine &quot;median&quot; value of ArrayList
// (make sure it works for both even and odd lenghts)
public class ArrayListSort
{
    public static void main (String[] args)
    {
// remember &#39;Wrapper&#39; class required to treat primitive as object
        ArrayList <Double> gpa = new ArrayList <Double> ();
        gpa.add(3.45);
        gpa.add(3.78);
        gpa.add(3.66);
        gpa.add(3.84);
        System.out.print(gpa); // print ArrayList
        System.out.println();
        Collections.sort(gpa); // ArrayLists may be sorted with
// SORT method from &quot;Collections&quot; class
        System.out.print(gpa);

        int starting = 0;
        int ending = gpa.size()-1;
        while(starting+1<ending){
            starting++;
            ending--;
        }
        double median = (gpa.get(starting)+gpa.get(ending))/2.0;
        System.out.println("\n" + median);
    }
}