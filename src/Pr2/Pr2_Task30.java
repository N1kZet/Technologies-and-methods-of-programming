package Pr2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pr2_Task30 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = sc.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = sc.nextInt();

        int[][] array = new int[rows][cols];
        Random random = new Random();
        for(int i = 0; i<rows;i++){
            for(int j = 0; j<cols;j++){
                array[i][j] = random.nextInt(100)-50;
            }
        }

        System.out.println("Матрица: ");
        printMatrix(array);

        for(int j=0;j<cols;j++){
            double geomMean = geom(array,j);
            System.out.printf("Среднее геометрическое положительных в столбце %d: %.2f%n",j+1,geomMean);

        }
    }

    public static void printMatrix(int[][] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static double geom(int[][] arr, int col){
        double product = 1.0;
        int cout = 0;

        for (int i = 0; i<arr.length; i++){
            if (arr[i][col] > 0){
                product+=arr[i][col];
                cout++;
            }
        }
        if (cout == 0){
            return 0.0;
        }

        return Math.pow(product, 1.0 / cout);
    }
}




/* Определить матрицу (двумерный массив) и ее заполнить случайными значениями.
среднее геометрическое положительных элементов в каждом столбце
матрицы */
