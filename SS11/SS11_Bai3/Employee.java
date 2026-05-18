package SS11_Bai3;
 abstract class Employee {
     protected int id;
     protected String name;

     public Employee(int id, String name) {
         this.id = id;
         this.name = name;
     }

     abstract double calculateSalary();

     public void showInfo(){
         System.out.println("ID: " + id + ", Name: " + name);
     }
}
