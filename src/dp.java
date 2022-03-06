import java.util.HashMap;

class Recursion {
    static long fib(int n, HashMap memo) {
        if (memo.containsKey(n)) return (long) memo.get(n);
        if (n <= 2) return 1;

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));

        return (long) memo.get(n);
    }
}

class GridRun{



}

public class dp {

    public static void main(String[] args) {

        HashMap memo = new HashMap<>();
        System.out.println(Recursion.fib(50, memo));

    }

}
