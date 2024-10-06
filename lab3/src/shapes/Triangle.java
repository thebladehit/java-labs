package shapes;

public class Triangle extends Shape {
    public int height;
    public int width;

    public Triangle(String shapeColor, int height, int width) {
        super(shapeColor);
        this.height = height;
        this.width = width;
    }

    @Override
    public float calcArea() {
        return (float) height * width * 0.5f;
    }

    @Override
    public String toString() {
        return "Triangle [height=" + height + ", width=" + width + "] color= " + shapeColor;
    }

    @Override
    public String draw() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = height - i; j > 0; j--) {
                res.append(" ");
            }
            for (int k = 0; k <= 2 * i; k++) {
                res.append("*");
            }
            res.append("\n");
        }

        return res.toString();
    }
}
