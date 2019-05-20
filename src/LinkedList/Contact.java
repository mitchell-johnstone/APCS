package LinkedList;

public class Contact {
    private String name;
    private String phNumber;
    private int age;

    public Contact(String name, String phNumber, int age) {
        this.name = name;
        this.phNumber = phNumber;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPhNumber() {
        return phNumber;
    }

    @Override
    public String toString() {
        return  name +" " +
                phNumber.substring(0,3) + '-' + phNumber.substring(3,6) + '-' + phNumber.substring(6) +
                ", age:" + age;
    }
}
