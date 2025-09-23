package Pr1;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x:");
        int x = sc.nextInt();
        System.out.print("Введите y:");
        int y = sc.nextInt();
        if (x*y>100){
            System.out.println(2*Math.pow(x,2));
            System.out.println(y/2);
        }
    }
}
/*Написать программу, получающую на вход в качестве аргумента два параметра
–числа x и y. Если произведение этих чисел больше 100, то вычислить удвоенный
куб первого числа и второе число разделить на 2. Вывести результат на экран.*/