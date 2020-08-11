package com.van.leetcode.recurse;

import org.omg.CORBA.ORB;

public class 图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor=image[sr][sc];
        int[][]visited=new int[image.length][image[0].length];
        fill(image,sr,sc,originColor,newColor,visited);
        return image;
    }
    public void fill(int[][] image,int x,int y,int originColor,int newColor,int [][]visited){
        if (!isInArea(image,x,y)){
            return;
        }
        if (image[x][y]!=originColor){
            return;
        }
        if (visited[x][y]==1){
            return;
        }
        image[x][y]=newColor;
        visited[x][y]=1;
        fill(image,x-1,y,originColor,newColor,visited);
        fill(image,x+1,y,originColor,newColor,visited);
        fill(image,x,y-1,originColor,newColor,visited);
        fill(image,x,y+1,originColor,newColor,visited);
    }
    public boolean isInArea(int[][] image,int x,int y){
        return x>=0&&x<image.length
                &&y>=0&&y<image[0].length;
    }
}
