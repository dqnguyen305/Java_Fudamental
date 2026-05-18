package SS11_Bai1;

public class Use1 {
    public static void main(String[] args) {
        Shape h1 = new Circle("Circle1", 5);
        Shape h2 = new Rectangle("Rectangle1", 4, 6);

        Shape[] list = {h1,h2};

        for (Shape h : list) {
            h.displayInfo();
            System.out.println("Area: " + h.getArea());
            System.out.println("Perimeter: " + h.getPerimeter());
            if (h instanceof Drawable) {
                ((Drawable) h).draw();
            }
            System.out.println();
        }
    }
}
