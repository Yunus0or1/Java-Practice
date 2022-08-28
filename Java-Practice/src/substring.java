import java.util.ArrayList;
import java.util.Collections;

// This Code is Contributed by Saket Kumar

public class substring {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {

            for (int j = str.length() - 1; j >= i; j--) {

                String temp = "";
                for (int k = i; k <= j; k++) {
                    temp += str.charAt(k);
                }
                result.add(temp);
            }
        }

        System.out.println(result);
    }
}