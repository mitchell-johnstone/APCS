package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedContacts {
    public static void main(String[] args) {
        LinkedList<Contact> logbook = new LinkedList <Contact>();
        logbook.addFirst(new Contact ("joe", "2627894567", 15));
        System.out.println(logbook.getFirst());
        logbook.add(new Contact("Savir","4144692044", 33));
        logbook.add(new Contact("Leighton","4144392044", 33));
        ListIterator iterator = logbook.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "  --  ");
        }
        System.out.println();
        iterator = logbook.listIterator();
        while(iterator.hasNext()){
            Contact c = ((Contact)(iterator.next()));
            if(c.getAge() == 15){
                iterator.remove();
            }
        }
        iterator = logbook.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "  --  ");
        }
    }
}
