import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class permutation {
    public static HashSet<String> set = new HashSet<>();

    public static void perm(String str, String ans) {
        if (str.length() == 0) {
            set.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1, str.length());
            String newAns = ans + c;

            perm(rest, newAns);
        }

    }

    public static void main(String[] args) {

        String str = "ABC";
        perm(str, "");
        System.out.println(set);

    }

}
