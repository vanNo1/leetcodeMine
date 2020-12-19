package 双指针;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 思路：
 * 方法：
 * 使用 “快慢指针” 思想，找出循环：“快指针” 每次走两步，“慢指针” 每次走一步，当二者相等时，即为一个循环周期。此时，判断是不是因为 1 引起的循环，是的话就是快乐数，否则不是快乐数。
 * 注意：此题不建议用集合记录每次的计算结果来判断是否进入循环，因为这个集合可能大到无法存储；另外，也不建议使用递归，同理，如果递归层次较深，会直接导致调用栈崩溃。不要因为这个题目给出的整数是 int 型而投机取巧。
 * <p>
 * 假如是一个环，那么当slow==fast的时候，说明第一次相遇，说明是个环，所以不是happyNumber
 * 假如不是一个环，那么当slow==fast的时候，说明slow走到了1，说明不是一个环，所以是一个happyNumber
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getHappyNumber(slow);
            fast = getHappyNumber(fast);
            fast = getHappyNumber(fast);
        } while (slow != fast);
        //当slow==fast的时候，有两种可能，第一种：是一个环，此时fast正好与slow第一次相遇。第二种：slow第一次走到了1
        return slow == 1;
    }

    public int getHappyNumber(int pre) {
        int result = 0;
        while (pre > 0) {
            int tail = pre % 10;
            result = result + tail * tail;
            pre /= 10;
        }
        return result;
    }
}
