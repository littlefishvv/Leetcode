package Aug4toAug9;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/9 16:55
 * @description：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/restore-ip-addresses 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class problem93 {

    public void restoreIpAddresses(String s, int index, List<String> list,List<String> result){
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数 list存放的是ip的一个段如255，index是指.到那个地方了，如255.此时index=2
        int maxLength=(4-list.size())*3;
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求 例如25.2554414561后面是大于9位的，说明这个可以剪枝了直接return就行
        if (s.length()-index>maxLength) return;
        // 如果index到头了而且list中已经存4段了。说明这个ip满足条件，拼接放入res即可
        if (list.size()==4&&s.length()==index) {
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (i==0) sb.append(list.get(i));
                else
                    sb.append(".").append(list.get(i));
            }
            result.add(sb.toString());
        }
        for (int i=index+1;i<=index+3&&i<s.length();i++){
            String ip=s.substring(index,i);
            //下面是做选择
            if(Integer.parseInt(ip)>255) continue;
            if(ip.length()>1&&"0".equals(ip.substring(0,1))) continue;
            list.add(ip);
            //进行回溯
            restoreIpAddresses(s,i,list,result);
            //撤销选择
            list.remove(list.size()-1);
        }
    }

}

