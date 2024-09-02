public class Summ {
    public static void main(String[] args) {
        checkSumSign();
    }

    public static void checkSumSign() {
        int a = 246;
        int b = -564;
        int sum;
        for (int x = 0; x < 1; x++) {
            sum = a + b;

            if (sum >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
                ;
            }
        }
    }
}
