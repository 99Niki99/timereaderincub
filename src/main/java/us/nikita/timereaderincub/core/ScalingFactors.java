package us.nikita.timereaderincub.core;

public enum ScalingFactors {

    TYPE_ONE (-1.4211511E7, -7254228, 3f, -10f),
    TYPE_TWO (-7254228, -2171170, 1.455f, -47f),
    TYPE_THREE(-2171170, -1907998, 1.35f, 10f),
    TYPE_FORE(-1907998, -257, 1.19f, 0.5f),
    TYPE_FIVE(-257, -1, 1f, 0.5f),
    TYPE_SIX(-1, 2, 1f,  0.35f);

    private double bottomBorder;
    private int topBorder;
    private float scalingFactor;
    private float offset;

    ScalingFactors(double bottomBorder, int topBorder, float scalingFactor, float offset) {
        this.bottomBorder = bottomBorder;
        this.topBorder = topBorder;
        this.scalingFactor = scalingFactor;
        this.offset = offset;
    }

    public double getBottomBorder() {
        return bottomBorder;
    }

    public int getTopBorder() {
        return topBorder;
    }

    public float getScalingFactor() {
        return scalingFactor;
    }

    public float getOffset() {
        return offset;
    }
}
