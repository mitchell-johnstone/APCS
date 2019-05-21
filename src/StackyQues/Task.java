package StackyQues;

public class Task implements Comparable
{
    private String name;
    private int priority;
    public Task (String taskName) // task without priority
    {
        name= taskName;
        priority = 0;
    }
    public Task (String taskName, int pri ) // task with assigned priority
    {
        name = taskName;
        priority = pri;
    }
    public int getPriority()
    { return priority; }

    public String getName()
    { return name ; }

    public String toString()
    { if (priority > 0 )
        return name + " " + priority;
    else return name; }

    public int compareTo (Object t) // compare task according to priority
    {
        if ( priority < ((Task)t).getPriority() )
            return -1;
        else if ( priority == ( (Task)t).getPriority() )
            return 0;
        else
            return 1;
    }
}