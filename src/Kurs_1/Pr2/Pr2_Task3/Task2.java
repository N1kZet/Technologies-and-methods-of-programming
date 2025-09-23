package Pr2.Pr2_Task3;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args){
        int arrLenght = 4;
        int  arr[][] = new int[arrLenght][arrLenght];
        Random random  = new Random();

        System.out.println("Матрица: ");
        for (int i = 0;i<arrLenght; i++){
            for (int j = 0; j<arrLenght; j++){
                arr[i][j] = random.nextInt(100)-50;
            }System.out.println(Arrays.toString(arr[i]));
        }

        for(int i = 0; i<arrLenght; i++){
            double arithmeticMean = 0.0;
            int sum = 0;
            int cout = 0;
            for(int j = 0; j<arrLenght; j++){
                if (arr[i][j]>0){
                    sum+=arr[i][j];
                    cout++;
                }
            }if (cout != 0){
                arithmeticMean = sum/cout;
                System.out.println("Среднее арифметическое положительных элементов = " + arithmeticMean);
            }else{
                System.out.println("Нет положительных элементов в строке " + (i+1));
            }

        }

    }
}
