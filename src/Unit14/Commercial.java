package Unit14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Commercial implements Comparable{
    private String product;
    private int sales;
    private int numberAds;
    public static Random r;

    public Commercial (String what_product){
        r = new Random();
        product = what_product;
        sales = r.nextInt(1000);
        numberAds = 0;
    }

    public void showCommercial(int num_ads){
        numberAds += num_ads;
        sales = r.nextInt(1000);
    }

    public int getSales() {
        return sales;
    }

    public int compareTo(Object otherCompany){
        assert otherCompany instanceof Commercial;
        if(((Commercial) otherCompany).getSales()==this.getSales()){
            return 0;
        } else if (((Commercial) otherCompany).getSales()>this.getSales()){
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Commercial{" +
                "product='" + product + '\'' +
                ", sales=" + sales +
                ", numberAds=" + numberAds +
                '}';
    }

    public static void main(String[] args) {
        Commercial[] commercials = new Commercial[5];
        commercials[0] = (new Commercial("Toys"));
        commercials[1] = (new Commercial("Gabes"));
        commercials[2] = (new Commercial("Computers"));
        commercials[3] = (new Commercial("Cars"));
        commercials[4] = (new Commercial("Pencils"));
        for (int i = 0; i < commercials.length; i++) {
            System.out.println(commercials[i] + " , ");
        }
        System.out.println();
        for (int i = 0; i < commercials.length; i++) {
            commercials[i].showCommercial(r.nextInt(10));
        }
        Arrays.sort(commercials);
        for (int i = 0; i < commercials.length; i++) {
            System.out.println(commercials[i] + " , ");
        }

        int starting = 0;
        int ending = commercials.length-1;
        while(starting+1<ending){
            starting++;
            ending--;
        }
        double median = (commercials[starting].getSales()+commercials[ending].getSales())/2.0;
        System.out.println("\nMedian Value of Sales is: " + median);
//        System.out.println(commercials);
    }
}
