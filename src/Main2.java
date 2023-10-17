import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String sentence1 = "Two random sentences for for comparison.";
        String sentence2 = "Two sentences random for comparison.";

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");



        List<String> list1 = Arrays.asList(words1);
        Collections.reverse(list1);
        words1 = list1.toArray(new String[0]);

        List<String> list2 = Arrays.asList(words2);
        Collections.reverse(list2);
        words2 = list2.toArray(new String[0]);
        int[][] LCSuffix = new int[words1.length + 1][words2.length + 1];

        for (int i = 1; i <= words1.length; i++) {
            for (int j = 1; j <= words2.length; j++) {
                if (words1[i - 1].equals(words2[j - 1])) {
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
            if (words1[i - 1].equals(words2[j - 1])) {
                System.out.println("Equal: " + words1[i - 1]);
                i--;
                j--;
            } else if (LCSuffix[i - 1][j] > LCSuffix[i][j - 1]) {
                System.out.println("Deleted: " + words1[i - 1]);
                i--;
            } else {
                System.out.println("Added: " + words2[j - 1]);
                j--;
            }
        }

        while (i > 0) {
            System.out.println("Deleted: " + words1[i - 1]);
            i--;
        }

        while (j > 0) {
            System.out.println("Added: " + words2[j - 1]);
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