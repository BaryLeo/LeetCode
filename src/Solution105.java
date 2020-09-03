/**
 * 首先必须明确的一个概念，前序遍历，最左边一定是根节点
 * 中序遍历，最左边，必定是最左子叶子
 */
public class Solution105 {
    // 先序遍历表的遍历指针。
    int pre = 0;
    // 中序遍历表的遍历指针。
    int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归构建二叉树，初始化的 stop 值表示开始遍历范围在整个中序遍历表。
        return buildTree(preorder, inorder, (long)Integer.MAX_VALUE + 1);
    }

    //用前序遍历生成二叉树
    private TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        //判断数组是否已遍历完成
        if (pre==preorder.length){
            return null;
        }

        //判断是否已完成中序遍历
        if (inorder[in]==stop){
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        //完成先序遍历左子树
        root.left = buildTree(preorder,inorder,root.val);
        //中序遍历生成右子树
        root.right = buildTree(preorder,inorder,stop);
        return root;
    }
}
