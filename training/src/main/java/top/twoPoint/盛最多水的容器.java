package top.twoPoint;

/**
 * @author Van
 * @date 2021/2/11 - 11:27
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int max = 0;
        int point1 = 0;
        int point2 = height.length - 1;
        while (point1 < point2) {
            int distance = point2 - point1;
            int high = Math.min(height[point1], height[point2]);
            max = Math.max(max, distance * high);
            if (height[point1] < height[point2]) {
                point1++;
            } else {
                point2--;
            }
        }
        return max;
    }

}
