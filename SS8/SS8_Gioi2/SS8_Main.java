package SS8_Gioi2;

public class SS8_Main{
    public static void main (String[] args) {
        SS8_Rectangle r1 = new SS8_Rectangle(3, 4);
        SS8_Rectangle r2 = new SS8_Rectangle(5, 2);
        SS8_Rectangle r3 = new SS8_Rectangle(4.5, 3.5);

        SS8_Rectangle[] list = {r1, r2, r3};

        for (int i = 0; i< list.length;i++) {
            System.out.println("Rectangle " + (i + 1) + ": " + list[i].toString());
        }

        double maxArea = list[0].getArea();
        SS8_Rectangle maxRect = list[0];
        int count = 0;
        int lastIndex = 0;

        for (SS8_Rectangle r : list) {
            if(r.getArea() > maxArea) {
                maxArea = r.getArea();
                maxRect = r;
            }
        }

        for (int i = 0; i < list.length; i++){
            if (list[i].getArea() == maxArea) {
                count++;
                lastIndex = i;
            }
        }
        System.out.println();
        if(count > 1){
            System.out.println("Có " + count + " hình chữ nhật có diện tích lớn nhất là: " + maxArea);
        } else {
            System.out.println("Largest area = " + maxArea + "(Rectangle "+(lastIndex+1)+": " + maxRect.toString() + ")");
        }
    }
}
