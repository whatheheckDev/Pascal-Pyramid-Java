import java.util.InputMismatchException;
import java.util.Scanner;

public class PascalPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = getNumber();
        int[][][] pyramid = new int[n + 1][][];
        int[][] triangle = pascalTriangle(n);
        for (int i = 0; i < n + 1; i++) {
            pyramid[i] = new int[i + 1][];
            System.out.println("Layer " + i + ":");
            System.out.println("");
            for (int j = 0; j < i + 1; j++) {
                pyramid[i][j] = new int[j + 1];
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
    
    public static int[][] pascalTriangle(int n) {
        int[][] triangle = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            triangle[i] = new int[i + 1];
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
        return n;
    }
}
