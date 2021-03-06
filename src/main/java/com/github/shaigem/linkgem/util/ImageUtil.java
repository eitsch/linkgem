package com.github.shaigem.linkgem.util;

/**
 * A class containing utilities for images.
 */
public final class ImageUtil {

    /**
     * Tests if two images are the same to each other.
     *
     * @param image1 the first image to be compared
     * @param image2 the second image to be compared
     * @return true if the images are the same. Otherwise false.
     * @see <a href="http://stackoverflow.com/questions/26044106/javafx-how-to-test-image-equality">
     * http://stackoverflow.com/questions/26044106/javafx-how-to-test-image-equality</a>
     */
    public static boolean isSameImage(javafx.scene.image.Image image1, javafx.scene.image.Image image2) {
        for (int i = 0; i < image1.getWidth(); i++) {
            for (int j = 0; j < image1.getHeight(); j++) {
                if (image1.getPixelReader().getArgb(i, j) != image2.getPixelReader().getArgb(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
