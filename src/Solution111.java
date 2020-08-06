/**
 * 深度优先搜索，比较特殊，比找最深的特殊
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        //没有任何节点就返回
        if (root == null) {
            return 0;
        }

        //null节点不参与计算
        //判断左右情况
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }

        //都不为null则返回最小的
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
