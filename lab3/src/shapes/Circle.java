package shapes;

public class Circle extends Shape {
    public int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public float calcArea() {
        return (float) Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + shapeColor + "]";
    }

    @Override
    public String draw() {
        StringBuilder res = new StringBuilder();
        int diameter = radius * 2;

        for (int y = 0; y <= diameter; y++) {
            for (int x = 0; x <= diameter; x++) {
                double distance = Math.sqrt(Math.pow(x - radius, 2) + Math.pow(y - radius, 2));
                if (distance >= radius - 0.5 && distance <= radius + 0.5) {
                    res.append("*");
                } else {
                    res.append(" ");
                }
            }
            res.append("\n");
        }

        return res.toString();
    }
}
