package other;

/**
 * @author Van
 * @date 2021/2/6 - 11:47
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        int leftToRight = 1;
        // 一开始是赋值、改变leftToRight
        for (int i = 0; i < a.length; i++) {
            ans[i] = leftToRight;
            leftToRight *= a[i];
        }
        int rightToLeft = 1;
        // 后面都有值了，之后是：乘等于、改变rightToLeft
        for (int i = a.length - 1; i >= 0; i--) {
            ans[i] *= rightToLeft;
            rightToLeft*=a[i];
        }
        return ans;
    }
}
