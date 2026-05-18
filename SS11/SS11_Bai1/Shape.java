package SS11_Bai1;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double getArea();
    abstract double getPerimeter();

    public void displayInfo(){
        System.out.println("Shape: " + name);
    }
}

