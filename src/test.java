


public class test {

    public static void main(String[] args) {

        Node nd = new Node(2);
        nd.setNextNode(new Node(3));


        while (nd != null){
            System.out.println(nd.getValue());
            nd = nd.getNextNode();
        }



    }
}

