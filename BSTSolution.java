/*
 * Works only on binary search tree.
 */
public class BSTSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return checkNode(root, p, q);
    }

    private TreeNode checkNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root.val <= q.val && root.val >= p.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        }

        return left == null ? right : left;
    }
}
