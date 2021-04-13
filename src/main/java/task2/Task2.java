package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Integer[] array = {0,1,2,3,4,5};
        String[] arrayStr = {"A", "B", "C"};

        System.out.println(toList(array));

        // Так ведь тоже можно, вроде и обобщения и спользуются
        List<?> list = new ArrayList<>(Arrays.asList(arrayStr));
        System.out.println(list);
    }

    public static <E> List toList(E[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
