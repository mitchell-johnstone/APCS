package Unit10;

public class StudentFEARMember extends Student{
    String role;

    public StudentFEARMember(String studentName, int courses, String role) {
        super(studentName, courses);
        this.role = role;
    }

    public void crossTraining(String additionalRole){
        role += " + " + additionalRole;
    }

    public String toString(){
        return super.toString() + "\nRole On FEAR: " + role;
    }
}
