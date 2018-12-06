package Unit10;

public class SalariedWorker extends Worker {
    double lastPay;
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    public double computePay(int hours) {
        lastPay = 40*super.salaryRate;
        return lastPay;
    }

    public String toString() {
        return super.toString() + lastPay +" last payment";
    }
}
