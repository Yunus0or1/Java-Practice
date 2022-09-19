import java.util.Arrays;

class EdgeMst implements Comparable<EdgeMst> {
    int src;
    int dest;
    int weight;

    @Override
    public int compareTo(EdgeMst o) {
        return this.weight - o.weight;
    }
}

class SubsetMst {
    int parent;
    int rank;
}

class GraphMST {
    int e;
    int v;
    EdgeMst[] edge;

    GraphMST(int v, int e) {
        this.v = v;
        this.e = e;
        this.edge = new EdgeMst[e];

        for (int i = 0; i < e; i++) {
            this.edge[i] = new EdgeMst();
        }

    }

    int findParent(SubsetMst[] subsets, int node) {
        if (subsets[node].parent == node) {
            return node;
        }
        return findParent(subsets, subsets[node].parent);
    }

    void UnionMst(SubsetMst[] subsets, int node1, int node2) {

        int node1Root = findParent(subsets, node1);
        int node2Root = findParent(subsets, node2);

        if (subsets[node1Root].rank > subsets[node2Root].rank) {
            subsets[node2Root].parent = node1Root;
        } else if (subsets[node1Root].rank < subsets[node2Root].rank) {
            subsets[node1Root].parent = node2Root;
        } else {
            subsets[node2Root].parent = node1Root;
            subsets[node2Root].rank++;
        }
    }

    void kurshkalMST() {
        SubsetMst[] subsets = new SubsetMst[this.v];

        for (int i = 0; i < this.v; i++) {
            SubsetMst subset = new SubsetMst();
            subsets[i] = subset;
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        Arrays.sort(edge);

        EdgeMst[] result = new EdgeMst[this.v];
        for (int i = 0; i < this.v; i++) {
            EdgeMst edge = new EdgeMst();
            result[i] = edge;
        }

        int i = 0;
        int j = 0;
        while (i < v - 1) {
            EdgeMst edge = this.edge[j++];

            int node1Root = findParent(subsets, edge.src);
            int node2Root = findParent(subsets, edge.dest);

            if (node1Root == node2Root) {
                continue;
            } else {
                UnionMst(subsets, node1Root, node2Root);
                result[i++] = edge;
            }
        }

        for (int k = 0; k < i; k++) {
            System.out.println(result[k].src + ", " + result[k].dest + ", " +
                    result[k].weight);
        }
    }

}

class mst {

    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        GraphMST graph = new GraphMST(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kurshkalMST();
    }
}