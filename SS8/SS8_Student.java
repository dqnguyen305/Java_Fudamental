public class SS8_Student {
    private int id;
    private String name;
    private int age;

    public SS8_Student(int id,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
    public static void main(String[] args) {
        SS8_Student student1 = new SS8_Student(1, "Alice", 20);
        student1.printInfo();
    }
}
