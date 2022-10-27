import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class MinDepth {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> visited = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);

        while (q.size() != 0) {
            TreeNode node = q.poll();

            visited.add(node);

            if (q.size() == 0) {
                List<Integer> tmp = new ArrayList<>();
                while (visited.size() != 0) {
                    TreeNode v = visited.poll();
                    tmp.add(v.val);
                    if (v.left != null) {
                        q.add(v.left);
                    }

                    if (v.right != null) {
                        q.add(v.right);
                    }
                }
                result.add(tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}