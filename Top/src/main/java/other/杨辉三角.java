package other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 思路：
 * 用递规
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            result.add(Arrays.asList(1));
            return result;
        }
        // 算出杨辉三角的上一个三角
        List<List<Integer>> pre = generate(numRows - 1);
        // last是杨辉三角上一个三角的最后一层
        List<Integer> last = pre.get(pre.size() - 1);
        // next是这次杨辉三角的最后一层
        List<Integer> next = new ArrayList<>();
        // 头尾都是1 ，先把头设为1
        next.add(1);
        int i = 0;
        // 直接用一个变量就行，每次加它以及它左边的，构成下一层的一个数
        while (i < last.size() - 1) {
            next.add(last.get(i) + last.get(i + 1));
            // 这一步我居然给忘了，导致无限循环
            i++;
        }
        next.add(1);
        // 最后把这一层加入，就能返回了
        pre.add(next);
        return pre;
    }
}
