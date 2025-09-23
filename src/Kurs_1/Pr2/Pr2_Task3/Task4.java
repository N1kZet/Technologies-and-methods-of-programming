package Pr2.Pr2_Task3;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ввдеите длину массива: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        Random random = new Random();
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n;j++){
                arr[i][j] = random.nextInt(50)-25;
            }
        }System.out.println("Массив " + n + "x" + n + ":");
        for (int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(arr[i][j] + " ");
            }System.out.println();
        }
        int min = arr[0][0];
        int max = arr[0][0];
        for (int i =0;i<n;i++){
            for (int j = i; j==i; j++){
                if (arr[i][j] > max){
                    max = arr[i][j];
                }if (arr[i][j] < min){
                    min = arr[i][j];
                }
            }
        }System.out.println("===================");
        System.out.println("Минимальный элемент: "+min + " Максимальный элемент: " +max);
        System.out.println("Произведение макс и мин элемента главной диагонали: "+min*max);
        System.out.println("===================");
        for (int i = 0;i<n;i++){
            for(int j = n-1;j>=0;j--){
                System.out.print(arr[i][n-j] + " ");
        }
    }



    }
}
