package Unit10;

import java.util.ArrayList;

public class WorkerTester {
    public static void main(String[] args) {
        SalariedWorker savir = new SalariedWorker("Savir", 18);
        HourlyWorker nhut = new HourlyWorker("Nhut", 20);

        ArrayList<Worker> workers = new ArrayList <>();
        workers.add(savir);
        workers.add(nhut);

        System.out.println("they both worked 36 hours");
        for(Worker worker : workers){
            worker.computePay(36);
            System.out.println(worker);
        }

        System.out.println();
        System.out.println("they both worked 48 hours");

        for(Worker worker : workers){
            worker.computePay(48);
            System.out.println(worker);
        }
    }
}
