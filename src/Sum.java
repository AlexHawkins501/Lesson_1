import java.util.Scanner;

public class Sum {
    public static boolean validNumber(int numOne, int numTwo) {
        int summ = numOne + numTwo;
        return summ >= 10 && summ <= 20;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите два числа по очереди:");
        int numOne = scan.nextInt();
        int numTwo = scan.nextInt();
        System.out.println(validNumber(numOne, numTwo));
    }
}

