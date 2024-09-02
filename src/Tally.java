public class Tally {
// Задание 6
    public static void main(String[] args) {
        int x = -10;
        valid(x);
    }

    static void valid(int y) {
        if (y >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
}
