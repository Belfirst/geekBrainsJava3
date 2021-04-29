package ru.geekBrains;

import java.util.Arrays;

public class WorkingWithArrays {
    private final int num = 4;

    public int[] getAllAfterFour(int[] numbers){
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == num){
                temp = i + 1;
            }
        }
        if(temp == 0) throw new ArithmeticException("There is no " + num + "in the array");
        return Arrays.copyOfRange(numbers, temp, numbers.length);
    }

    public boolean checkArray(int[] array){
        int countFirst = 0;
        int countSecond = 0;
        for (int j : array) {
            if (j == 4) countFirst++;
            else if (j == 1) countSecond++;
            else return false;
        }
        return countFirst != 0 && countSecond != 0;
    }
}
