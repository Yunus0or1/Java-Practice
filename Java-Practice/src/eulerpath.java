import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphConst {
    private int v; // number of node
    private ArrayList<ArrayList<Integer>> adj;

    GraphConst(int v) {
        this.v = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    Boolean checkIfDisconnected() {
        Boolean[] visited = new Boolean[v];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int noEdgeNode = 0;
        for (int i = 0; i < this.v; i++) {
            if (this.adj.get(i).size() == 0) {
                noEdgeNode++;
            }
        }

        if (noEdgeNode == this.v)
            return true;

        dfs(visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false && this.adj.get(i).size() > 0) {
                return false;
            }
        }

        return true;
    }

    Boolean[] dfs(Boolean[] visited) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);

        while (!stack.empty()) {
            int data = stack.pop();
            if (visited[data])
                continue;

            visited[data] = true;
            ArrayList<Integer> nextNodeList = this.adj.get(data);

            for (int i = 0; i < nextNodeList.size(); i++) {
                stack.add(nextNodeList.get(i));
            }
        }
        return visited;
    }

    int[] degree() {
        int[] indegree = new int[v];
        int[] outdegree = new int[v];

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> nodeList = adj.get(i);

            outdegree[i] = nodeList.size();

            for (int j = 0; j < nodeList.size(); j++) {
                indegree[nodeList.get(j)]++;
            }
        }
        return indegree;
    }

    void addEdgeGraph(int node, int to) {
        this.adj.get(node).add(to);
        this.adj.get(to).add(node);
    }

}

class eulerpath {

    static void testEuler(GraphConst g) {
        if (g.checkIfDisconnected() == false) {
            System.out.println("No Euler path");
        }

        int[] indegree = g.degree();

        int oddCount = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] % 2 == 1) {
                oddCount++;
            }
        }

        // No path or circuit
        if (oddCount > 2) {
            System.out.println("No Euler path");
            return;
        }

        // circuit
        if (oddCount == 0) {
            System.out.println("Euler Circuit");
            return;
        }

        // path/semi-eulerian
        System.out.println("Euler Path Exists");
    }

    public static void main(String[] args) {
        int V = 5;
        GraphConst g1 = new GraphConst(V);
        // g1.addEdgeGraph(1, 0);
        // g1.addEdgeGraph(0, 2);
        // g1.addEdgeGraph(2, 1);
        // g1.addEdgeGraph(0, 3);
        // g1.addEdgeGraph(3, 4);

        // g1.addEdgeGraph(1, 0);
        // g1.addEdgeGraph(0, 2);
        // g1.addEdgeGraph(2, 1);
        // g1.addEdgeGraph(0, 3);
        // g1.addEdgeGraph(3, 4);
        // g1.addEdgeGraph(1, 3);

        g1.addEdgeGraph(0, 1);
        g1.addEdgeGraph(1, 2);
        g1.addEdgeGraph(2, 0);

        testEuler(g1);
    }
}