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

        dfs(visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
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

    void degree() {
        int[] indegree = new int[v];
        int[] outdegree = new int[v];

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> nodeList = adj.get(i);

            outdegree[i] = nodeList.size();

            for (int j = 0; j < nodeList.size(); j++) {
                indegree[nodeList.get(j)]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            System.out.print(indegree[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < indegree.length; i++) {
            System.out.print(outdegree[i] + " ");
        }
    }

    void addEdgeGraph(int node, int to) {
        this.adj.get(node).add(to);
        this.adj.get(to).add(node);
    }
}

class eulerpath {

    public static void main(String[] args) {
        GraphConst g1 = new GraphConst(5);
        g1.addEdgeGraph(1, 0);
        g1.addEdgeGraph(0, 2);
        g1.addEdgeGraph(2, 1);
        g1.addEdgeGraph(0, 3);
        g1.addEdgeGraph(3, 4);

        g1.degree();
    }
}