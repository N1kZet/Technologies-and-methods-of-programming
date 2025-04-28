package Pr2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Pr2_Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int arrayLength = sc.nextInt();
        int[] myArray = new int[arrayLength];

        Random random = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(201) - 100; // Берется случайное число (от 0 до 200) - 100
        }

        System.out.println("Массив: " + Arrays.toString(myArray));

        int signChanges = Change_of_sign(myArray);
        System.out.println("Количество смен знака: " + signChanges);
    }

    public static int Change_of_sign(int[] arr) {

        int constait = 0;
        int previousSign = sign(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int currentSign = sign(arr[i]);
            if (currentSign != previousSign) {
                constait++;
                previousSign = currentSign;
            }
        }

        return constait;
    }
    public static int sign(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

