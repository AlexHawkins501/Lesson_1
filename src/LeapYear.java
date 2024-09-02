public class LeapYear {

    public static boolean test(int y) {
        return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0) && y > 0);

    }

    public static void main(String[] args) {
        int x = 2024;
        System.out.println(test(x));
    }
}
