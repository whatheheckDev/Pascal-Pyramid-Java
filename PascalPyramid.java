import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = getNumber();
        long[][][] pyramid = new long[n + 1][][];
        long[][] triangle = pascalTriangle(n);
        for (int i = 0; i < n + 1; i++) {
            pyramid[i] = new long[i + 1][];
            System.out.println("Layer " + i + ":");
            System.out.println("");
            for (int j = 0; j < i + 1; j++) {
                pyramid[i][j] = new long[j + 1];
                for (int k = 0; k < i - j; k++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < j + 1; k++) {
                    pyramid[i][j][k] = triangle[j][k] * triangle[i][j];
                    System.out.print(pyramid[i][j][k]+" ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static long[][] pascalTriangle(int n) {
        long[][] triangle = new long[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            triangle[i] = new long[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }
        return triangle;
    }
    

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        try{
            n = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Input a number!");
            getNumber();
        }
        if (n < 0) {
            System.out.println("Should be positive or zero");
            getNumber();
        }
        else if (n > 40) {
            System.out.println("Don't.");
            getNumber();
        }
        return n;
    }
}
