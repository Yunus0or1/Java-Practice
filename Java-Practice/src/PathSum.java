import java.util.HashMap;

/**
 * Definition for a binary tree node.
 */
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

class PathSum {
    public boolean answer = false;
    public int targetSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        this.targetSum = targetSum;
        preOrder(root, 0);
        return answer;
    }

    public void preOrder(TreeNode root, int result) {
        if (root == null) {
            return;
        }

        int tmpResult = result + root.val;

        if(root.left == null && root.right == null){
            if(tmpResult == targetSum){
                this.answer = true;
                return;
            }
        }

        if(answer == true){
            return;
        }


        preOrder(root.left, tmpResult);
        preOrder(root.right, tmpResult);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        PathSum mx = new PathSum();
        boolean depth = mx.hasPathSum(tree, 13);
        System.out.println(depth);
    }
}