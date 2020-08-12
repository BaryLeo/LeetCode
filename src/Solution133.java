import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution133 {
    /**
     * 广度优先遍历，迭代进行
     * @param node
     * @return
     */
    public Node cloneGraph1(Node node){
        if (node==null){
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node,Node> mark = new HashMap<>();
        Node head = new Node(node.val);
        queue.addLast(node);
        mark.put(node,head);
        while (!queue.isEmpty()){
            //获取需要被加载节点
            Node cur = queue.pollFirst();
            //新建被加载节点的备份
            Node cp = mark.get(cur);
            //开始每层循环加载
            for (Node n:cur.neighbors){
                //如果下一节点未被创建
                if (!mark.containsKey(n)){
                    //创建新的
                    Node cpx = new Node(n.val);
                    //标记
                    mark.put(n,cpx);
                    //加入下一节点
                    cp.neighbors.add(cpx);
                    //新创建的，需要进行深加载
                    queue.addLast(n);
                }else {
                    //若已被创建了，就不进行深加载
                    cp.neighbors.add(mark.get(n));
                }
            }
        }
        return head;
    }
    /**
     * 深度遍历,递归进行，迭代需要使用栈实现深度遍历
     * @param node
     * @return
     */
        HashMap<Node,Node> mark = new HashMap<>();
        public Node cloneGraph(Node node) {
            if (node==null){
                return null;
            }
            if (mark.containsKey(node)){
                return mark.get(node);
            }

            Node head = new Node(node.val,new ArrayList<>());
            mark.put(node,head);
            for (Node ns:node.neighbors){
                head.neighbors.add(cloneGraph(ns));
            }
            return head;
        }
}
