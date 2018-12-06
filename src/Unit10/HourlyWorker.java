package Unit10;

public class HourlyWorker extends Worker{
    double total;
    public HourlyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    public double computePay(int hours) {
        total = 0;
        if(hours>40){
            total += hours-40;
            total *= 1.5 * super.salaryRate;
            hours =40;
        }
        total += hours * super.salaryRate;
        return total;
    }

    public String toString() {
        return super.toString() + total +" last payment";
    }
}
