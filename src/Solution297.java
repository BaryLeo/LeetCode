import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        doSerialize(root,stringBuilder);
        String result = stringBuilder.toString();
        return result.substring(0,result.length()-1);
    }

    public void doSerialize(TreeNode node,StringBuilder stringBuilder){
        if (node==null){
            stringBuilder.append("null:");
            return;}
        stringBuilder.append(node.val);
        stringBuilder.append(":");
        doSerialize(node.left,stringBuilder);
        doSerialize(node.right,stringBuilder);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ar = data.split(":");

        LinkedList<String> list = new LinkedList<>(Arrays.asList(ar));

        return doDeSerialize(list);
    }

    public TreeNode doDeSerialize(List<String> list){
        String now = list.get(0);
        list.remove(now);
        if (now.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(now));

        root.left=doDeSerialize(list);
        root.right=doDeSerialize(list);
        return root;
    }
    public TreeNode getTreeNode(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        return treeNode;
    }

    public String getStrData(){
        return "1:2:null:null:3:4:null:null:5:null:null";
    }
}

