package ArrayLists;

import java.util.ArrayList;

public class A1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList <>();
        strings.add("Mitchell");
        strings.add("doo");
        strings.add("mOzAmBiQuE");
        strings.add("hey there");
        System.out.println("Original array");
        System.out.println(strings.toString());
        System.out.println("Strings less than 4 in length");
        for (String s : strings) {
            if(s.length() < 4) {
                System.out.println(s);
            }
        }
        System.out.println("Changed first name to last");
        strings.set(strings.indexOf("Mitchell"), "Johnstone");
        System.out.println(strings.toString());
        System.out.println("Change all words beginning in lowercase to uppercase");
        for (int i = 0; i < strings.size(); i++) {
            String tmp = strings.get(i).substring(0,1);
            if(tmp.toLowerCase().equals(tmp)) strings.set(i,strings.get(i).toUpperCase());
        }
        System.out.println(strings.toString());
        int highestIndex = -1, lowestIndex = -1, highest = 0, lowest = 100;
        for (int i = 0; i<strings.size(); i++) {
            int length = strings.get(i).length();
            if(length>highest){
                highestIndex = i;
                highest = length;
            }
            if(length < lowest){
                lowestIndex = i;
                lowest = length;
            }
        }
        System.out.println("shortest string at " + lowestIndex);
        System.out.println("Longest string at " + highestIndex);
        System.out.println(strings.toString());
    }
}
