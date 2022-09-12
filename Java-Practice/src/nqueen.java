import java.util.ArrayList;
import java.util.HashSet;

class nqueen {

    static boolean isSafe(int currentRow, int currentCol, int board[][], int N) {
        for (int row = 0; row < currentRow; row++) {
            if (board[row][currentCol] == 1) {
                return false;
            }
        }

        for (int i = currentRow, j = currentCol; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = currentRow, j = currentCol; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static void printSolve(int solve[][]) {
        for (int i = 0; i < solve.length; i++) {
            for (int j = 0; j < solve.length; j++) {
                System.out.print(solve[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solveNQueenInit(int N) {
        int board[][] = new int[N][N];
        boolean result = solveNQueen(0, N, board);
        System.out.println("---------------------");
        System.out.println(result);
        printSolve(board);
    }

    static boolean solveNQueen(int row, int N, int[][] board) {
        if (row == N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            boolean safe = isSafe(row, i, board, N);

            if (safe) {
                board[row][i] = 1;

                if (solveNQueen(row + 1, N, board)) {
                    return true;
                }

                board[row][i] = 0;
            }
        }

        return false;
    }

    // Driver code
    public static void main(String args[]) {
        int N = 4;
        solveNQueenInit(N);
    }
}