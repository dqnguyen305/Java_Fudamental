import java.util.Scanner;

public class SS2_Gioi2 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a: ");
        a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập b: ");
        b = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập c: ");
        c = Integer.parseInt(sc.nextLine());
        if(a+b<c || a+c<b || b+c<a) {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        } else {
            if (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2) || Math.pow(a,2) + Math.pow(c,2) == Math.pow(b,2) || Math.pow(b,2) + Math.pow(c,2) == Math.pow(a,2)) {
                System.out.println("Ba cạnh tạo thành tam giác vuông.");
            } else if(a==b && b==c) {
                System.out.println("Tam giác đều.");
            } else if (a==b || a==c || b==c) {
                System.out.println("Tam giác cân.");
            } else {
                System.out.println("Tam giác thường.");
            }
        }
    }
}
