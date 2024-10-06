import shapes.Shape;

public class View {
    public void drawShape(Shape shape) {
        System.out.println(shape.draw());
    }

    public void printInfo(String info) {
        System.out.println(info);
    }
}
