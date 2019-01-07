package Unit13;

public class P2 {
    public static void main(String[] args) {
        Sentence m = new Sentence("Mitchell");
        System.out.println(m.getSentence());
        m.reverse(2,m.length);
        System.out.println(m.getSentence());
    }
}
