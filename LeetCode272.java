public class LeetCode272 {
    
}

class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                Math.abs(b - target),
                Math.abs(a - target)
            )
        );

        inorder(root, target, k, pq);

        return new ArrayList<>(pq);
    }

    private void inorder(
        TreeNode root,
        double target,
        int k,
        PriorityQueue<Integer> pq
    ) {
        if (root == null)
            return;

        inorder(root.left, target, k, pq);

        pq.offer(root.val);

        if (pq.size() > k) {
            pq.poll(); // remove farthest
        }

        inorder(root.right, target, k, pq);
    }
}