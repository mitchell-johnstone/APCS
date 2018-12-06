package Unit10;
/**
 * The new class is called a child class or subclass.
 * The reserved word 'extends' indicates that the new class
 * is being created from the original class.
 */
public class StudentAthlete extends Student
{
    private String sport;
    
    public StudentAthlete ( String studentName, int courses, 
                            String sportName)
    { 
        super (studentName, courses);  // use constructor from parent class (super),
        sport = sportName;             // then initialize its own variables
    }
    
	public void changeSport(String sp)  // subclass (child) method
	{   sport = sp;}
    
    public String toString()
    {
        String result = super.toString();  // use parent class toString(),
        result += " \nSport: " + sport;    //   plus additional string
        return result;
    }
}