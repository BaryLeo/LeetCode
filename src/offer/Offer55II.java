package leetcode;

public class Offer55II {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        if (Math.abs(depth(root.left,0)-depth(root.right,0))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);

    }

    public int depth(TreeNode root ,int level){
        if (root==null){
            return level;
        }
        return Math.max(depth(root.left,level+1),depth(root.right,level+1));
    }
}
