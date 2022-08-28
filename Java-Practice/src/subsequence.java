import java.util.ArrayList;
import java.util.Collections;

// This Code is Contributed by Saket Kumar

public class subsequence {
    public static void printSub(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        printSub(str.substring(1), ans + str.charAt(0));
        printSub(str.substring(1), ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSub(str, "");
    }
}