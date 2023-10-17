import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence1 = "Two random sentences for for comparison.";
        String sentence2 = "Two sentences random for comparison.";

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");


        int m = words1.length;
        int n = words2.length;

        int[][] LCSuffix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (words1[m - i].equals(words2[n - j])) {
                    LCSuffix[i][j] = LCSuffix[i - 1][j - 1] + 1;
                } else {
                    LCSuffix[i][j] = Math.max(LCSuffix[i - 1][j], LCSuffix[i][j - 1]);
                }
            }
        }

        print(LCSuffix);

        int i = words1.length;
        int j = words2.length;
        while (i > 0 && j > 0) {
            if (words1[m-i].equals(words2[n-j])) {
                System.out.println("Equal: " + words1[m-i]);
                i--;
                j--;
            } else if (LCSuffix[i - 1][j] > LCSuffix[i][j - 1]) {
                System.out.println("Deleted: " + words1[m-i]);
                i--;
            } else {
                System.out.println("Added: " + words2[n-j]);
                j--;
            }
        }

        while (i > 0) {
            System.out.println("Deleted: " + words1[m-i]);
            i--;
        }

        while (j > 0) {
            System.out.println("Added: " + words2[n-j]);
            j--;
        }
    }

    private static void print(int[][] lcSuffix) {
        for (int i = 0; i < lcSuffix.length; i++) {
            for (int j = 0; j < lcSuffix[i].length; j++) {
                System.out.print(lcSuffix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}