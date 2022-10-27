import java.util.*;
import java.util.LinkedList;

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

class MinDepth {
    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> visited = new LinkedList<>();
        q.add(root);

        int x = 1;

        while (q.size() != 0) {
            TreeNode node = q.poll();

            if (node.left == null && node.right == null) {
                return x;
            }

            visited.add(node);

            if (q.size() == 0 && visited.size() != 0) {
                while (visited.size() != 0) {
                    TreeNode v = visited.poll();
                    if (v.left != null) {
                        q.add(v.left);
                    }

                    if (v.right != null) {
                        q.add(v.right);
                    }
                }

                x++;
            }
        }

        return x;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MinDepth aa = new MinDepth();
        System.out.println(aa.minDepth(root));
    }
}