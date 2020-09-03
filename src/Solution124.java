public class Solution124 {
    int max = Integer.MIN_VALUE;
    /**
     * 要返回，那么就返回parent+left 或者parent+right，但是记录最大的时候可以记录parent+left+right(黑人问号)
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }

    public int findMax(TreeNode root){
        if (root==null){
            return 0;
        }

        //砍掉小于0的一边，剪枝操作
        int leftSum = Math.max(findMax(root.left),0);
        int rightSum = Math.max(findMax(root.right),0);
        //找最大
        max = Math.max(max,leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;
    }

}
