package recent.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Van
 * @date 2021/3/2 - 11:24
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 用map装每个数字对应的频率：key=数字，value=这个数字的频率
 * 然后创建一个装list的数组，让这个数组的下标对应频率，key装在这个下标对应的List中，然后从尾到头去扫描
 * 尾部装的肯定是频率最多的，把key装进去即可
 */
public class 前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (list[frequency] == null) {
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            // 这里不用担心一下子会装多了，因为题目说了答案有唯一性，所以不可能出现装多的情况！
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
