package StackyQues;

import java.util.Queue;
import java.util.LinkedList;
public class ToDoQueue
{
    public static void main(String[] args)
    {
        Queue<Task> chores = new LinkedList<Task>(); // construct queue of "Task" objects
        chores.add( new Task("pack lunch") ); // add object to end of queue (enqueue)
        chores.add( new Task("brush teeth") );
        chores.add( new Task("make up bed") );
        System.out.println ( chores );
        System.out.println( chores.peek() ); // peek at front object in queue
        System.out.println();
        chores.remove(); // remove (and return) object at front (dequeue)
        chores.remove();
        chores.add( new Task("rake leaves") );
        System.out.println( chores );
        System.out.println( chores.peek() );
        System.out.println();
        chores.add( new Task("wash dishes") );
        chores.add( new Task("clean room") );
        while (! (chores.isEmpty()) ) // process queue until 'empty'
        { System.out.println( chores.remove() ); }
    }
}
