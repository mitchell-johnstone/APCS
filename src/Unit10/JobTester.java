package Unit10;

public class JobTester {
    public static void main(String[] args) {
        Executive leighton = new Executive("Leighton", 120000, "Everything");
        Manager mitchell = new Manager("Mitchell", 100000, "Coolness");
        Employee jake = new Employee("Jake", 80000);

        System.out.println(leighton);
        System.out.println(mitchell);
        System.out.println(jake);
    }
}
