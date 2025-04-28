package Pr2.Pr2_Task3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        Random random = new Random();
        System.out.println("Матрица " + n + "x" + n +":");
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                arr[i][j] = random.nextInt(100) - 50;
            }System.out.println(Arrays.toString(arr[i]));
        }
        for (int i= 0; i<n; i++){
            int count = 0;
            for (int j = 0; j<n; j++){
                if (arr[i][j]>0){
                    count++;
                }
            }System.out.println("Число неотрицательных элементов: " + count);
        }

    }

}
