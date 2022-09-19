class Edge {
    int src;
    int dest;
}

class Subsets {
    int parent;
    int rank;
}

class GraphUnionFind {

    int v;
    int e;
    Edge[] edges;

    GraphUnionFind(int v, int e) {
        this.v = v;
        this.e = e;
        this.edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    int find(Subsets[] subsets, int i) {
        if (subsets[i].parent == i) {
            return subsets[i].parent;
        }
        return find(subsets, subsets[i].parent);
    }

    void union(Subsets[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[yRoot].rank++;
        }
    }

    void checkIfCircleFormed() {

        Subsets[] subsets = new Subsets[this.v];
        for (int i = 0; i < this.v; i++) {
            subsets[i] = new Subsets();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (int i = 0; i < this.v; i++) {
            System.out.println(subsets[i].parent);
        }

        for (int i = 0; i < this.e; i++) {
            int x = find(subsets, edges[i].src);
            int y = find(subsets, edges[i].dest);

            if (x == y) {
                System.out.println("circle Formed");
                return;
            }
            this.union(subsets, x, y);
        }

        System.out.println("circle did not form");

    }

}

class unionfind {
    public static void main(String[] args) {
        GraphUnionFind graph = new GraphUnionFind(3, 3);
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        graph.checkIfCircleFormed();
    }
}