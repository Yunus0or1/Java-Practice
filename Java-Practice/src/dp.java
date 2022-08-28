import java.util.*;

class Recursion {
    static long fibRecur(int n, HashMap memo) {
        if (memo.containsKey(n))
            return (long) memo.get(n);
        if (n <= 2)
            return 1;

        memo.put(n, fibRecur(n - 1, memo) + fibRecur(n - 2, memo));

        return (long) memo.get(n);
    }

    static int fibDp(int n) {
        ArrayList<Integer> fib = new ArrayList<Integer>();
        fib.add(1);
        fib.add(1);
        for (int i = 2; i < n; i++) {
            fib.add(fib.get(i - 1) + fib.get(i - 2));
        }

        return fib.get(n - 1);
    }
}

class LCS {

    public static int getMax(int i1, int i2) {
        int max = i1;

        if (i2 > max) {
            max = i2;
        }

        return max;
    }

    public static int lcs(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();

        int[][] dp = new int[2][col];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = 0;
            }
        }

        ArrayList<Character> lcsMatch = new ArrayList<Character>();

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i % 2][j] = dp[Math.abs(i % 2 - 1)][j - 1] + 1;
                    if (dp[i % 2][j] > dp[Math.abs(i % 2 - 1)][j] && dp[i % 2][j] > dp[i % 2][j - 1]) {
                        lcsMatch.add(str1.charAt(i));
                    }
                } else {
                    dp[i % 2][j] = getMax(dp[i % 2][j - 1], dp[Math.abs(i % 2 - 1)][j]);
                }
            }
        }

        System.out.println("Printing DP Matrix");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Printing LCS");
        for (int i = 0; i < lcsMatch.size(); i++) {
            System.out.print(lcsMatch.get(i));
        }
        System.out.println();

        return 0;
    }
}

class Solution1 {

    public static int getMax(int i1, int i2) {
        int max = i1;

        if (i2 > max) {
            max = i2;
        }

        return max;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length() + 1;
        int col = text2.length() + 1;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = getMax(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println("Printing DP Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[row - 1][col - 1];
    }
}

class Solution {

    public static int getMax(int i1, int i2) {
        int max = i1;

        if (i2 > max) {
            max = i2;
        }

        return max;
    }

    public int editDistance(String text1, String text2) {
        int row = text1.length() + 1;
        int col = text2.length() + 1;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = getMax(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println("Printing DP Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[row - 1][col - 1];
    }
}

public class dp {

    public static void main(String[] args) {

        // final HashMap memo = new HashMap<>();
        // System.out.println(Recursion.fibRecur(50, memo));

        // System.out.println(Recursion.fibDp(7));

        // LCS.lcs("CDBBDC", "ABBC");

        System.out.println(new Solution1().longestCommonSubsequence("abcde", "ace"));
    }

}
