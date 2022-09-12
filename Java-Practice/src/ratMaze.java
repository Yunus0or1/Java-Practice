import java.util.HashSet;

class ratMaze {

    static boolean isSafe(int maze[][], int x, int y, int N) {
        if ((x >= 0 && x < N) && (y >= 0 && y < N) && maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    static void printSolve(int solve[][]) {
        for (int i = 0; i < solve.length; i++) {
            for (int j = 0; j < solve.length; j++) {
                System.out.print(solve[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solveMazeInit(int maze[][], int N) {
        int solve[][] = new int[N][N];
        System.out.println(solveMaze(maze, solve, 0, 0, N));
        printSolve(solve);
    }

    static boolean solveMaze(int maze[][], int solve[][], int x, int y, int N) {

        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            return true;
        }

        if (isSafe(maze, x, y, N)) {

            if (solve[x][y] == 1) {
                return false;
            }

            solve[x][y] = 1;

            if (solveMaze(maze, solve, x + 1, y, N)) {
                return true;
            }

            if (solveMaze(maze, solve, x, y + 1, N)) {
                return true;
            }

            solve[x][y] = 0;

            return false;
        }

        return false;
    }

    // Driver code
    public static void main(String args[]) {

        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int N = maze.length;
        solveMazeInit(maze, N);
    }
}