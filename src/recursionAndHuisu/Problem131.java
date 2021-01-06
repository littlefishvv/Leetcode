package recursionAndHuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/4 9:50
 * @description：
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem131 {
    public List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        if (!(s==null||s.length()<4)){
            backIp(s,0,list);
        }
        return res;

    }
    public void backIp(String s,int index,List<String> list){
        //maxLength代表剩余应该维持的最大程长度，如我list中已经有前两段了，还剩两段，如果这两段最大长度（maxlength）小于s的剩余
        // 常读，说明取错了
        int maxLength=(4-list.size())*3;
        //如果回溯过程中判断没有成功的希望，就直接剪枝
        if (s.length()-index>maxLength){
            return;
        }
        //如果list中有四段，并且index刚好是list的长度【为什么不需要减一，因为这个index在一开始就判断了。其实list中取的是index-1的元素组合，】，就说明这是一个合法的ip地址
        if(list.size()==4&&s.length()==index){
            StringBuffer sb=new StringBuffer();
            for (int i=0;i<list.size();i++){
                if (i==0) sb.append(list.get(i));
                else sb.append(".").append(list.get(i));
            }

            res.add(sb.toString());
            return ;
        }

        //开始构造i 每次构建的ip片段最长不超过三位
        for (int i=index+1;i<=index+3&&i<=s.length();i++){
            //substring(start,end)包括start不包括end
            String ip=s.substring(index,i);
            if(Integer.parseInt(ip)>255) continue;
            //非第一段不能以0开头
            if (ip.length()>1&&"0".equals(ip.substring(0,1))) continue;
            //经过了上面的判断说明这段ip片段是有效的
            list.add(ip);
            backIp(s,i,list);
            //因为是list，所有的list都是对同一个list的操作，所以要去掉最后一个让别的进来。
            list.remove(list.size()-1);
        }


    }


}
