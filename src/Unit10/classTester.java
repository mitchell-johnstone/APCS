package Unit10;

public class classTester {
    public static void main(String[] args) {
        Interface i = new Interface("Speaker", "Speak");
        System.out.println(i.generateCode());

        System.out.println();

        Tester t = new Tester("HelloWorld");
        System.out.println(t.generateCode());

        System.out.println();

        General g = new General("Worker", "wage");
        System.out.println(g.generateCode());
    }
}
