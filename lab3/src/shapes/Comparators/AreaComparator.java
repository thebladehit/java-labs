package shapes.Comparators;

import shapes.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return Float.compare(s1.calcArea(), s2.calcArea());
    }
}
