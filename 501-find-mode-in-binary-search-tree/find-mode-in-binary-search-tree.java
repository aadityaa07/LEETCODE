import java.util.*;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {

        traverse(root);

        int max = 0;

        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        traverse(root.left);
        traverse(root.right);
    }
}