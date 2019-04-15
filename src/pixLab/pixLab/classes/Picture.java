package pixLab.pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture() {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   *
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   *
   * @param height the height of the desired picture
   * @param width  the width of the desired picture
   */
  public Picture(int height, int width) {
    // let the parent class handle this width and height
    super(width, height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   *
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture) {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   *
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   *
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString() {
    String output = "Picture, filename " + getFileName() +
            " height " + getHeight()
            + " width " + getWidth();
    return output;

  }

  /**
   * Method to set the blue to 0
   */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }

  /**
   * Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right
   */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * Method to mirror image along verticle axis, right to left
   */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }


  /**
   * Method to flip a photo along the horizontal axis
   */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++) {
      for (int row = 0; row < height / 2; row++) {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  /**
   * Method to mirror an image
   * from top left corner to lower right
   */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel p1 = null;
    Pixel p2 = null;
    int height = pixels.length;
    int width = pixels[0].length;
    int smaller = width < height ? width : height;
    for (int diagonal = 0; diagonal < smaller; diagonal++) {
      for (int toSmaller = diagonal; toSmaller < smaller; toSmaller++) {
        p1 = pixels[diagonal][toSmaller];
        p2 = pixels[toSmaller][diagonal];
        p1.setColor(p2.getColor());
      }
    }
  }

  /**
   * Mirror just part of a picture of a temple
   */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++) {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  /**
   * Mirror a seagull on the beach
   */
  public void mirrorGull() {
    int mirrorPoint = 346;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 235; row < 320; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < mirrorPoint; col++) {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  /**
   * Mirror just part of a picture of a snowman
   */
  public void mirrorArms() {
    int mirrorPoint = 191;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 160; row < mirrorPoint; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 106; col < 295; col++) {

        leftPixel = pixels[row][col];
        rightPixel = pixels[2 * mirrorPoint - row][col];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
  }

  /**
   * @param fromPic
   * @param startRow
   * @param startCol
   * @param target
   */

  public void chromakey(Picture fromPic, int startRow, int startCol, Color target) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
                 toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        if (toPixel.colorDistance(target) < 50)
          toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void chromakey(Picture fromPic, Color target) {
    chromakey(fromPic, 0, 0, target);
  }

  public void chromakey(Picture fromPic) {
    chromakey(fromPic, Color.green);
  }

  /**
   * copy from the passed fromPic to the
   * specified startRow and startCol in the
   * current picture
   *
   * @param fromPic  the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic,
                   int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
                 toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /**
   * Method to create a collage of several pictures
   */
  public void createCollage() {
    Picture flower1 = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\flower2.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\collage.jpg");
  }

  public void myCollage() {
    Picture flower1 = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\caterpillar.jpg");
    flower1.mirrorDiagonal();
    flower1.mirrorHorizontal();
    flower1.mirrorVertical();
    Picture flower2 = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\robot.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\collage.jpg");
  }

  public void copy(Picture fromPic,
                   int startToRow, int startToCol,
                   int startFromRow, int startFromCol,
                   int endFromRow, int endFromCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = startFromRow, toRow = startToRow;
         fromRow < endFromRow &&
                 toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = startFromCol, toCol = startToCol;
           fromCol < endFromCol &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }


  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) >
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  /** Method to show large changes in color
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetectionUpDown(int edgeDist)
  {
    Pixel topPix = null;
    Pixel botPix = null;
    Pixel[][] pixels = this.getPixels2D();
    Color botColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0;
           col < pixels[0].length; col++)
      {
        topPix = pixels[row][col];
        botPix = pixels[row+1][col];
        botColor = botPix.getColor();
        if (topPix.colorDistance(botColor) >
                edgeDist)
          topPix.setColor(Color.BLACK);
        else
          topPix.setColor(Color.WHITE);
      }
    }
  }

  /** Method to show large changes in color
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetectionBoth(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel botPix = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        botPix = pixels[row+1][col];

        rightColor = rightPixel.getColor();
        botColor = botPix.getColor();
        if (leftPixel.colorDistance(rightColor) >
                edgeDist || leftPixel.colorDistance(botColor) > edgeDist )
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  /**
   * Method to encode a message into a picture
   * @param msg message to hide
   */
  public void encode(Picture msg)
  {
    Pixel[][] holderPixels = this.getPixels2D();
    Pixel[][] messagePixels = msg.getPixels2D();

    for(int row = 0; row<holderPixels.length; row++){
      for(int col = 0; col<holderPixels[0].length; col++){
        int red = holderPixels[row][col].getRed();
        if(red%2==1){
          red = red-1;
          holderPixels[row][col].setRed(red);
        }
        if(messagePixels[row][col].getRed()<50){
          holderPixels[row][col].setRed(red+1);
        }
      }
    }
  }

  public void decode()
  {
    Pixel[][] msgPixels = this.getPixels2D();

    for(int row = 0; row< msgPixels.length; row++){
      for(int col = 0; col<msgPixels[0].length; col++){
        int red = msgPixels[row][col].getRed();
        if(red%2==1){
          msgPixels[row][col].setColor(Color.black);
        } else {
          msgPixels[row][col].setColor(Color.white);
        }
      }
    }
  }
  /** Main method for testing - each class in Java can have a main
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("C:\\Programming\\Work\\APCS\\src\\pixLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /**
   * Method to keep only blue values in an image
   */
  public void keepOnlyBlue()
  {
    Pixel[][]pixels = this.getPixels2D();
    for(Pixel[] row : pixels){
      for(Pixel pix : row){
        pix.setGreen(0);
        pix.setRed(0);
      }
    }
  }

  public void negate()
  {
    Pixel[][]pixels = this.getPixels2D();
    for(Pixel[] row : pixels){
      for(Pixel pix : row){
        pix.setGreen(255-pix.getGreen());
        pix.setRed(255-pix.getRed());
        pix.setBlue(255-pix.getBlue());
      }
    }
  }

  public void grayScale()
  {
    Pixel[][]pixels = this.getPixels2D();
    for(Pixel[] row : pixels){
      for(Pixel pix : row){
        int ave = (pix.getBlue()+pix.getRed()+pix.getGreen())/3;
        pix.setColor(new Color(ave,ave,ave));
      }
    }
  }

  /** Method to only keep the pixels with blue over a value
   *
   * @param i value for blue to be over
   */
  public void keepBlueOverValue(int i)
  {
    Pixel[][]pixels = this.getPixels2D();
    for(Pixel[] row : pixels){
      for(Pixel pix : row){
        if(pix.getBlue()<i){
          pix.setColor(new Color(0));
        }
      }
    }
  }

  /**
   * Method to only keep the pixels with red under a value
   *
   * @param i value for red to be under
   */
  public void keepRedUnderValue(int i)
  {
    Pixel[][]pixels = this.getPixels2D();
    for(Pixel[] row : pixels){
      for(Pixel pix : row){
        if(pix.getRed()>i){
          pix.setColor(new Color(0));
        }
      }
    }
  }

  /**
   * method to fix the water picture to show the fisheeeeeeeeeeez
   */
  public void fixUnderwater()
  {
    keepBlueOverValue(155);
    keepRedUnderValue(23);
  }
} // this } is the end of class Picture, put all new methods before this
