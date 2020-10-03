package leetcode;

import java.util.HashMap;

public class Offer35 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node image = new Node(head.val);
        copy(head,image,new HashMap<Node,Node>());
        return image;
    }

    public void copy(Node origin, Node image, HashMap<Node,Node> map){
        map.put(origin,image);
        if (origin.next!=null){
            Node next = new Node(origin.next.val);
            image.next = next;
            copy(origin.next,next,map);
        }

        if (origin.random!=null){
            image.random = map.get(origin.random);
        }

    }
}
