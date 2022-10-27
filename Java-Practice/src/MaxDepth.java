import java.util.HashMap;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class MaxDepth {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        HashMap<TreeNode, Integer> map = new HashMap<>();

        map.put(root, 1);
        preOrder(root, map);

        int highest = 1;
        for (int value : map.values()) {
            if (value > highest) {
                highest = value;
            }
        }

        return highest;
    }

    public void preOrder(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }

        int rootLevel = map.get(root);
        int nextLevel = rootLevel + 1;

        if (root.left != null) {
            map.put(root.left, nextLevel);
        }
        if (root.right != null) {
            map.put(root.right, nextLevel);
        }

        preOrder(root.left, map);
        preOrder(root.right, map);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        MaxDepth mx = new MaxDepth();
        int depth = mx.maxDepth(tree);
        System.out.println(depth);
    }
}