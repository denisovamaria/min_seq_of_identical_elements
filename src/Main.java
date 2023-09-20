import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            int length = 1;
            for (int j = 0; j < m; j++) {
                if (j != 0 && matrix[i][j] == matrix[i][j - 1])
                    length++;
                if (length > seq[i])
                    seq[i] = length;
                else
                    length = 1;
            }
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            if (seq[i] > min)
                min = seq[i];
        }

        System.out.print("Numbers of lines with minimal subsequence: " + " ");
        for (int i = 0; i < n; i++) {
            if (seq[i] == min)
                System.out.print(i + 1 + " ");
        }
    }
}