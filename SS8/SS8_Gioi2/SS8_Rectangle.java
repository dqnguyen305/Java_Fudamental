package SS8_Gioi2;

public class SS8_Rectangle {
    private double width;
    private double height;

    public SS8_Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    @Override
    public String toString() {
        return String.format("width=%.1f, height=%.1f, area=%.1f, perimeter=%.1f",
                width, height, getArea(), getPerimeter());
    }
}
