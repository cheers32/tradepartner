package Q100_Q149;

import ds.DListNode;

import java.util.*;

public class Q146 {  // 这个题终于做出来了,思路确实比较有结构性,要多熟悉, O(1), read/put, O(N) space; notice the node is doubly linked, has key and value
    public static class LRUCache {  // made it a static class
        DListNode front;
        DListNode end;
        int len = 0;
        int cap = 0;
        Map<Integer, DListNode> map; // k-v map

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cap = capacity;
            front = new DListNode();  // important: use a dummy node makes the rest simple
            end = new DListNode();
            front.next = end;  // important init technique for doubly linked list
            end.prev = front;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                DListNode node = map.get(key);
                removeFromList(node);
                insertToFront(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {  // only get and put controls map
            DListNode node;
            if(map.containsKey(key)) {
                node = map.get(key);
                node.val = value;
                removeFromList(node);
                insertToFront(node);
            } else {
                node = new DListNode(key, value);
                map.put(key, node);
                len++;
                insertToFront(node);  // this is another reused method
                if(len>cap) {
                    DListNode nodeToRemove = end.prev;  // this step is important
                    removeFromList(nodeToRemove);  // this is a reused method
                    map.remove(nodeToRemove.key);
                    len--;
                }
            }
        }

        void removeFromList(DListNode n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
        }

        void insertToFront(DListNode n) {
            n.next = front.next;
            n.prev = front;
            n.next.prev = n;
            front.next = n;
        }
    }

    public static void main(String[] args) {
        Q146 algo = new Q146();
        LRUCache cache = new LRUCache(2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
    }
}
