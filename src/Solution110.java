/**
 * 树无非就是前中后序遍历，然后根据平衡二叉树的特点，稍微剪剪枝，即可看下面的代码注释。
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        int res = height(root,1);
        //等于-1就不是平衡二叉树
        return res!=-1;
    }

    public int height(TreeNode root,int current){
        if (root==null){
            return current-1;
        }

        //左右递归，采用后续遍历，自底向上排查
        int left = height(root.left,current+1);
        //剪枝操作，左子树以及判断出来了，就不要再遍历右子树了
        if (left==-1){
            return -1;
        }
        int right = height(root.right,current+1);

        //如果右的数据是-1的，说明以及获取了答案，直接返回
        //如果左右子树高度相差超过1，返回-1，结束递归
        if (right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right);
    }
}
