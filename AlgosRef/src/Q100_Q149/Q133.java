package Q100_Q149;

import ds.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q133 {
    public Node cloneGraph(Node node) {  // this problem has become so easy, N
        if(node == null)
            return null;
        Map<Node, Node> map = new HashMap<>();  // if there's duplicate keys, then use the Node itself as the key, oldNode -> newNode; i used the Integer key at first, it's same performance
        Node res = visit(node, map);
        return res;
    }

    Node visit(Node node, Map<Node, Node> map) {
        if(map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);   // this step must do it before the recursion, otherwise it's endless loop; i put it at last the first try; my concern was not a complete init, but that's ok
        for(Node n : node.neighbors) {
            newNode.neighbors.add(visit(n, map));
        }
        return newNode;
    }
}
