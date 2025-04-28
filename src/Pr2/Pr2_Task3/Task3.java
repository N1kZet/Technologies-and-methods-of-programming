package Pr2.Pr2_Task3;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        Random random = new Random();
        System.out.println("Матрица " + n + "x" + n +":");
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                arr[i][j] = random.nextInt(100);
            }
        }
        Result(arr, n);

        for (int i = 0; i<n; i++){
            int min = arr[0][0];
            int max = arr[0][0];
            for (int j = 0; j<n; j++){
                if (arr[i][j] < min){
                    min = arr[i][j];
                }if(arr[i][j] > max){
                    max = arr[i][j];
                }

            }System.out.println("Минимальный элемент " + (i+1) + " массива = "+ min);
            System.out.println("Максимальный элемент " + (i+1) + " массива = "+ max);
            System.out.println();
        }
    }
    public static void Result(int arr[][],int n){
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                    System.out.print(arr[i][j] + " ");
                }System.out.println();
        }System.out.println();
    }
}
