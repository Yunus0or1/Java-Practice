import java.util.Arrays;
import java.util.HashMap;

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

class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        int length = nums.length;
        int midValue = nums[length / 2];
        TreeNode root = new TreeNode(midValue);
        convertToBST(nums, root);

        return root;
    }

    public void convertToBST(int[] nums, TreeNode node) {

        if (nums.length == 0) {
            return;
        }

        int length = nums.length;
        int[] leftArray = Arrays.copyOfRange(nums, 0, length / 2);
        int[] rightArray = Arrays.copyOfRange(nums, length / 2 + 1, length);

        TreeNode leftNode = new TreeNode(leftArray[length / 2]);
        TreeNode rightNode = new TreeNode(rightArray[length / 2]);

        node.left = leftNode;
        node.right = rightNode;

        convertToBST(leftArray, leftNode);
        convertToBST(rightArray, rightNode);
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };

        SortedArrayToBST sb = new SortedArrayToBST();
        System.out.println(sb.sortedArrayToBST(nums));
    }
}