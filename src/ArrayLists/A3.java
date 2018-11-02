package ArrayLists;

import java.util.ArrayList;

public class A3 {
    public static void main(String[] args) {
        ArrayList<StudentIQ> classroom = new ArrayList <>();
        classroom.add(new StudentIQ("Mitchell"));
        classroom.add(new StudentIQ("Leighton"));
        classroom.add(new StudentIQ("Nhut"));
        classroom.add(new StudentIQ("Gabe"));
        int sum = 0;
        for(StudentIQ studentIQ : classroom){
            sum += studentIQ.getIQ();
            System.out.println(studentIQ.getName() + " " + studentIQ.getIQ());
        }
        System.out.println("Average IQ " + (sum/(double)classroom.size()));
        int total = 0;
        for(StudentIQ studentIQ : classroom){
            if(studentIQ.getIQ()>120){
                total++;
            }
        }
        System.out.println("there were " + total + " people with IQ's over 120.");
        for (int i = 0; i < classroom.size(); i++) {
            if(classroom.get(i).getIQ()%2==0){
                classroom.remove(i);
                i--;
            }
        }
        System.out.println("Same list, but without even IQs");
        for(StudentIQ studentIQ : classroom){
            System.out.println(studentIQ.getName() + " " + studentIQ.getIQ());
        }
    }
}
