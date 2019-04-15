package pixLab.pixLab.classes;

import java.awt.*;

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

  public static void testMirrorHorizontal()
  {
    Picture motorcycle = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\blueMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.mirrorHorizontal();
    motorcycle.explore();
  }

  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms()
  {
    Picture snowman = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull()
  {
    Picture gull = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test the collage method */
  public static void testMyCollage()
  {
    Picture canvas = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\swan.jpg");
    swan.explore();
    swan.edgeDetectionUpDown(10);
    swan.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetectionBoth()
  {
    Picture swan = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\swan.jpg");
    swan.explore();
    swan.edgeDetectionBoth(10);
    swan.explore();
  }

  /** Method to test MirrorVerticalLeftToRight */
  public static void testMirrorVerticalLeftToRight()
  {
    Picture caterpillar = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  public static void testEncodeAndDecode(){
    Picture holder = new Picture ("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    Picture msg = new Picture ("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\msg.jpg");
    msg.explore();
    holder.explore();
    holder.encode(msg);
    holder.explore();
    holder.decode();
    holder.explore();
  }

  public static void testChromakey()
  {
    Picture bluemark = new Picture ("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\blue-mark.jpg");
    bluemark.explore();
    Color target = new Color(15,35,75);
    Picture p = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    bluemark.chromakey(p,target);
    bluemark.explore();
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
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorHorizontal();
//    testMirrorDiagonal();
//    testMirrorVerticalLeftToRight();
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//    testMyCollage();
//    testCopy();
//    testEdgeDetection();
//    testEdgeDetection2();
//    testEdgeDetectionBoth();
//    testChromakey();
    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
  }
}