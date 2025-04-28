package Pr1;

import java.util.Scanner;

public class CalculateD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите a: ");
        int a = sc.nextInt();
        System.out.print("Введите b: ");
        int b = sc.nextInt();
        double numerator = 2 * Math.max(a, b - 5) - 4 * Math.min(1 - a, b);
        double denominator = 3 + (Math.max(a, b - 5) / Math.min(1 - a, b));

        if (3 + (Math.max(a, b - 5) / Math.min(1 - a, b))==0 || Math.min(1 - a, b)==0) {
            System.out.println("Ошибка деления на ноль");
        }
        System.out.println(numerator / denominator);
    }
}
