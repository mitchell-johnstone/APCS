package StackyQues;

import java.util.PriorityQueue;
public class PriorityToDos
{
    public static void main(String[] args)
    { // Priority queue of Task objects
        PriorityQueue<Task> tasks = new PriorityQueue<Task>();
// add Task to end of queue, with assigned priority
        tasks.add( new Task("Clean room", 4) );
        tasks.add( new Task("Do homework", 1) );
        tasks.add( new Task("Mow lawn", 3) );
        tasks.add( new Task("E-Mail Grandma", 2) );
        System.out.println ( tasks );
        System.out.println();
        System.out.println( tasks.remove() + ": check" ); // remove and return according to priority
        System.out.println( tasks.remove() + ": check" );
        System.out.println( "Next task ..." + tasks.peek() ); // peek at next Task by priority
        System.out.println( tasks );
        System.out.println();
        tasks.add( new Task("Laundry", 1 ) ) ;
        System.out.println( "Next task ..." + tasks.peek() );
        System.out.println (tasks );
    }
}
