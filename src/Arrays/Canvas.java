package Arrays;// Canvas + Click
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.security.Key;
import java.util.List;
import java.util.*;
import java.awt.geom.*;
import java.awt.event.*;

/**
 * Class Canvas - a class to allow for simple graphical
 * drawing on a canvas.
 *
 * @author Bruce Quig
 * @author Michael Kolling (mik)
 * @author Dave Musicant - made some local changes
 * @author Amy Csizmar Dalal - more minor local changes to allow for subclassing and Swing elements
 * @author Jeff Ondich - added setFontSize and getInkColor
 * @author David Liben-Nowell - renamed fillX() and height/width parameters;
 *                                              renamed wait() to pause()
 * @author Brian Due - triangle method
 * 2011
 */

public class Canvas {
    private JFrame frame;
    protected CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Color inkColor;
    private Image canvasImage;
    private Point clickedPoint;         // IAT
    private Point currentMousePoint;

    /**
     * Create a Canvas with default height, width and background color
     * (300, 300, white).
     *
     * @param title title to appear in Canvas Frame
     */
    public Canvas(String title) {
        this(title, 300, 300, Color.white);
    }

    /**
     * Create a Canvas with default title, height, width and background color
     * ("Canvas", 300, 300, white).
     */
    public Canvas() {
        this("Canvas", 300, 300, Color.white);
    }

    /**
     * Create a Canvas with default background Color (white).
     *
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height the desired height for the canvas
     */
    public Canvas(String title, int width, int height) {
        this(title, width, height, Color.white);
    }

    /**
     * Create a Canvas.
     *
     * @param title   title to appear in Canvas Frame
     * @param width   the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     */
    public Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.addMouseListener(new ShapeListener());  // IAT
        canvas.addMouseMotionListener(new MotionListener());
        canvas.addKeyListener(new KeyListener());
        backgroundColor = bgColor;
        inkColor = Color.black;
        frame.pack();

        // Added by acd:  this is a hack that will allow other components,
        // like buttons, to be added to the canvas and be visible.
        // basically, it's saying "when you repaint, don't fill the entire
        // canvas with the background color", i.e. leave the buttons and
        // stuff alone!
        canvas.setOpaque(false);
        // end of hack

        // Closes the window "neatly" when exiting the program.
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });

        if (graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(inkColor);
        }
    }

    /**
     * Sets the "pen" (outline) color for the Canvas.
     *
     * @param newColor The color to which to set the pen/drawing tool.
     */
    public void setInkColor(Color newColor) {
        inkColor = newColor;
        graphic.setColor(inkColor);
    }

    /**
     * Returns the current pen color.
     */
    public Color getInkColor() {
        return inkColor;
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     *
     * @param visible true if the canvas should appear on the screen, false otherwise
     */
    public void setVisible(boolean visible) {
        /*if (visible)
            frame.show();
        else
        frame.hide();*/
        //EDITED BY ACD:  show() and hide() are deprecated in
        //Java 1.5; replace with setVisible(boolean)
        frame.setVisible(visible);
    }

    /**
     * Provide information on visibility of the Canvas.
     *
     * @return true if canvas is visible, false otherwise
     */
    public boolean isVisible() {
        return frame.isVisible();
    }

    /**
     * Draw a given shape onto the canvas.
     *
     * @param shape the shape object to be drawn on the canvas
     */
    private void draw(Shape shape) {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * Fill the internal dimensions of a given shape with the current
     * foreground color of the canvas.
     *
     * @param shape the shape object to be filled
     */
    private void fill(Shape shape) {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Erase the whole canvas.
     */
    public void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erase a given shape's interior on the screen.
     *
     * @param shape the shape object to be erased
     */
    private void erase(Shape shape) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erases a given shape's outline on the screen.
     *
     * @param shape the shape object to be erased
     */
    private void eraseOutline(Shape shape) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws an image onto the canvas.
     *
     * @param image the Image object to be displayed
     * @param x     x coordinate for Image placement
     * @param y     y coordinate for Image placement
     * @return true if the image was completely and correctly loaded, false otherwise
     */
    private boolean drawImage(Image image, int x, int y) {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Draws a String on the Canvas.
     *
     * @param text the String to be displayed
     * @param x    x coordinate for text placement
     * @param y    y coordinate for text placement
     */
    public void drawString(String text, int x, int y) {
        graphic.drawString(text, x, y);
        canvas.repaint();
    }

    /**
     * Erases a String on the Canvas.
     *
     * @param text the String to be displayed
     * @param x    x coordinate for text placement
     * @param y    y coordinate for text placement
     */
    public void eraseString(String text, int x, int y) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws a "Point" object on the Canvas.
     *
     * @param p1 is a Point from mouse click
     *           Convert to its x and y coordinates and draw
     */
    public void drawPoint(Point p1) {
        graphic.drawLine((int) p1.getX(), (int) p1.getY(),
                (int) p1.getX(), (int) p1.getY());
        canvas.repaint();
    }


    /**
     * Draws a line on the Canvas.
     *
     * @param x1 x coordinate of start of line
     * @param y1 y coordinate of start of line
     * @param x2 x coordinate of end of line
     * @param y2 y coordinate of end of line
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        graphic.drawLine(x1, y1, x2, y2);
        canvas.repaint();
    }

    /**
     * * Draws a line on the Canvas, parameters two "points".
     *
     * @param p1 Point 1 clicked
     * @param p2 Point 2 clicked
     *           Convert each "point" object to its x, y coordinates
     */

    public void drawLine(Point p1, Point p2) {
        graphic.drawLine((int) p1.getX(), (int) p1.getY(),
                (int) p2.getX(), (int) p2.getY());
        canvas.repaint();
    }


    /**
     * Draws a rectangle on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void drawRectangle(int x, int y, int width, int height) {
        graphic.draw(new Rectangle(x, y, width, height));
        canvas.repaint();
    }

    /**
     * Draws a filled rectangle on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void drawFilledRectangle(int x, int y, int width, int height) {
        graphic.fill(new Rectangle(x, y, width, height));
        canvas.repaint();
    }

    /**
     * Draws a triangle on the Canvas.
     *
     * @param x1, y1    point2: x2, y2    point3: x3, y3
     * @parameters, three coordinate points
     */
    public void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        graphic.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        graphic.drawLine((int) x2, (int) y2, (int) x3, (int) y3);
        graphic.drawLine((int) x1, (int) y1, (int) x3, (int) y3);
        canvas.repaint();
    }

    /**
     * Draws a polygon on the Canvas.
     *
     * @param xs   array of x coordinates of polygon points
     * @param ys   array of y coordinates of polygon points
     * @param size the number of points (vertices) in the polygon
     */
    public void drawPolygon(int[] xs, int[] ys, int size) {
        graphic.draw(new Polygon(xs, ys, size));
        canvas.repaint();
    }

    /**
     * Draws a filled polygon on the Canvas.
     *
     * @param xs   array of x coordinates of polygon points
     * @param ys   array of y coordinates of polygon points
     * @param size the number of points (vertices) in the polygon
     */
    public void drawFilledPolygon(int[] xs, int[] ys, int size) {
        graphic.fill(new Polygon(xs, ys, size));
        canvas.repaint();
    }

    /**
     * Erases a rectangle on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void eraseRectangle(int x, int y, int width, int height) {
        eraseOutline(new Rectangle(x, y, width, height));
    }


    /**
     * Draws an oval on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void drawOval(int x, int y, int width, int height) {
        graphic.draw(new Ellipse2D.Double(x, y, width, height));
        canvas.repaint();
    }

    /**
     * Draws a filled oval on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void drawFilledOval(int x, int y, int width, int height) {
        graphic.fill(new Ellipse2D.Double(x, y, width, height));
        canvas.repaint();
    }

    /**
     * Erases an oval on the Canvas.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param width  width
     * @param height height
     */
    public void eraseOval(int x, int y, int width, int height) {
        eraseOutline(new Ellipse2D.Double(x, y, width, height));
    }


    /**
     * Sets the foreground color of the Canvas.
     *
     * @param newColor the new color for the foreground of the Canvas
     */
    private void setForegroundColor(Color newColor) {
        graphic.setColor(newColor);
    }

    /**
     * Returns the current color of the foreground.
     *
     * @return the color of the foreground of the Canvas
     */
    private Color getForegroundColor() {
        return graphic.getColor();
    }

    /**
     * Sets the background color of the Canvas.
     *
     * @param newColor the new color for the background of the Canvas
     */
    private void setBackgroundColor(Color newColor) {
        backgroundColor = newColor;
        graphic.setBackground(newColor);
    }

    /**
     * Fills in the Canvas (background) with the specified color.
     *
     * @param newColor the new color for the background of the Canvas
     */
    public void fillBackground(Color newColor) {
        Dimension size = canvas.getSize();
        backgroundColor = newColor;
        graphic.setColor(backgroundColor);
        graphic.fillRect(0, 0, size.width, size.height);
        graphic.setColor(inkColor);
    }

    /**
     * Returns the current color of the background
     *
     * @return the color of the background of the Canvas
     */
    private Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * changes the current Font used on the Canvas
     *
     * @param newFont new font to be used for String output
     */
    public void setFont(Font newFont) {
        graphic.setFont(newFont);
    }

    /**
     * Returns the current font of the canvas.
     *
     * @return the font currently in use
     **/
    public Font getFont() {
        return graphic.getFont();
    }

    /**
     * Sets the point size of the current font to the specified value.
     * The style and font family remain the same.
     *
     * @param newSize the new point size
     */
    public void setFontSize(int newSize) {
        Font f = graphic.getFont().deriveFont((float) newSize);
        setFont(f);
    }

    /**
     * Sets the size of the canvas.
     *
     * @param width  new width
     * @param height new height
     */
    public void setSize(int width, int height) {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);

        graphic = (Graphics2D) canvasImage.getGraphics();
        graphic.setColor(backgroundColor);
        graphic.fillRect(0, 0, width, height);
        graphic.setColor(inkColor);
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Returns the size of the canvas.
     *
     * @return The current dimension of the canvas
     */
    private Dimension getSize() {
        return canvas.getSize();
    }

    /**
     * Pauses for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     *
     * @param milliseconds the delay amount
     */
    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            // ignoring exception at the moment
        }
    }

    public Point waitForClick() {
        Point ret = null;
        do {
            ret = clickedPoint;
            pause(1);
        } while (ret == null);
        clickedPoint = null;
        return ret;
    }

    //bassically a wait for click, but instead whenever mouse moves

    public Point hoverPoint() {
        Point ret = null;
        do {
            ret = currentMousePoint;
            pause(1);
        } while (ret == null);
        currentMousePoint = null;
        return ret;
    }

    //returns the clicked point
    public Point getClickedPoint() {
        return clickedPoint;
    }

    //erases the point
    public void nullifyClickedPoint() {
        clickedPoint = null;
    }

    //gets the current hover point
    public Point getHoverPoint() {
        return currentMousePoint;
    }

    //erases the current hover point
    public void nullifyHoverPoint() {
        currentMousePoint = null;
    }

    //not super effective, but gets colors
    public Color getPixelColor(int x_, int y_) {
        Color tmp = null;
        try {
            Robot rb = new Robot();
            tmp = rb.getPixelColor(x_, y_);
//            System.out.println("Red=" + tmp.getRed() + " Blue=" + tmp.getBlue() + " Green=" + tmp.getGreen());
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        return tmp;
    }

    String currentKey = "";

    //gets and keys that were typed
    public String getKey() {
        return currentKey;
    }
    public void nullifyKey(){
        currentKey="";
    }
    //subclass for listening to the keyboard
    private class KeyListener implements java.awt.event.KeyListener {
        public void keyPressed(KeyEvent e) {currentKey = this.getKeyText(e.getKeyCode());}
        public void keyReleased(KeyEvent e) {currentKey = this.getKeyText(e.getKeyCode());}
        public void keyTyped(KeyEvent e) {currentKey = this.getKeyText(e.getKeyCode());}

        public String getKeyText(int keyCode) {
            if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9 || keyCode >= KeyEvent.VK_A
                    && keyCode <= KeyEvent.VK_Z) {
                return String.valueOf((char) keyCode);
            }
            switch (keyCode) {
                case KeyEvent.VK_COMMA:
                    return "COMMA";
                case KeyEvent.VK_PERIOD:
                    return "PERIOD";
                case KeyEvent.VK_SLASH:
                    return "SLASH";
                case KeyEvent.VK_SEMICOLON:
                    return "SEMICOLON";
                case KeyEvent.VK_EQUALS:
                    return "EQUALS";
                case KeyEvent.VK_OPEN_BRACKET:
                    return "OPEN_BRACKET";
                case KeyEvent.VK_BACK_SLASH:
                    return "BACK_SLASH";
                case KeyEvent.VK_CLOSE_BRACKET:
                    return "CLOSE_BRACKET";
                case KeyEvent.VK_ENTER:
                    return "ENTER";
                case KeyEvent.VK_BACK_SPACE:
                    return "BACK_SPACE";
                case KeyEvent.VK_TAB:
                    return "TAB";
                case KeyEvent.VK_CANCEL:
                    return "CANCEL";
                case KeyEvent.VK_CLEAR:
                    return "CLEAR";
                case KeyEvent.VK_SHIFT:
                    return "SHIFT";
                case KeyEvent.VK_CONTROL:
                    return "CONTROL";
                case KeyEvent.VK_ALT:
                    return "ALT";
                case KeyEvent.VK_PAUSE:
                    return "PAUSE";
                case KeyEvent.VK_CAPS_LOCK:
                    return "CAPS_LOCK";
                case KeyEvent.VK_ESCAPE:
                    return "ESCAPE";
                case KeyEvent.VK_SPACE:
                    return "SPACE";
                case KeyEvent.VK_PAGE_UP:
                    return "PAGE_UP";
                case KeyEvent.VK_PAGE_DOWN:
                    return "PAGE_DOWN";
                case KeyEvent.VK_END:
                    return "END";
                case KeyEvent.VK_HOME:
                    return "HOME";
                case KeyEvent.VK_LEFT:
                    return "LEFT";
                case KeyEvent.VK_UP:
                    return "UP";
                case KeyEvent.VK_RIGHT:
                    return "RIGHT";
                case KeyEvent.VK_DOWN:
                    return "DOWN";
                case KeyEvent.VK_MULTIPLY:
                    return "MULTIPLY";
                case KeyEvent.VK_ADD:
                    return "ADD";
                case KeyEvent.VK_SEPARATOR:
                    return "SEPARATOR";
                case KeyEvent.VK_SUBTRACT:
                    return "SUBTRACT";
                case KeyEvent.VK_DECIMAL:
                    return "DECIMAL";
                case KeyEvent.VK_DIVIDE:
                    return "DIVIDE";
                case KeyEvent.VK_DELETE:
                    return "DELETE";
                case KeyEvent.VK_NUM_LOCK:
                    return "NUM_LOCK";
                case KeyEvent.VK_SCROLL_LOCK:
                    return "SCROLL_LOCK";
                case KeyEvent.VK_F1:
                    return "F1";
                case KeyEvent.VK_F2:
                    return "F2";
                case KeyEvent.VK_F3:
                    return "F3";
                case KeyEvent.VK_F4:
                    return "F4";
                case KeyEvent.VK_F5:
                    return "F5";
                case KeyEvent.VK_F6:
                    return "F6";
                case KeyEvent.VK_F7:
                    return "F7";
                case KeyEvent.VK_F8:
                    return "F8";
                case KeyEvent.VK_F9:
                    return "F9";
                case KeyEvent.VK_F10:
                    return "F10";
                case KeyEvent.VK_F11:
                    return "F11";
                case KeyEvent.VK_F12:
                    return "F12";
                case KeyEvent.VK_F13:
                    return "F13";
                case KeyEvent.VK_F14:
                    return "F14";
                case KeyEvent.VK_F15:
                    return "F15";
                case KeyEvent.VK_F16:
                    return "F16";
                case KeyEvent.VK_F17:
                    return "F17";
                case KeyEvent.VK_F18:
                    return "F18";
                case KeyEvent.VK_F19:
                    return "F19";
                case KeyEvent.VK_F20:
                    return "F20";
                case KeyEvent.VK_F21:
                    return "F21";
                case KeyEvent.VK_F22:
                    return "F22";
                case KeyEvent.VK_F23:
                    return "F23";
                case KeyEvent.VK_F24:
                    return "F24";
                case KeyEvent.VK_PRINTSCREEN:
                    return "PRINTSCREEN";
                case KeyEvent.VK_INSERT:
                    return "INSERT";
                case KeyEvent.VK_HELP:
                    return "HELP";
                case KeyEvent.VK_META:
                    return "META";
                case KeyEvent.VK_BACK_QUOTE:
                    return "BACK_QUOTE";
                case KeyEvent.VK_QUOTE:
                    return "QUOTE";
                case KeyEvent.VK_KP_UP:
                    return "KP_UP";
                case KeyEvent.VK_KP_DOWN:
                    return "KP_DOWN";
                case KeyEvent.VK_KP_LEFT:
                    return "KP_LEFT";
                case KeyEvent.VK_KP_RIGHT:
                    return "KP_RIGHT";
                case KeyEvent.VK_DEAD_GRAVE:
                    return "DEAD_GRAVE";
                case KeyEvent.VK_DEAD_ACUTE:
                    return "DEAD_ACUTE";
                case KeyEvent.VK_DEAD_CIRCUMFLEX:
                    return "DEAD_CIRCUMFLEX";
                case KeyEvent.VK_DEAD_TILDE:
                    return "DEAD_TILDE";
                case KeyEvent.VK_DEAD_MACRON:
                    return "DEAD_MACRON";
                case KeyEvent.VK_DEAD_BREVE:
                    return "DEAD_BREVE";
                case KeyEvent.VK_DEAD_ABOVEDOT:
                    return "DEAD_ABOVEDOT";
                case KeyEvent.VK_DEAD_DIAERESIS:
                    return "DEAD_DIAERESIS";
                case KeyEvent.VK_DEAD_ABOVERING:
                    return "DEAD_ABOVERING";
                case KeyEvent.VK_DEAD_DOUBLEACUTE:
                    return "DEAD_DOUBLEACUTE";
                case KeyEvent.VK_DEAD_CARON:
                    return "DEAD_CARON";
                case KeyEvent.VK_DEAD_CEDILLA:
                    return "DEAD_CEDILLA";
                case KeyEvent.VK_DEAD_OGONEK:
                    return "DEAD_OGONEK";
                case KeyEvent.VK_DEAD_IOTA:
                    return "DEAD_IOTA";
                case KeyEvent.VK_DEAD_VOICED_SOUND:
                    return "DEAD_VOICED_SOUND";
                case KeyEvent.VK_DEAD_SEMIVOICED_SOUND:
                    return "DEAD_SEMIVOICED_SOUND";
                case KeyEvent.VK_AMPERSAND:
                    return "AMPERSAND";
                case KeyEvent.VK_ASTERISK:
                    return "ASTERISK";
                case KeyEvent.VK_QUOTEDBL:
                    return "QUOTEDBL";
                case KeyEvent.VK_LESS:
                    return "LESS";
                case KeyEvent.VK_GREATER:
                    return "GREATER";
                case KeyEvent.VK_BRACELEFT:
                    return "BRACELEFT";
                case KeyEvent.VK_BRACERIGHT:
                    return "BRACERIGHT";
                case KeyEvent.VK_AT:
                    return "AT";
                case KeyEvent.VK_COLON:
                    return "COLON";
                case KeyEvent.VK_CIRCUMFLEX:
                    return "CIRCUMFLEX";
                case KeyEvent.VK_DOLLAR:
                    return "DOLLAR";
                case KeyEvent.VK_EURO_SIGN:
                    return "EURO_SIGN";
                case KeyEvent.VK_EXCLAMATION_MARK:
                    return "EXCLAMATION_MARK";
                case KeyEvent.VK_INVERTED_EXCLAMATION_MARK:
                    return "INVERTED_EXCLAMATION_MARK";
                case KeyEvent.VK_LEFT_PARENTHESIS:
                    return "LEFT_PARENTHESIS";
                case KeyEvent.VK_NUMBER_SIGN:
                    return "NUMBER_SIGN";
                case KeyEvent.VK_MINUS:
                    return "MINUS";
                case KeyEvent.VK_PLUS:
                    return "PLUS";
                case KeyEvent.VK_RIGHT_PARENTHESIS:
                    return "RIGHT_PARENTHESIS";
                case KeyEvent.VK_UNDERSCORE:
                    return "UNDERSCORE";
                case KeyEvent.VK_FINAL:
                    return "FINAL";
                case KeyEvent.VK_CONVERT:
                    return "CONVERT";
                case KeyEvent.VK_NONCONVERT:
                    return "NONCONVERT";
                case KeyEvent.VK_ACCEPT:
                    return "ACCEPT";
                case KeyEvent.VK_MODECHANGE:
                    return "MODECHANGE";
                case KeyEvent.VK_KANA:
                    return "KANA";
                case KeyEvent.VK_KANJI:
                    return "KANJI";
                case KeyEvent.VK_ALPHANUMERIC:
                    return "ALPHANUMERIC";
                case KeyEvent.VK_KATAKANA:
                    return "KATAKANA";
                case KeyEvent.VK_HIRAGANA:
                    return "HIRAGANA";
                case KeyEvent.VK_FULL_WIDTH:
                    return "FULL_WIDTH";
                case KeyEvent.VK_HALF_WIDTH:
                    return "HALF_WIDTH";
                case KeyEvent.VK_ROMAN_CHARACTERS:
                    return "ROMAN_CHARACTERS";
                case KeyEvent.VK_ALL_CANDIDATES:
                    return "ALL_CANDIDATES";
                case KeyEvent.VK_PREVIOUS_CANDIDATE:
                    return "PREVIOUS_CANDIDATE";
                case KeyEvent.VK_CODE_INPUT:
                    return "CODE_INPUT";
                case KeyEvent.VK_JAPANESE_KATAKANA:
                    return "JAPANESE_KATAKANA";
                case KeyEvent.VK_JAPANESE_HIRAGANA:
                    return "JAPANESE_HIRAGANA";
                case KeyEvent.VK_JAPANESE_ROMAN:
                    return "JAPANESE_ROMAN";
                case KeyEvent.VK_KANA_LOCK:
                    return "KANA_LOCK";
                case KeyEvent.VK_INPUT_METHOD_ON_OFF:
                    return "INPUT_METHOD_ON_OFF";
                case KeyEvent.VK_AGAIN:
                    return "AGAIN";
                case KeyEvent.VK_UNDO:
                    return "UNDO";
                case KeyEvent.VK_COPY:
                    return "COPY";
                case KeyEvent.VK_PASTE:
                    return "PASTE";
                case KeyEvent.VK_CUT:
                    return "CUT";
                case KeyEvent.VK_FIND:
                    return "FIND";
                case KeyEvent.VK_PROPS:
                    return "PROPS";
                case KeyEvent.VK_STOP:
                    return "STOP";
                case KeyEvent.VK_COMPOSE:
                    return "COMPOSE";
                case KeyEvent.VK_ALT_GRAPH:
                    return "ALT_GRAPH";
            }

            if (keyCode >= KeyEvent.VK_NUMPAD0 && keyCode <= KeyEvent.VK_NUMPAD9) {
                char c = (char) (keyCode - KeyEvent.VK_NUMPAD0 + '0');
                return "NUMPAD" + c;
            }

            return "unknown(0x" + Integer.toString(keyCode, 16) + ")";
        }
    }

    //subclass for moving the mouse event.
    private class MotionListener implements MouseMotionListener
    {
        //based on the shape listener class below.
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e){
            currentMousePoint = e.getPoint();
            canvas.repaint();
        }
        protected class CanvasPane extends JPanel
        {
            public void paint(Graphics g)
            {
                g.drawImage(canvasImage, 0, 0, null);
                super.paint(g);
            }
        }
    }

    //sub class for the mouse buttons
    private class ShapeListener implements MouseListener
    {
        // based on Lewis, Loftus, Cocking, pages 431-434

        public void mousePressed (MouseEvent event)
        {
            clickedPoint = event.getPoint();
            // System.out.println ("Mouse Pressed at point x = " + clickedPoint.getX()
            //     + ", y = " + clickedPoint.getY() + ".");
            canvas.repaint();
        }

        public void mouseClicked (MouseEvent event) {}
        public void mouseReleased (MouseEvent event) {}
        public void mouseEntered (MouseEvent event) {}
        public void mouseExited (MouseEvent event) {}
    }
    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     * MODIFIED by acd:  changed visibility to protected (from private)
     * to allow subclassing (basically, so we can add mouse listeners to
     * the canvas), and added the call to super.paint() (an additional hack
     * to allow us to add components like buttons and menus to the canvas).
     */
    protected class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
            super.paint(g);
        }
    }
}

