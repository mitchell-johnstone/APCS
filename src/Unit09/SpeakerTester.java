package Unit09;

public class SpeakerTester {
    public static void main(String[] args) {
        Speaker jazzy = new Jake("jake", "jazzy");
        Speaker pluto = new Dog(3, "Pluto");
        Speaker ed = new Singer(25, "pop");

        pluto.speak();
        System.out.println(((Dog)pluto).getWeight());
        System.out.println(((Dog)pluto).getName());
        System.out.println(pluto);

        System.out.println();

        ed.speak();
        System.out.println(((Singer)ed).getAge());
        System.out.println(((Singer)ed).getMusicType());

        System.out.println();

        jazzy.speak();
        System.out.println(((Jake)jazzy).getAttribute());
        System.out.println(((Jake)jazzy).getName());
    }
}
