package LinkedList;

public class MagazineRack {
    public static void main(String[] args) { // create MagazineList object
        MagazineList rack = new MagazineList();
        rack.add(new Magazine("Time")); // add magazines to list
        rack.add(new Magazine("Sports Illustrated"));
        rack.add(new Magazine("National Geographic"));
        System.out.println(rack);
        rack.addFirst(new Magazine("HEY"));
        System.out.println(rack);
        rack.add(new Magazine("Mental Floss"));
        System.out.println(rack);
        rack.remove(2);
        System.out.println(rack);
        rack.removeLast();
        System.out.println(rack);
        rack.add(new Magazine("Car and Driver"), 1); // insert magazines
        rack.add(new Magazine("People"), 3);
        System.out.println(rack);
        rack.removeFirst(); // remove current first magazine
        System.out.println(rack);
        rack.add(new Magazine("Newsweek"), 2);
        System.out.println(rack);
        System.out.println("final length = " + rack.size());
    }
}