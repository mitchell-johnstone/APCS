package Graphics;

//Random + Click

import java.awt.*;

import javax.swing.JOptionPane;

import java.util.Random;        // library for Random Number generators



/**

* Art + Click

* This class opens a Canvas window, fills it with a black

* background, and draws various geometric shapes using Canvas class.

*  

* CSTI, Summer 2006 Core Canvas class

*

* Nicolet High School, 2006-07

* @additional author Brian Due

*/

public class ArtClick

{

public static void main( String[] args )

{

 // Set up the canvas.

 int windowWidth = 1000;

 int windowHeight = 500;

 int kolor, whereX, whereY, across;

 int sizeW, sizeH;

                                               //  Make a 'canvas'

 Canvas myCanvas = new Canvas("Mouse Clicks and Random Applications");

                            

 myCanvas.setSize(windowWidth, windowHeight);  // set the size of window screen

 myCanvas.setVisible(true);

  myCanvas.setInkColor (Color.black);             

 myCanvas.drawFilledRectangle( 0,0,1000,500);

 //myCanvas.fillBackground(Color.black);

 

 myCanvas.setInkColor (Color.white);             // printing strings on screen

 myCanvas.drawString("Welcome to some Great Graphics!",60,80);

 myCanvas.pause(1000);

 

 System.out.println("Click Once on the Canvas and Look for the Pixel!");

 Point pix = myCanvas.waitForClick ();   // create a 'point' object

 myCanvas.drawPoint( pix );      // method "drawPoint" draws the mouse-clicked point

 

 System.out.println("You clicked on pixel (" + pix.getX() + ", " + pix.getY() + ")");

 

 System.out.println("Click once, move mouse, click again...to make line.");

 Point aClick = myCanvas.waitForClick ();    // click for a point

 Point bClick = myCanvas.waitForClick ();    // click for point #2

 

 myCanvas.setInkColor (Color.orange);

 myCanvas.drawLine( aClick, bClick );        // drawLine method w/ Point parameters

 

 myCanvas.pause(2000);

 

 

 Random r = new Random(); // define a variable 'r' as a random value 

 

 myCanvas.setInkColor (Color.white);

 myCanvas.drawString("Click three times for random white ovals",100,150);

 int count=0;

 while (count < 3)

 {

 Point place = myCanvas.waitForClick ();    // click for location

 sizeW = r.nextInt(221) + 30;  // rectangle width from 30 to 250

 sizeH = r.nextInt(71) + 5;    // rectangle width from 5 to 75

 myCanvas.setInkColor (Color.white);

 myCanvas.drawFilledOval((int)place.getX(), (int)place.getY(), sizeW, sizeH);

 count ++;}

 

 myCanvas.pause(1500);

 

 myCanvas.fillBackground(Color.black);

 for (int v = 10; v<800 ; v++)

     { myCanvas.setInkColor (Color.cyan);

      myCanvas.drawString("Are you ready for some random squares?",v,400);

      myCanvas.pause(3);

      myCanvas.eraseString("Are you ready for some random squares?",v-1,400);

     }

     

 int numSq = 75;

 while ( numSq >=0)

     { kolor = r.nextInt(4);  // create a variable 'kolor', return value of 0 to 3

      if (kolor == 0)

         myCanvas.setInkColor (Color.yellow);

      else if (kolor == 1)

         myCanvas.setInkColor (Color.red);

      else if (kolor == 2)

         myCanvas.setInkColor (Color.blue);

      else

         myCanvas.setInkColor (Color.green);

         

      whereX = r.nextInt(721)+10; // get a random number from 10 to 730

      whereY = r.nextInt(451)+10; // get a random number from 10 to 460

      across = r.nextInt(91)+5; // get a random number from 5 to 95

      

      myCanvas.drawRectangle(whereX, whereY, across, across);

      myCanvas.pause(40);

     numSq--;

     }
}
}