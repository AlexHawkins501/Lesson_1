import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] massives = new String[][]{{"1", "4", "3", "i",}, {"6", "4", "1", "8"}, {"4", "2", "7", "9"}, {"6", "3", "6", "5"}};
        String[][] massives2 = new String[][]{{"1", "2", "3"}, {"4", "6", "2"}};

        try {// Проверка для 1 массива.
            System.out.println("Сумма всех элементов в массиве равна " + SumOrError(massives));
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива. Введенный массив должен быть размером 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Неверное значение элемента в массиве");
            System.out.println("Индекс элемента: " + "[" + e.i + "]" + "[" + e.j + "]");
        } finally {
            Arrays.stream(massives).map(Arrays::toString).forEach(System.out::println);
            System.out.println();
        }

    try {// Проверка для 2 массива.
        System.out.println("Сумма всех элементов в массиве равна " + SumOrError(massives2));
    } catch (MyArraySizeException e) {
        System.out.println("Неверный размер массива. Введенный массив должен быть размером 4х4");
    } catch (MyArrayDataException e) {
        System.out.println("Неверное значение элемента в массиве");
        System.out.println("Индекс элемента: " + "[" + e.i + "]" + "[" + e.j + "]");
    } finally {
        Arrays.stream(massives2).map(Arrays::toString).forEach(System.out::println);
    }
}


    public static int SumOrError(String[][] massive) throws MyArraySizeException, MyArrayDataException {

        int Sum = 0;

        if (4 != massive.length) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < massive.length; i++) {
            if (massive[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < massive[i].length; j++) {
                try {
                    Sum += Integer.parseInt(massive[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return Sum;

    }
}

