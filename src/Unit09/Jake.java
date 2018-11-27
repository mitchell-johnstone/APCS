package Unit09;

public class Jake implements Speaker{
    private String name;
    private String attribute;

    public Jake(String name, String attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void speak(){
        System.out.println("Happy Friday Feast!");
        System.out.println("Welcome to the wonderful world of PID! ");
    }
}
