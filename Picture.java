import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.util.function.Consumer;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /*
         * not needed but use it to show students the implicit call to super() child
         * constructors always call a parent constructor
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
     * Constructor that takes a picture and creates a copy of that picture
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
     * @return a string with information about the picture such as fileName, height
     *         and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
        return output;

    }

    public void popArt() {
        Pixel[][] pixels = this.getPixels2D();

        // top of the picture

            // left side

            // right side


        // bottom of the picture

            // bottom left side

            // bottom right side


    }

    /** Method to set the blue to 0 */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns
            for(int col = 0; col < width; col++) {
                // zero out all the blue
                pixels[row][col].setBlue(0);
            }
        }
    }

    /**
     * Method that keeps only the blue color - sets the red and green to zero
     */
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++){
            // traverse the cilumns
            for(int col = 0; col < width; col++){
                // zero out all the blue
                double ratio = (double)col/width;
                int 
                pixels[row][col].setRed(0 + (col/width));
                pixels[row][col].setGreen(0 + (col/width));
            }
        }
    }

    /** Method that keeps only the red color */
    public void keepOnlyRed() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns
            for(int col = 0; col < width; col++) {
                // zero out all the blue
                pixels[row][col].setRed(0);
            }
        }
    }

    /** Method that keeps only the green color */
    public void keepOnlyGreen() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns
            for(int col = 0; col < width; col++) {
                // zero out all the blue
                pixels[row][col].setGreen(0);
            }
        }
    }

    /** Method that negates the colors in the picture */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns
            for(int col = 0; col < width; col++) {
                Pixel pixel = pixels[row][col];
                // negate red, green, and blue
                pixel.setRed(255 - pixel.getRed());
                pixel.setGreen(255 - pixel.getGreen());
                pixel.setBlue(255 - pixel.getBlue());
            }
        }
    }

    /** Method that makes the picture all shades of gray */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns
            for(int col = 0; col < width; col++) {
                Pixel pixel = pixels[row][col];
                // calculate average of red, green, and blue
                int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                // set all colors in pixel to average
                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
            }
        }
    }

    /**
     * Method to fix pictures taken underwater
     */
    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        int height = pixels.length;
        int width = pixels[0].length;
        // loop through everything and reduce blue while bringing up red and green
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                // get the pixel
                Pixel pixel = pixels[row][col];
                // get the colors
                int red = (int)(pixel.getRed() * 7.3);
                int green = (int)(pixel.getGreen() * .7);
                int blue = (int)(pixel.getBlue() * 1);
                // adjust the colors
                pixel.setBlue(blue);
                pixel.setRed(red);
                pixel.setGreen(green);
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of the
     * picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        int width = pixels[0].length;
        for(Pixel[] row : pixels) {
            for(int col = 0; col < width / 2; col++) {
                // mirror the pixels
                Pixel leftPixel = row[col];
                Pixel rightPixel = row[width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of the
     * picture from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        int width = pixels[0].length;
        for(Pixel[] row : pixels) {
            for(int col = 0; col < width / 2; col++) {
                // mirror the pixels
                Pixel leftPixel = row[col];
                Pixel rightPixel = row[width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of
     * the picture from top to botttom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse HALF the rows
        for(int row = 0; row < height / 2; row++) {
            // traverse all of the columns
            for(int col = 0; col < width; col++) {
                Pixel topPixel = pixels[row][col];
                // max - current is how you get the reflection: (height - 1 - row)
                Pixel bottomPixel = pixels[height - 1  - row][col];
                // set the bottom pixel equal to the top pixel
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of
     * the picture from bottom to top
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse HALF the rows
        for(int row = 0; row < height / 2; row++) {
            // traverse all of the columns
            for(int col = 0; col < width; col++) {
                Pixel topPixel = pixels[row][col];
                // max - current is how you get the reflection: (height - 1 - row)
                Pixel bottomPixel = pixels[height - 1  - row][col];
                // set the bottom pixel equal to the top pixel
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /**
     * Mirror around a mirror positioned on the diagonal line from bottom left to
     * top right
     */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        // identify the height of the picture
        int height = pixels.length;
        // identify the width of the picture
        int width = pixels[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++) {
            // traverse the columns, only going across in proportion to how far down I'm going
            for(int col = 0; col < row; col++) {
                // mirror the pixels
                Pixel firstPixel = pixels[row][col];
                Pixel secondPixel = pixels[col][row];
                secondPixel.setColor(firstPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple() {
        Pixel[][] pixels = this.getPixels2D();
        int colMax = pixels[0].length - 1;
        for(int row = 30; row < 101; row++) {
            for(int col = 0; col < 256; col++) {
                Pixel leftPixel = pixels[row][col];
                Pixel rightPixel = pixels[row][colMax - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a snowman */
    public void mirrorArms() {
        Pixel[][] pixels = this.getPixels2D();
        int max1 = 194;
        int count = 0;
        for(int row = 156; row <= 202; row++) {
            for(int col = 101; col <= 170; col++) {
                Pixel pete = pixels[row][col];
                pixels[(max1-count)+40][col].setColor(pete.getColor());
            }
            count++;
        }
    }

    /** Mirror just the gull */
    public void mirrorGull() {
        Pixel[][] pixels = this.getPixels2D();
        int max1 = 347;
        int count = 0;
        for(int row = 233; row <= 327; row++) {
            for(int col = 233; col <= 347; col++) {
                Pixel birdy = pixels[row][col];
                pixels[row - 10][max1 - col].setColor(birdy.getColor());
            }
            count++;
        }
    }

    /**
     * Method to show large changes in color
     * 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {

        Pixel[][] originalPic = this.getPixels2D();
        // identify the height of the picture
        int height = originalPic.length;
        // identify the width of the picture
        int width = originalPic[0].length;
        // traverse the rows
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                // get the pixel
                Pixel pixel = originalPic[row][col];
                // get the colors
                int red = (int)(pixel.getRed() * 0);
                int green = (int)(pixel.getGreen() * .0);
                int blue = (int)(pixel.getBlue() * 0.6);
                // adjust the colors
                pixel.setBlue(blue);
                pixel.setRed(red);
                pixel.setGreen(green);
            }
        }

        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel diagonalPixel = null;
        // the one we're modifying:
        Pixel[][] pixels = originalPic;
        // store a backup of the original, unmodified pixels
        Picture swan = new Picture("swan.jpg");
        Pixel[][] original = swan.getPixels2D();
        // loop through all the rows. Stop one before the end
        for(int row = 0; row < pixels.length - 1; row++){
            // loop through all the columns. Stope one before the end
            for(int col = 0; col < pixels[0].length - 1; col++){
                // get the left pixel
                leftPixel = pixels[row][col];
                // get the right pixel. This is why we stop one early:
                rightPixel = pixels[row][col+1];
                // get bottom pixel
                bottomPixel = pixels[row+1][col];
                // get diagnonal pixel
                diagonalPixel = pixels[row+1][col+1];
                // TODO: compare more than two pixels against the given color distance
                if(leftPixel.colorDistance(rightPixel.getColor()) > edgeDist || leftPixel.colorDistance(bottomPixel.getColor()) > edgeDist
                || leftPixel.colorDistance(diagonalPixel.getColor()) > edgeDist) {
                    // WE FOUND AN EDGE! set the color to black
                    pixels[row][col].setColor(Color.BLACK);
                } else {
                    // Not an edge: set the color to white
                    pixels[row][col].setColor(Color.WHITE);
                }
            }
        }
    }

    /**
     * Method to show large changes in color
     * 
     * @param edgeDist the distance for finding edges
     */
    public void customEdgeDetection(int edgeDist) {
        
    }

    /** Method to create a collage of several pictures */
    public void createCollage() {
        Picture drippycheese = new Picture("drippycheesebru.jpg");
        Picture belladogdog = new Picture("bellarealpainting.jpg");
        Picture bOSNAIA = new Picture("bosniiaaaa.jpg");
        Picture grimaceMyBeloved = new Picture("drippace.jpg");
        this.copy(bOSNAIA, 0, 0);
        this.copy(drippycheese,0,0);
        this.copy(belladogdog,100,0);
        this.copy(drippycheese,200,0);
        Picture flowerNoBlue = new Picture(belladogdog);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(drippycheese,400,0);
        this.copy(belladogdog,500,0);
        this.mirrorVertical();
        this.copy(grimaceMyBeloved, 100, 180);
        this.write("collage.jpg");
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in the
     * current picture
     * 
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
                && toRow < toPixels.length; fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
                    && toCol < toPixels[0].length; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in the
     * current picture
     * 
     * @param fromPic      the picture to copy from
     * @param fromStartRow the row to start coping from in the from picture
     * @param fromStartCol the column to start copying from in the from picture
     * @param fromEndRow   the row to stop before in the from picture
     * @param fromEndCol   the column to stop before in the from picture
     * @param toStartRow   the row to start copying to
     * @param toStartCol   the column to start copying to
     */
    public void copy(Picture fromPic, int fromStartRow, int fromStartCol, int fromEndRow, int fromEndCol,
            int toStartRow, int toStartCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = fromStartRow, toRow = toStartRow; fromRow <= fromEndRow
                && toRow < toPixels.length; fromRow++, toRow++) {
            for (int fromCol = fromStartCol, toCol = toStartCol; fromCol <= fromEndCol
                    && toCol < toPixels[0].length; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Method to replace the blue background with the pixels in the newBack picture
     * 
     * @param newBack the picture to copy from
     */
    public void chromakey(Picture newBack) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = newBack.getPixels2D();
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth(); col++) {
                toPixel = toPixels[row][col];
                if (toPixel.getBlue() > toPixel.getRed()) {
                    fromPixel = fromPixels[row][col];
                    toPixel.setColor(fromPixel.getColor());
                }
            }
        }
    }

    /**
     * Hide a black and white message in the current picture by changing the red to
     * even and then setting it to odd if the message pixel is black
     * 
     * @param messagePict the picture with a message
     */
    public void encode(Picture messagePict) {

        Pixel[][] messagePixels = messagePict.getPixels2D();
        Pixel[][] currPixels = this.getPixels2D();
        Pixel currPixel = null;
        Pixel messagePixel = null;
        int count = 0;
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth(); col++) {
                // if the current pixel red is odd make it even
                currPixel = currPixels[row][col];
                if (currPixel.getRed() % 2 == 1)
                    currPixel.setRed(currPixel.getRed() - 1);
                messagePixel = messagePixels[row][col];
                if (messagePixel.colorDistance(Color.BLACK) < 50) {
                    currPixel.setRed(currPixel.getRed() + 1);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * Method to decode a message hidden in the red value of the current picture
     * 
     * @return the picture with the hidden message
     */
    public Picture decode() {
        Pixel[][] pixels = this.getPixels2D();
        int height = this.getHeight();
        int width = this.getWidth();
        Pixel currPixel = null;
        Pixel messagePixel = null;
        Picture messagePicture = new Picture(height, width);
        Pixel[][] messagePixels = messagePicture.getPixels2D();
        int count = 0;
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth(); col++) {
                currPixel = pixels[row][col];
                messagePixel = messagePixels[row][col];
                if (currPixel.getRed() % 2 == 1) {
                    messagePixel.setColor(Color.BLACK);
                    count++;
                }
            }
        }
        System.out.println(count);
        return messagePicture;
    }

    /**
     * Method to return the count of the number of pixels with a red value greater
     * than the passed value
     * 
     * @param value the value to compare to
     * @return the count
     */
    public int getCountRedOverValue(int value) {
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                currPixel = pixels[row][col];
                if (currPixel.getRed() > value) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Method to set the red in the top half of the picture to half the original
     * value
     */
    public void setRedToHalfValueInTopHalf() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                currPixel = pixels[row][col];
                currPixel.setRed(currPixel.getRed() / 2);
            }
        }
    }

    /**
     * Method to clear the blue (set to 0) if it is over the passed value
     * 
     * @param value the value to compare to
     */
    public void clearBlueOverValue(int value) {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                currPixel = pixels[row][col];
                if (currPixel.getBlue() > value) {
                    currPixel.setBlue(0);
                }
            }
        }
    }

    /**
     * Method to return the average value for the specified column
     * 
     * @param col the column index to get the average from
     * @return the average of the values in that column
     */
    public int[] getAverageForColumn(int col) {
        Pixel[][] pixels = this.getPixels2D();
        Pixel currPixel = null;
        int[] averageArray = new int[pixels[col].length];
        int total = 0;

        for (int row = 0; row < pixels.length; row++) {
            currPixel = pixels[row][col];
            total = currPixel.getRed() + currPixel.getGreen() + currPixel.getBlue();
            averageArray[row] = total / 3;
        }
        return averageArray;
    }

    /**
     * A very advanced method that uses lamda functions. Can you figure this out?
     */
    public void applyToEachPixel(Consumer<Pixel> operation) {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels)
            for (Pixel p : row)
                operation.accept(p);
    }

    /*
     * Main method for testing - each class in Java can have a main method
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
