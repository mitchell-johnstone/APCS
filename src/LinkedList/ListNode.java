package LinkedList;

// a node in the linked list
public class ListNode {
    private Object value;
    private ListNode next;

    // initialize the node
    public ListNode(Object initValue, ListNode initNext) {
        value = initValue;
        next = initNext;
    }

    public Object getValue() // return value of node
    {
        return value;
    }

    public ListNode getNext() // return reference of node
    {
        return next;
    }

    public void setValue(Object theNewValue) {
        value = theNewValue;
    }

    public void setNext(ListNode theNewNext) // set the next reference of node
    {
        next = theNewNext;
    }
}