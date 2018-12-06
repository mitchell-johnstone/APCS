package Unit10;

public class Executive extends Manager {
    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    public String toString(){
        return super.name + " gets a salary of $" + super.salary + " and is the Executive";
    }
}
