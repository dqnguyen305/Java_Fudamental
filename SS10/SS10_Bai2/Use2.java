package SS10_Bai2;

public class Use2 {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(2,3);
        Shape s2 = new Circle(1);

        System.out.println("Area of Rectangle: " + s1.area());
        System.out.println("Area of Circle: " + s2.area());
    }
}
