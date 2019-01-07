package Unit13;

public class P4 {
    public static void main(String[] args) {
        Sentence s = new Sentence("Mississippi!");
        boolean b = s.find("sip");
        System.out.println("Sentence is : Mississippi");
        System.out.println("Keyword is sip");
        System.out.println(b);
    }
}
