package us.nikita.timereaderincub.core;

import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * The class creates an Enum which is the value of the Scaling factors, it also creates a class that defines the axis of the image. And getters
 *
 * @author Nikita
 */
public enum ScalingFactors {

    TYPE_ONE(-1.4211511E7, -7254228, 3f, -10f),
    TYPE_TWO(-7254228, -2171170, 1.455f, -47f),
    TYPE_THREE(-2171170, -1907998, 1.35f, 10f),
    TYPE_FORE(-1907998, -257, 1.19f, 0.5f),
    TYPE_FIVE(-257, -1, 1f, 0.5f),
    TYPE_SIX(-1, 2, 1f, 0.35f);

    private final double bottomBorder;
    private final int topBorder;
    private final float scalingFactor;
    private final float offset;

    ScalingFactors(double bottomBorder, int topBorder, float scalingFactor, float offset) {
        this.bottomBorder = bottomBorder;
        this.topBorder = topBorder;
        this.scalingFactor = scalingFactor;
        this.offset = offset;
    }

    /**
     * The method determines the axis of image change
     *
     * @param image Image for rescaling
     * @return Returns the scaling factor for changing the image
     */
    public static ScalingFactors getForImage(BufferedImage image) {
        double imageSize
                = image
                .getRGB(image.getTileWidth() >> 1,
                        image.getTileHeight() >> 1);

        return Arrays.stream(ScalingFactors.values())
                .filter(value -> imageSize >= value.bottomBorder && imageSize <
                        value.topBorder)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public float getScalingFactor() {
        return scalingFactor;
    }

    public float getOffset() {
        return offset;
    }


}

