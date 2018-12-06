package Unit10;

public class Worker {
    String name;
    double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public String getName() {
        return name;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public double computePay(int hours){ return 0;}

    public String toString(){
        return name + " makes $" ;
    }
}
