package Aug10toAug16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/16 9:33
 * @description： 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * @modified By：
 * @version: $
 */
public class Problem733 {
    public int[][] floodFill(int[][] image,int sr,int sc,int newColor){
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int row=image.length;
        if (row<=0) return image;
        if (image[0].length<=0) return image;
        int col=image[0].length;
        //[-1,0],[1,0] [0,-1] [0,1]分别对应上下左右
        Queue<int[]> queue=new LinkedList();
        ((LinkedList) queue).push(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int n=queue.size();
            for (int j = 0; j < n; j++) {
                int[] tmp=((LinkedList<int[]>) queue).pop();
                int x=tmp[0];
                int y=tmp[1];
                for (int i = 0; i < 4; i++) {
                    int newx=x+dx[i];
                    int newy=y+dy[i];
                    if (newx>=0&&newx<row&&newy>=0&&newy<col){
                        if (image[newx][newy]!=0){
                            ((LinkedList<int[]>) queue).push(new int[]{newx,newy});
                            image[newx][newy]=newColor;
                        }
                    }
                }
            }
        }





        return image;
    }
}
