package recursionAndHuisu;

import SetAndMap.Problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 11:33
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem51 {
    static int count=1;
    List<List<String>> res=new ArrayList<>();
    List<List<Integer>> pos=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> list=new ArrayList<>();
        if(n==0) return res;
        backTrack(n,0,pos,list);
        return res;

    }

    //index代表行号 【index,i】代表新皇后放入的位置  不过indexh
    private void backTrack(int n,int index,List<List<Integer>> pos,List<String> list){

        if (list.size()==n){
            res.add(new ArrayList<>(list));
        }

        loop1:for (int i=0;i<n;i++){
            //如果当前(index,i）位置对这任何一个位置有冲突，就放弃这个位置，进行continue  如何判断冲突？
            for (int j=0;j<pos.size();j++){
                List<Integer> tmp=pos.get(j);

                System.out.println("当前i"+i);
                System.out.println(Arrays.toString(tmp.toArray()));
                System.out.println("i，index"+i+" "+index);
                System.out.println(Math.abs((tmp.get(1)-i)/(tmp.get(0)-index)));

                if (tmp.get(0)==index||tmp.get(1)==i||Math.abs(i-tmp.get(1))==Math.abs(index-tmp.get(0)) ){
                    continue  loop1;
                }
            }
            //否则就放到i这个位置

            list.add(getStr(n,i));
            pos.add(new ArrayList<>(Arrays.asList(index,i)));
            //注意这index只能先加，才能放到参数了，而不是再参数里加一  为什么呢？也许面试官会问呢 因为这个如果再参数里加，当退出那次的回溯后，index就没用了，再减的是没有加的index，就会出现负数

            //当然，这里完全不用这样写，只需要再参数里直接加一就行了，也就是说去点index++和index--，直接在参数里传入index+1
            index++;
            System.out.println(Arrays.toString(pos.toArray()));
            //进行回溯  每一次回溯都会在index这一行找到一个合适的位置放入，如果找不到，就退出这次的回溯，就把这个index--
            backTrack(n,index,pos,list);
            //撤销选择
            index--;

            pos.remove(pos.size()-1);
            list.remove(list.size()-1);
        }

    }

    //根据i和n构造出一个字符串
    public String getStr(int n,int i){
        StringBuffer s=new StringBuffer();
        for (int j=0;j<n;j++){
            if (j!=i)
                s.append(".");
            else
                s.append("Q");
        }
        return s.toString();

    }

    public static void main(String[] args) {
        Problem51 p=new Problem51();
        p.solveNQueens(5);
    }

}
