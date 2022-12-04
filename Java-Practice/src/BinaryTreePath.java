import java.util.ArrayList;
import java.util.List;

class BinaryTreePath {
    List<String> result  = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
         preOrder(root, "");
         return result;
    }

    void preOrder(TreeNode root, String current) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(current + Integer.toString(root.val));
        }

        preOrder(root.left, current + Integer.toString(root.val) + "->");
        preOrder(root.right, current + Integer.toString(root.val) + "->");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        new BinaryTreePath().binaryTreePaths(root);
    }
}