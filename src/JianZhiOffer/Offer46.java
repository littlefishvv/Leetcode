package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/14 21:57
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer46 {
    //这一题可以改成可以组成多少个合理的组合
    int count=0;
    List<List<String>> res=new ArrayList<>();
    public int translateNum(int num) {
        String str=String.valueOf(num);
        List<String> list=new ArrayList();
        backTrack(str,0,list);
        return res.size();


    }
    public void backTrack(String str,int index,List<String> list){
        //不需要减一
        if(index==str.length()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=index+1;i<=index+2&&i<=str.length();i++){
            String t=str.substring(index,i);
            if(Integer.parseInt(t)>25){
                continue;
            }
            list.add(t);
            backTrack(str,i,list);
            list.remove(list.size()-1);

        }


    }

    public static void main(String[] args) {
        Offer46 o=new Offer46();
        System.out.println(o.translateNum(5));
    }
}
