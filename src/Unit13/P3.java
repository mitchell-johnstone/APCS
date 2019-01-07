package Unit13;

public class P3 {
    public static void main(String[] args) {
        String s = "Hello!";
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(0,i) + s.substring(s.length()-1) + s.substring(i,s.length()-1);
        }
        System.out.println(s);
    }
}
