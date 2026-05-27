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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                currentLevel.add(node.val);
            }
            result.add(currentLevel);
        }
        List<Integer> rightSideView = new ArrayList<>();
        for (List<Integer> level : result) {
            rightSideView.add(level.get(level.size() - 1));
        }
        return rightSideView;
    }
}
