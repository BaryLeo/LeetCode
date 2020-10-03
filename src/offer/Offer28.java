package leetcode;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode r,TreeNode l){
        if (r==null&&l==null){
            return true;
        }

        if (r==null||l==null){
            return false;
        }

        return r.val==l.val&&dfs(r.left,l.right)&&dfs(r.right,l.left);
    }
}
