package Pr2.Pr2_Task3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = sc.nextInt();

        int[][][] arr = new int[n][n][n];
        Random random= new Random();
        for (int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for (int z = 0;z<n;z++){
                    arr[i][j][z] = random.nextInt(20)-10;
                    System.out.print(arr[i][j][z]+" ");
                }System.out.println();
            }System.out.println();
        }
        System.out.println("Сумма максимальных элементов в строке: " + funMath(arr, n));
    }

    public static double funMath(int[][][] arr, int n){
        int cout=0,max = arr[0][0][0];int sum =0;
        for(int z = 0;z<n;z++){
            for(int o = 0;o<n;o++){
                for (int v = 0; v<n; v++){
                    if (max<arr[z][o][v]){
                        cout++;
                        max = arr[z][o][v];
                    }sum+=max;
                }
            }
        }return sum;
    }

}
