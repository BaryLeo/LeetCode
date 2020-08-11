
/**
 * 利用二叉搜索树的特性
 * 若p，q都小于一边，则一定是在一边，若分开了，当前节点一定是最近的共同祖先
 */
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //右子树，根最小
        if (root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {

        }

        //左子树，根最大
        if (root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        //以上两种都不是，肯定是当前节点了，即分叉点
        return root;
    }

}
