package Pr1;

import java.util.Scanner;
public class CompositeFunction {
    public static double calculateF(double x) {
        if (x <= -3) {
            return Math.exp(Math.sin(x));
        } else if (x > -3 && x <= 4) {
            return Math.pow(x, 4);
        } else {
            double tanX = Math.tan(x);
            if (tanX >= 0) {
                return Math.pow(Math.sqrt(tanX),1.0/3.0);
            } else {
                System.out.println("Ошибка: tan(x) отрицательный.");
                return Double.NaN;
            }
        }
    }
    public static double calculateY(double x) {
        if (x <= -3) {
            return Math.pow(x, 3) + 1;
        } else if (x > -3 && x <= 4) {
            return x * (1 + 2 * Math.pow(x, 2));
        } else {
            return Math.tan(x);
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x: ");
        int x = sc.nextInt();
        double Y = calculateY(x);
        double F = calculateF(x);

        System.out.println("Y = " +Y);
        System.out.println("F = " +F);
    }
}
