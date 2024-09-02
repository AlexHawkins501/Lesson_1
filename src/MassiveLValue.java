import java.util.Arrays;
// Задание 14
public class MassiveLValue {

    public static void comeback(int lengh, int value) {
        int[] array = new int[lengh];
        for (int i = 0; i < lengh; i++) {
            array[i] = value;
        }
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        int len = 10;
        int initialValue = 9;
        comeback(len, initialValue);
    }
}
