package Pr1;
import java.util.Scanner;

public class Var6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double x = sc.nextDouble();
        System.out.print("Введите число a: ");
        double a = sc.nextDouble();
        System.out.print("Введите число b: ");
        double b = sc.nextDouble();

        double Y = 0;
        double F = 0;

        if (x<=0) {
            Y = a - Math.pow(b, x+1);
            F = Math.exp(Math.tan(a*x + 1));
        } else if (x<=3 && x>0){
            Y = (1 + Math.pow(3, x*a));
            F = Math.pow(x, a) - Math.pow(Math.sin(b), x);
        } else if (x>3) {
            Y = 1 / Math.tan(a*x + 1);
            F = Math.pow(x, (2/5));
        }

        System.out.println("Y = " + Y);
        System.out.println("F = " + F);
    }
}