import java.util.Arrays;

public class SquareMassive {
    public static void main(String[] args) {
        int[][] square = new int[10][10];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (i == j) {
                    square[i][j] = 1;
                    square[i][square.length-1-j]=1;
                }
            }
        }
        Arrays.stream(square).map(Arrays::toString).forEach(System.out::println);
    }
}
