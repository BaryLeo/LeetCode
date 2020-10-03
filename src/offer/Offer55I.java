package leetcode;

public class Offer55I {
    public int maxDepth(TreeNode root) {
        return depth(root,0);
    }

    public int depth(TreeNode root,int level){
        if (root==null){
            return level;
        }
        return Math.max(depth(root.left,level+1),depth(root.right,level+1));
    }
}
