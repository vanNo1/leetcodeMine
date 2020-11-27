package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 超出时间
 */
public class 完全平方数 {
    private Queue<Integer> queue = new PriorityQueue<>();

    public int numSquares(int n) {
        int maxSquare = 1;
        for (int i = 1; i < n - 1; i++) {
            if (i * i >= n) {
                maxSquare = i;
                break;
            }
        }
        backTrack(maxSquare, 0, n);
        return queue.peek().intValue();
    }

    public void backTrack(int maxSquare, int step, int remain) {
        if (remain == 0) {
            queue.offer(step);
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = 1; i <= maxSquare; i++) {
            step++;
            backTrack(maxSquare, step, remain - i * i);
            step--;
        }
    }
}
