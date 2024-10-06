import shapes.Circle;
import shapes.Comparators.AreaComparator;
import shapes.Comparators.ColorComparator;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private final ArrayList<Shape> shapes = new ArrayList<Shape>();
    private final View view;

    public Controller(View view){
        this.view = view;
    }

    public void createShapes() {
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            int randomNumber = random.nextInt(3);

            if (randomNumber == 0) {
                shapes.add(new Circle(String.valueOf(random.nextInt(100)), 5));
            } else if (randomNumber == 1) {
                shapes.add(new Rectangle(String.valueOf(random.nextInt(100)), 15, 6));
            } else {
                shapes.add(new Triangle(String.valueOf(random.nextInt(100)), random.nextInt(10), random.nextInt(10)));
            }
        }
    }

    public void showShapes() {
        for (Shape shape : shapes) {
            this.view.drawShape(shape);
        }
    }

    public void countAllArea() {
        float result = 0;

        for (Shape shape : shapes) {
            result += shape.calcArea();
        }

        this.view.printInfo(String.valueOf(result));
    }

    public void countAreaOfShapeType(String shapeType) {
        float result = 0;

        for (Shape shape : shapes) {
            if (shape.getClass().getSimpleName().equals(shapeType)) {
                result += shape.calcArea();
            }
        }

        this.view.printInfo(String.valueOf(result));
    }

    public void sortShapesByArea() {
        shapes.sort(new AreaComparator());
        System.out.println(shapes);
    }

    public void sortShapesByColor() {
        shapes.sort(new ColorComparator());
        System.out.println(shapes);
    }
}
