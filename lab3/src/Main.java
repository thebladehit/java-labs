public class Main {
    public static void main(String[] args) {
        System.out.println("Start app!\n");

        View view = new View();
        Controller app = new Controller(view);

        app.createShapes();
        app.showShapes();
        app.countAllArea();
        app.countAreaOfShapeType("Triangle");
        app.sortShapesByArea();
        app.sortShapesByColor();
    }
}