import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = null;
        File file = new File("Input.txt");
        if (file.length() == 0) {
            System.out.println("File is empty");
        }
        try {
            in = new Scanner(new File("input.txt"));
        } catch (IOException e) {
            System.out.println("Error keyboard input");
        }

        int n = 0;
        if (in != null) {
            n = in.nextInt();
        }
        int m = 0;
        if (in != null) {
            m = in.nextInt();
        }
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

        int min = seq[0];
        for (int i = 0; i < n; i++) {
            if (seq[i] < min && seq[i] != 1)
                min = seq[i];
        }

        System.out.print("Numbers of lines with minimal subsequence: " + " ");
        for (int i = 0; i < n; i++) {
            if (seq[i] == min)
                System.out.print(i + 1 + " ");
        }
    }
}