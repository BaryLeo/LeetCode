

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==root||q==root){
            //当遇到了目的节点，就一直返回当前节点
            //有两种情况
            //第一种，另一个节点在当前节点的子节点下，当前节点就是答案
            //第二种，另一个节点在另一颗树，直接返回，当左右节点都不为null时，那个节点就是答案
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if (l!=null&&r!=null){
            return root;
        }

        return l==null?r:l;
    }
}
