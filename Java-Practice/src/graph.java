import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


class GraphClass {
    private HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    void addNode(int value) {
        if (this.graph.containsKey(value)) return;

        this.graph.put(value, new ArrayList());
    }


    void addEdge(int source, int value) {
        List<Integer> currentNodeList = graph.get(source);
        currentNodeList.add(value);
        this.graph.put(source, currentNodeList);
    }

    public HashMap<Integer, List<Integer>> getGraph() {
        return graph;
    }

    void createGraph(){
        this.addNode(1);
        this.addNode(2);
        this.addNode(3);
        this.addNode(4);
        this.addNode(5);
        this.addNode(6);
        this.addNode(7);
        this.addNode(8);

        this.addEdge(1,4);
        this.addEdge(1,2);
        this.addEdge(2,3);
        this.addEdge(4,7);
        this.addEdge(4,5);
        this.addEdge(5,6);
        this.addEdge(5,8);


    }

    void printSingleNodeEdge(int source){
        List<Integer> nodeList = this.graph.get(source);
        for(int node : nodeList){
            System.out.println(node);
        }
    }

    void dfsTraverse(int root){
        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            System.out.println(currentNode);
            List<Integer> nodeList = graph.get(currentNode);

            for(int node : nodeList){
                stack.push(node);
            }
        }
    }

}


public class graph {

    public static void main(String[] args) {

        GraphClass graph = new GraphClass();
        graph.createGraph();
        graph.dfsTraverse(1);


    }

}
