/**
 * 题目是节点有错
 * 不是子树之间有错
 */
public class Solution99 {
    //x存异常子节点
    //y存异常根节点（某种程度）
    //pred用来遍历
    TreeNode x = null, y = null, pred = null;


    public void findTwoSwapped(TreeNode root) {
        if (root == null) return;
        findTwoSwapped(root.left);
        //找到左边存在节点比根节点大的点
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else return;
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
