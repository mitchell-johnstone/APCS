package PartnerProgram;
/**
 * Class "FlatScreen".
 * Develop toString and equals methods for class.
 */
public class FlatScreen
{
    private int diagonal; // &#39;instance&#39; fields
    private String brand;
    public FlatScreen() // default Constructor
    { diagonal = 34 ;
        brand = "generic";}
    FlatScreen (int d, String name) // Directly assigns instance variables
    { diagonal = d;
        brand = name; }
    public void upgrade(int i) // &#39;Mutator" or Modifier method
    { diagonal += i; }
    int getDiagonal () // "Accessor" method
    { return diagonal; }
    public String getName ()
    { return brand; }
    public String toString() // display of FlatScreen object
    { return brand + " diagonal = " + diagonal; }
    public boolean equals (Object s) // FlatScreen "equality" defined
    {
            FlatScreen set = (FlatScreen) s; // cast Object to Class type

            return (this.getDiagonal() == set.getDiagonal() && this.getName().equals(set.getName()));
    }
// public boolean equals ( Object s) // direct way without local boolean variable
// { FlatScreen set = (FlatScreen) s;
// return (( this.getDiagonal() == set.getDiagonal() )
// &amp;&amp; this.getName().equals(set.getName() ));
// }
}