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

public class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution270 {

    int min;
    public int closestValue(TreeNode root, double target) {
        
        min = root.val;

        // Solution 1: Auxilary space O(logh)
        dfs(root, target); // O(logh)

        // Solution 2: Auxilary space O(1)
        while(root != null){

            if(Math.abs(root.val - target) < Math.abs(min - target))
                min = root.val;

            if(root.val > target)
                root = root.left;
            else
                root = root.right;

        }

        return min;
    }

    public void dfs(TreeNode root, double target){

        if(root == null)
            return;

        if(Math.abs(root.val - target) < Math.abs(min - target))
            min = root.val;

        if(root.val > target)
            dfs(root.left, target);
        else
            dfs(root.right, target);
    }
}

