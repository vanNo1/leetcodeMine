package recent.list;

/**
 * @author Van
 * @date 2021/2/27 - 10:33
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
