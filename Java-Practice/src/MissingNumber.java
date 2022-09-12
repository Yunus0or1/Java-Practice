
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;

class MissingNumber {
    public int solution(int[] A) {
        int highest = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > highest) {
                highest = A[i];
            }
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i <= highest + 2; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        // int[] A = { 1, 3, 6, 4, 1, 2 };
        // int[] A = { -1, 3 };
        int[] A = { 1, 2, 3 };
        MissingNumber s = new MissingNumber();
        int d = s.solution(A);
        System.out.println(d);
    }
}
