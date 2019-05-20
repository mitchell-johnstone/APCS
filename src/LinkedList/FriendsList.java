package LinkedList;

import java.util.List;
import java.util.NoSuchElementException;

public class FriendsList {
    private ListNode first;
    private int count;

    public FriendsList() {
        first = null;
        count = 0;
    }

    public void addFirst(Object friendsNode){
        ListNode n = new ListNode(friendsNode,first);
        ListNode current = first;
        if(current == null) {
            first = new ListNode(friendsNode,null);
            first.setNext(first);
            count++;
            return;
        }

        while(current.getNext() != first){
            current = current.getNext();
        }

        current.setNext(n);

        first = n;
        count++;
    }

    public void add(Object friendsNode, int index){
        if(index<0 || index>size()) throw new IndexOutOfBoundsException();
        if(index == 0) {
            addFirst(friendsNode);
            return;
        }
        ListNode current = first;
        if(current == null) {
            first = new ListNode(friendsNode,null);
            first.setNext(first);
            count++;
            return;
        }

        for (int i = 0; i<index-1; i++){
            current = current.getNext();
        }
        ListNode n = new ListNode(friendsNode,current.getNext());
        current.setNext(n);
        count++;
    }

    public void add(Object friendsNode){
        ListNode n = new ListNode(friendsNode,first);
        ListNode current = first;
        if(current == null) {
            first = n;
            first.setNext(first);
            count++;
            return;
        }
        do{
            current = current.getNext();
        } while(current.getNext() != first);
        current.setNext(n);
        count++;
    }

    public Object removeFirst(){
        if(first == null) throw new NoSuchElementException();
        ListNode current = first;
        while(current.getNext()!=first){
            current = current.getNext();
        }
        ListNode lostNode = first;
        current.setNext(lostNode.getNext());
        first = current.getNext();
        count--;
        return lostNode;
    }

    public Object remove(int index){
        if(index < 0) throw new IndexOutOfBoundsException();
        if(index >= size()) return null;
        if(index == 0) return removeFirst();
        ListNode current = first;
        for (int i = 0; i<index-1; i++){
            current = current.getNext();
        }
        ListNode lostNode = current.getNext();
        current.setNext(lostNode.getNext());
        count--;
        return lostNode;
    }

    public Object removeLast(){
        return remove(size()-1);
    }

    /**methods for sorting**/
    public void sortName(){
        for(ListNode current1 = first; current1.getNext() != first; current1 = current1.getNext()){
            ListNode lowest = current1;
            FriendsNode original = (FriendsNode) current1.getValue();

            for(ListNode current2 = current1.getNext(); current2 != first; current2 = current2.getNext()) {
                if (((FriendsNode) lowest.getValue()).getName().compareTo(((FriendsNode) current2.getValue()).getName()) > 0) {
                    lowest = current2;
                }
            }
            current1.setValue(lowest.getValue());
            lowest.setValue(original);

        }
    }

    //selection sort
    public void sortAge(){

        ListNode o;
        for (int i = 0; i < size()-1; i++) {
            int min = i;
            for (int j = i+1; j < size()-1; j++) {
                if(getFriendIndex(min).getAge() > getFriendIndex(j).getAge()) min = j;
            }
            o = getNodeIndex(min);
            swap(i,min);
            if(i == 0) first = o;
        }
    }

    //selection sort
    public void sortNumOfFriends(){
        ListNode o;
        for (int i = 0; i < size()-1; i++) {
            int min = i;
            for (int j = i+1; j < size()-1; j++) {
                if(getFriendIndex(min).getNumOfFriends() > getFriendIndex(j).getNumOfFriends()) min = j;
            }
            o = getNodeIndex(min);
            swap(i,min);
            if(i == 0) first = o;
        }
    }

    public ListNode getNodeIndex(int index){
        if(index<0 || index >= size()) throw new IndexOutOfBoundsException();
        ListNode current = first;
        for(int i = 0; i<index; i++){
            current = current.getNext();
        }
        return current;
    }

    public void swap(int i1, int i2){
        int i3 = i1-1;
        int i4 = i2-1;
        i3 = i3==-1?size()-1:i3;
        i4 = i4==-1?size()-1:i4;

        ListNode before1 = getNodeIndex(i3);
        ListNode before2 = getNodeIndex(i4);

        ListNode at1 = getNodeIndex(i1);
        ListNode at2 = getNodeIndex(i2);

        before1.setNext(at2);
        before2.setNext(at1);

        ListNode destination = at1.getNext();
        at1.setNext(at2.getNext());
        at2.setNext(destination);

    }

    /**
     * Methods for searching for a given value
     * @return the index of the given value
     **/

    public FriendsNode getFriendIndex(int index){
        if(index<0 || index >= size()) throw new IndexOutOfBoundsException();
        ListNode current = first;
        for(int i = 0; i<index; i++){
            current = current.getNext();
        }
        return (FriendsNode)current.getValue();
    }

    public int searchForName(String name){
        for(int index = 0; index < size(); index++){
            FriendsNode c = getFriendIndex(index);
            if(c.getName().equals(name)){
                return index;
            }
        }
        return -1;
    }

    public int searchForAge(int age){
        for(int index = 0; index < size(); index++){
            FriendsNode c = getFriendIndex(index);
            if(c.getAge() == age){
                return index;
            }
        }
        return -1;
    }

    public int size(){
        return count;
    }

    public String toString(){
        String result = "";
        ListNode current = first;
        if(current == null){
            return "";
        }
//        System.out.println(count);
        do{
            result += current.getValue().toString() + "\n";
            current = current.getNext();
        } while (current != first);
        return result;
    }
}
