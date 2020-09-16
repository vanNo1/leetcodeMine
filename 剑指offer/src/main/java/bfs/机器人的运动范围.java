package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] point = new int[2];
        point[0] = 0;
        point[1] = 0;
        queue.offer(point);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[]temp=queue.poll();
                if (temp[0]>=0&&temp[0]<n&&temp[1]>=0&&temp[1]<m&&!visited[temp[0]][temp[1]]){
                    visited[temp[0]][temp[1]]=true;
                    res++;
                    int[]up=new int[]{temp[0]+1,temp[1]};
                    int[]down=new int[]{temp[0]-1,temp[1]};
                    int[]left=new int[]{temp[0],temp[1]-1};
                    int[]right=new int[]{temp[0],temp[1]+1};
                    queue.offer(up);
                    queue.offer(down);
                    queue.offer(left);
                    queue.offer(right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean[]a=new boolean[3];
        System.out.println(a[1]);
    }

}
