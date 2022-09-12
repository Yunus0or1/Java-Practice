class knapsack {

    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSack(int val[], int wt[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] > W) {
            return knapSack(val, wt, W, n - 1);
        }

        int score1 = knapSack(val, wt, W, n - 1);
        int score2 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);
        return max(score1, score2);

    }

    // Driver code
    public static void main(String args[]) {
        int val[] = new int[] { 15, 5, 10, 20 };
        int wt[] = new int[] { 11, 5, 19, 24 };
        int W = 30;
        int n = val.length;
        System.out.println(knapSack(val, wt, W, n));
    }
}