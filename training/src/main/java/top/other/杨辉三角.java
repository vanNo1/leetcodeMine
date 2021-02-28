package top.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/19 - 11:03
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows==0){
            return result;
        }
        if (numRows == 1) {
            result.add(Arrays.asList(1));
            return result;
        }
        List<List<Integer>> pre = generate(numRows - 1);
        List<Integer> preLine = pre.get(pre.size() - 1);
        List<Integer> currentLine=new ArrayList<>();
        currentLine.add(1);
        for (int i = 0; i < preLine.size()-1; i++) {
            currentLine.add(preLine.get(i)+preLine.get(i+1));
        }
        currentLine.add(1);
        pre.add(currentLine);
        return pre;
    }
}
