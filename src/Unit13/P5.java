package Unit13;

public class P5 {
    public static void main(String[] args) {
        Sentence s = new Sentence("Mississippi");
        System.out.println(s.getSentence());
        String keyword = "sip";
        for (int i = 0; i < s.indexOf(keyword); i++) {
            System.out.print(" ");
        }
        System.out.println(keyword);
        System.out.println(s.indexOf(keyword));
        keyword = "Miss";
        System.out.println(s.getSentence());
        for (int i = 1; i < s.indexOf(keyword); i++) {
            System.out.print(" ");
        }
        System.out.println(keyword);
        System.out.println(s.indexOf(keyword));
    }
}
