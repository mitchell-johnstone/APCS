package pixLab.pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  public static void testFixUnderwater()
  {
    Picture water = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  public static void testGrayscale()
  {
    Picture wall = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\wall.jpg");
    wall.explore();
    wall.grayScale();
    wall.explore();
  }
  public static void testNegate()
  {
    Picture beach = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\koala.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
//    testKeepOnlyRed();
//    testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
//    testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
//    testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}