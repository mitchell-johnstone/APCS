package Unit09;

public class PersonMeasurer implements Measurer{
    public double measure(Object object){
        Person person = (Person) object;
        return person.getHeight();
    }
}
