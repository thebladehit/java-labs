package shapes;

import interfaces.Drawable;

public abstract class Shape implements Drawable {
    protected String shapeColor;

    protected Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract float calcArea();

    @Override
    public String toString() {
        return "Shape of color: " + shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }
}
