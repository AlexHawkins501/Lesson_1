import java.util.Arrays;
// Задание 12
public class MassiveMult {
    public static void main(String[] args) {

        int [] array = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(array));
        for (int i =0; i<array.length; i++){
            if (array [i] <6){
                array[i]*=2;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
