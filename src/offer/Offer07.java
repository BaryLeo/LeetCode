package offer;

/**
 * 首先必须明确的一个概念，前序遍历，最左边一定是根节点
 * 中序遍历，最左边，必定是最左子叶子
 */
public class Offer07 {

    // 先序遍历表的遍历指针。
    int pre = 0;
    // 中序遍历表的遍历指针。
    int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Long.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int[] inorder,long stop){
        //当先序遍历完成了，一切就结束了
        if (pre==preorder.length){
            return null;
        }

        //如果到了边界了，停下，到下一个中序
        if (inorder[in] == stop){
            in++;
            return null;
        }

        //前序遍历第一个肯定是根节点
        TreeNode root = new TreeNode(preorder[pre++]);

        root.left = build(preorder,inorder,root.val);
        root.right = build(preorder,inorder,stop);
        return root;
    }
}
