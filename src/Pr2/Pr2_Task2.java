package Pr2;

import java.util.Arrays;
import java.util.Random;

public class Pr2_Task2 {
    public static void main(String[] args){
        int n  = 9;
        double[] arrX = new double[n];

        Random random = new Random();
        for (int i = 0;i<n;i++){
            arrX[i] = random.nextDouble() *10;
        }
        System.out.println("Массив x: " + Arrays.toString(arrX));

        //Сделаем фильтрацию и сжатие массива X
        double[] arrY = filterAndCompress(arrX,3.0);
        System.out.println("Массив y (после фильтрации и сжатия): " + Arrays.toString(arrY));

        //Сортируем массив
        Sort(arrY);
        System.out.println("Массив y (после сортировки): " + Arrays.toString(arrY));
    }
    public static double[] filterAndCompress(double[] x, double treshold) {
        int cout = 0;
        for (double value : x) {
            if (value > treshold) {
                cout++;
            }
        }
        double[] y = new double[cout]; //Массив нужного размера
        int index = 0;
        for (double value : x) {
            if (value > treshold){
                y[index] = value;
                index++;
            }
        }
        return y;
    }
    public static void Sort(double[] arr){
        int n = arr.length;

        for (int i=0; i<n-1; i++){
            //Нахождение индекса минимального эелемента в оставшейся несортировочной части
            int minIndex = i;
            for (int j =i +1;j<n;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //Меняем местами текущий элемент (arr[i]) с мин элементом (arr[minIndex])
            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
/*Дан массив х (n). Переписать в массив y(n) элементы массива х,
большие 3. (со сжатием., без пустых элементов внутри).
Затем упорядочить методом
«выбора и перестановки»по возрастанию новый массив. */