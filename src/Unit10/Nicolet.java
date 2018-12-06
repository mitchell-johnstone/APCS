package Unit10;
/**
 *   Example with Parent class (Student) & Child class (StudentAthlete)
 */
public class Nicolet
{
	public static void main(String[]args)
	{
	    Student Tommy = new Student ("Tommy", 5);
	    StudentAthlete Zach = new StudentAthlete ("Zach",5,"Swimming");
	    
	    System.out.println(Tommy);
	    System.out.println();
	    
	    Tommy.addCourse(2);
	    Tommy.changeName("Sparky");
	    System.out.println(Tommy);
	    System.out.println();
	    
	    System.out.println(Zach);
	    System.out.println();
	    
	    Zach.addCourse(1);
	    Zach.changeSport("Football");
	    System.out.println(Zach);
	    System.out.println();

	    StudentFEARMember Gabe = new StudentFEARMember("Gabe", 7, "Programmer");

		System.out.println(Gabe);
        System.out.println();

        Gabe.addCourse(1);
        Gabe.crossTraining("Systems");
        System.out.println(Gabe);
        System.out.println();
	    
	   }
}