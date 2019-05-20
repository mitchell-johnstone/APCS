package LinkedList;

public class FriendsDriver {
    public static void main(String[] args) {
        FriendsList friendsList = new FriendsList();
        friendsList.add(new FriendsNode("mitchell","mitch",11,33));
        System.out.println("Added to end");
        System.out.println(friendsList);
        friendsList.add(new FriendsNode("jake","Joe",14,25));
        friendsList.add(new FriendsNode("john","Joe",125,300));
        System.out.println("Added 2 to end");
        System.out.println(friendsList);
        friendsList.add(new FriendsNode("hey","dude",42,3),2);
        System.out.println("Added to index 2");
        System.out.println(friendsList);
        friendsList.addFirst(new FriendsNode("leighton", "nerd", 2,0));
        System.out.println("Added to first index");
        System.out.println(friendsList);
        friendsList.sortAge();
        System.out.println("sorted by age");
        System.out.println(friendsList);
        friendsList.sortName();
        System.out.println("sorted by name");
        System.out.println(friendsList);
        friendsList.sortNumOfFriends();
        System.out.println("sorted by friends");
        System.out.println(friendsList);
        System.out.println("Searching");
        System.out.println("AGE : 2 = " + friendsList.searchForAge(2));
        System.out.println("AGE : 0 = " + friendsList.searchForAge(0));
        System.out.println("NAME: jake = " + friendsList.searchForName("jake"));
        System.out.println("NAME: JJ   = " + friendsList.searchForName("JJ"));
        System.out.println();
        friendsList.removeFirst();
        System.out.println("Removed first");
        System.out.println(friendsList);
        friendsList.remove(1);
        System.out.println("Removed index 1");
        System.out.println(friendsList);
        friendsList.removeLast();
        System.out.println("Removed last");
        System.out.println(friendsList);
    }
}
