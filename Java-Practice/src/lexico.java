import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class lexico {

    public static boolean isValidIndex(String str, int index) {
        return index >= 0 && index < str.length();
    }

    // Returning True if str1 is large
    public static boolean lexicompare(String str1, String str2) {
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }

            else if (str1.charAt(i) < str2.charAt(j)) {
                return false;
            }

            else if (str1.charAt(i) > str1.charAt(j)) {
                return true;
            }
        }

        if (isValidIndex(str1, i)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] strs = { "aaa", "aa", "aaaaab", "bbb" };

        for (int i = 0; i < strs.length; i++) {
            for (int j = i; j < strs.length; j++) {
                if (lexicompare(strs[i], strs[j])) {
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }

                for (int k = 0; k < strs.length; k++) {
                    System.out.println(strs[k]);
                }
                System.out.println("-----------");
            }
        }

    }

}
