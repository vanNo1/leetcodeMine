package recent.other;

import java.util.*;

/**
 * @author Van
 * @date 2021/3/7 - 13:01
 * <p>
 * 最关键的一点：get更新，是直接删除那个node，然后在头部新增，而不是移动这个node到头部
 */
public class LRUCache {
    private LinkedList<Node> list = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private int capacity;

    class Node {
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            list.removeIf(node -> node.key == key);
            list.addFirst(new Node(key, value));
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            list.removeIf(node -> node.key == key);
            list.addFirst(new Node(key, value));
        } else {
            if (map.size() == capacity) {
                Node last = list.getLast();
                map.remove(last.key);
                list.removeLast();
            }
            list.addFirst(new Node(key, value));
            map.put(key, value);
        }
    }
}
