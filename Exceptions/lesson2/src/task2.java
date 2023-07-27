public class task2 {
    public static void main(String[] args) {
        try {
            int[] intArray = { 10, 5, 0, 8, 4 };
            int d = 0;
            double catchedRes1 = (double) intArray[4] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
