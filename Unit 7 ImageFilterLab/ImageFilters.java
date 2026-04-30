import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class ImageFilters {
    public static void main(String[] args) {
        try {
            // Load an image file
            BufferedImage image = loadFile("images/landscape.jpg");

            // apply a filter
            // invertColors(image);
            // brightenColors(image);
            // blackRed(image);
            // blackAverage(image);
            // sepia(image);
            // valencia(image);
            // leftMirrorImage(image);
            // rightMirrorImage(image);
            // joshua(image);
            cs(image);

            // Save the edited file to desired location
            saveFile("images/edited-landscape-9.jpg", image);

            // to-do: create 9 more filters using the invertColors as a starting point
            // note you might need to run the filters separately to avoid altering the image
            // multiple times

            // to-do: save all changes as individual files using saveFile()

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // helper methods
    // This method searches the folder path to the target image and returns a
    // BufferedImage object
    // using the data from the file
    public static BufferedImage loadFile(String pathToImage) throws IOException {
        // Load an image file
        File inputFile = new File(pathToImage);
        BufferedImage image = ImageIO.read(inputFile);
        return image;

    }

    // This method creates a new JPG file at the target save location, and copies
    // the data from the
    // BufferedImage object to the file.
    public static void saveFile(String saveLocation, BufferedImage image) throws IOException {
        // Save the edited image
        File outputFile = new File(saveLocation);
        outputFile.createNewFile();
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Image color changed and saved successfully!");
    }

    // filter methods

    // invert colors
    public static void invertColors(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(255 - color.getRed(), 255 - color.getGreen(),
                        255 - color.getBlue());

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // brighten
    public static void brightenColors(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(Math.min(color.getRed() + 50, 255), Math.min(color.getGreen() + 50, 255),
                        Math.min(color.getBlue() + 50, 255));

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // BW Red
    public static void blackRed(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(color.getRed(), color.getRed(),
                        color.getRed());

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // BW Average
    public static void blackAverage(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);
                int average = (int) (color.getBlue() + color.getGreen() + color.getRed()) / 3;

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(average, average,
                        average);

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // Sepia
    public static void sepia(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);
                int luminance = (int) (0.3 * color.getRed() + 0.59 * color.getGreen() + 0.11 * color.getBlue());

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(Math.min((int) (luminance * 1.15), 255), Math.min((int) (luminance), 255),
                        Math.min((int) (luminance * 0.93), 255));

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // Valencia
    public static void valencia(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(Math.min((int) ((color.getRed() + 15) * 1.15), 255),
                        Math.min((int) ((color.getGreen() + 15) * 1), 255),
                        Math.min((int) ((color.getBlue()) * 0.9), 255));

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // mirror image, left
    public static void leftMirrorImage(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < (width / 2 + 1); x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(width - x - 1, y, color.getRGB());
            }
        }

    }

    // mirror image, right
    public static void rightMirrorImage(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = width - 1; x > (width / 2 - 1); x--) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(width - x - 1, y, color.getRGB());
            }
        }

    }

    // Joshua's filter
    public static void joshua(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);
                int luminance = (int) (0.3 * color.getRed() + 0.59 * color.getGreen() + 0.11 * color.getBlue());

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(Math.min((int) (color.getRed() * 0.67), 255), Math.min((int) (color.getGreen()), 255),
                        Math.min((int) (color.getBlue() * 1.41), 255));

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    // CS Filter
    public static void cs(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point
                Color color = new Color(pixel, true);
                int saturation = (int) (0.21 * color.getRed() + 0.41 * color.getGreen() + 0.67 * color.getBlue()) / 100;

                // modify the RGB values of the color
                // the code below inverts colors
                color = new Color(Math.min((int) (saturation * color.getRed()), 255),
                        Math.min((int) (saturation * color.getGreen()), 255),
                        Math.min((int) (saturation * color.getBlue()), 255));

                // update the pixel's color to the new color
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }
}
