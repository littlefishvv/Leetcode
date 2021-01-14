package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 11:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem52 {

    static int count=0;
    List<List<String>> res=new ArrayList<>();
    List<List<Integer>> pos=new ArrayList<>();

    public  int  totalNQueens(int n) {
        List<String> list=new ArrayList<>();
        if(n==1) return count;
        backTrack(n,0,pos,list);
        return count;

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

            System.out.println(Arrays.toString(pos.toArray()));
            //进行回溯
            backTrack(n,index+1,pos,list);
            //撤销选择


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

}
