package window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Van
 * @date 2021/2/4 - 10:37
 *
 * 这里采用map，因为数组会超时，并且这里windowS只装入windowT有的char，要不然判断的时候windowS有得windowT没有就会报错，这点很麻烦！
 *
 */
public class 最小覆盖子串_map {
    public String minWindow(String s, String t) {
        Map<Character, Integer> windowS = new HashMap<>();
        Map<Character, Integer> windowT = new HashMap<>();
        // 注意这里defaultValue 是0！
        for (int i = 0; i < t.length(); i++) {
            windowT.put(t.charAt(i), windowT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        int valid = 0;
        while (right < s.length()) {
            // 一定先拿出来，要不然太隆长了
            char added = s.charAt(right++);
            // windowS之加入windowT有的char
            if (windowT.containsKey(added)) {
                windowS.put(added, windowS.getOrDefault(added, 0) + 1);
                // 注意！这里一定是要等于！不能大于等于！要不然遇到了相同的char valid会一直++
                if (windowS.get(added).intValue() == windowT.get(added).intValue()) {
                    valid++;
                }
            }
            // 开始缩小窗口
            while (valid == windowT.size()) {
                // 进行snapshot
                if (len > right - left) {
                    len = right - left;
                    minLeft = left;
                    minRight = right;
                }
                // 一样把要删除的char给拿出来
                char deleted = s.charAt(left++);
                // windowT有的才处理
                if (windowT.containsKey(deleted)) {
                    // 这里运用相反法，若此时他们俩这个char的个数相等，而wS又一定要删除一个char，所以valid必定要减少
                    if (windowT.get(deleted).intValue() == windowS.get(deleted).intValue()) {
                        valid--;
                    }
                    windowS.put(deleted, windowS.get(deleted) - 1);
                }
            }
        }
        // 如果一次都没有被快照过，说明s里面没有t，那么返回空字符串
        return len == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}
