/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<List<Integer>> paths = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        nodes.push(root);

        List<Integer> firstPath = new ArrayList<>();
        firstPath.add(root.val);

        paths.push(firstPath);
        sums.push(targetSum - root.val);

        while (!nodes.isEmpty()) {

            TreeNode curr = nodes.pop();
            List<Integer> path = paths.pop();
            int sum = sums.pop();

            // Check leaf node
            if (curr.left == null && curr.right == null) {

                if (sum == 0) {
                    ans.add(path);
                }
            }

            // Right child
            if (curr.right != null) {

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(curr.right.val);

                nodes.push(curr.right);
                paths.push(newPath);
                sums.push(sum - curr.right.val);
            }

            // Left child
            if (curr.left != null) {

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(curr.left.val);

                nodes.push(curr.left);
                paths.push(newPath);
                sums.push(sum - curr.left.val);
            }
        }

        return ans;
    }
}