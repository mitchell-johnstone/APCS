package Unit09;
/**
   This program tests the DataSet class.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet bankData = new DataSet();

      bankData.add(new BankAccount(0));
      bankData.add(new BankAccount(10000));
      bankData.add(new BankAccount(2000));

      System.out.println("Average balance: " 
            + bankData.getAverage());
     // System.out.println("Expected: 4000");
      Measurable max = bankData.getMaximum();
      System.out.println("Highest balance: " 
         + max.getMeasure());
     // System.out.println("Expected: 10000");

       System.out.println();

      DataSet coinData = new DataSet();

      coinData.add(new Coin(0.25, "quarter"));
      coinData.add(new Coin(0.1, "dime"));
      coinData.add(new Coin(0.05, "nickel"));

      System.out.println("Average coin value: " 
            + coinData.getAverage());
     // System.out.println("Expected: 0.133");            
      max = coinData.getMaximum();
      System.out.println("Highest coin value: " 
            + max.getMeasure());
     // System.out.println("Expected: 0.25");

       System.out.println();

     DataSet dieData = new DataSet();

     Die d1 = new Die(); d1.roll();
     Die d2 = new Die(); d2.roll();
     Die d3 = new Die(); d3.roll();
     Die d4 = new Die(); d4.roll();

     dieData.add(d1);
     dieData.add(d2);
     dieData.add(d3);
     dieData.add(d4);

     System.out.println("Average die value: " + dieData.getAverage());
     max = dieData.getMaximum();
     System.out.println("Maximum die value: " + max.getMeasure());

       System.out.println();
     Measurer pm = new PersonMeasurer();
     DataSet2_0 peopleData = new DataSet2_0(pm);

     peopleData.add(new Person("Gabe", 65));
     peopleData.add(new Person("Leighton", 63));
     peopleData.add(new Person("Savir", 69));
     peopleData.add(new Person("Jake", 67));
     peopleData.add(new Person("Nhut", 68));

     System.out.println("Average height value: " + peopleData.getAverage());
     Person newMax = (Person) peopleData.getMaximum();
     System.out.println(newMax.getName() + " has biggest hieght with " + newMax.getHeight() + "in");
     Person min = (Person) peopleData.getMinimum();
     System.out.println(min.getName() + " has smalles hieght with " + min.getHeight() + "in");

       System.out.println();
   }
}

