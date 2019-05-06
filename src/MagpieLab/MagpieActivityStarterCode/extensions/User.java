package MagpieLab.MagpieActivityStarterCode.extensions;

public class User {
    private String firstName;
    private String lastName;
    private String nicknames;
    private String gender;
    private int age;

    public User() {
        firstName = "John";
        lastName = "Doe";
        nicknames = "Jonny";
        gender = "Attack Helicopter";
        age = 100;
    }

    public User(String firstName, String lastName, String nicknames, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nicknames = nicknames;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNicknames() {
        return nicknames;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
