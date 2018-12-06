package Unit10;
/**
 *  Inheritance:  how a new class is created from an existing one
 *   Original class:  called the parent class, superclass or base class
 */
public class Student
{
    private String name;
    private int numCourses;
    
    public Student (String studentName, int courses)
    {   name = studentName;
        numCourses = courses; }
    
    public void addCourse(int n)            // superclass (parent) method
    {   numCourses+=n; }
    
    public void changeName(String n)        // superclass (parent) method
    {   name = n;   }
       
    public String toString()
    { String result = "Student name: " + name + "\n";
      result += "Number of courses: " + numCourses;
      return result;   }
    }