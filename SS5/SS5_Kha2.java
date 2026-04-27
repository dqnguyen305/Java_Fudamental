public class SS5_Kha2 {
    public static void main(String[] args) {
        int COUNT = 100000;
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        String str = "Hello";
        for (int i = 0; i < COUNT; i++) {
            str += " World";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian nối String: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer("Hello");
        for (int i = 0; i < COUNT; i++) {
            sBuffer.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian nối StringBuffer: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder("Hello");
        for (int i = 0; i < COUNT; i++) {
            sBuilder.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian nối StringBuilder: " + (endTime - startTime) + " ms");
    }
}
//Thời gian nối String: 3684 ms
//Thời gian nối StringBuffer: 6 ms
//Thời gian nối StringBuilder: 2 ms