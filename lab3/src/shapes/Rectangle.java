package shapes;

public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(String shapeColor, int width, int height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public float calcArea() {
        return (float)(width * height);
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "] color= " + shapeColor;
    }

    @Override
    public String draw() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res.append('*');
            }
            res.append('\n');
        }

        return res.toString();
    }
}
