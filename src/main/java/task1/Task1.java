package task1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Integer[] array = {0,1,2,3,4,5};
        String[] arrayStr = {"A", "B", "C"};
        swap(array,0,1);
        swap(arrayStr,1,2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayStr));

    }

    public static <T> void swap(T[] arr, int i, int j){
        try {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Индекс выходит за переделы массива", e);
        }
    }
}
