// Задание 3

public class Colors {
    public static void main(String[] args) {
        printColor();
    }

    public static void printColor() {
        int value = 67;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (0 < value && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зелёный");
        }

    }
}

