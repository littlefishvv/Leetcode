package others.tools;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/26 11:18
 * @description：
 * @modified By：
 * @version: $
 */
public class StringRemove {
    public static  String removeSome(String str){
        str.replace('"',' ');
        str.replace('+',' ');
        return str;
    }
    public static void main(String[] args) {
        System.out.println(removeSome("\"select PUB_AJ_JB.* from PUB_AJ_JB,PUB_SPRY where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND \" +\n" +
                "                \"PUB_SPRY.SFCBR='Y' AND PUB_SPRY.XM='\"+cbr+\"' AND PUB_AJ_JB.JARQ BETWEEN \" + beginTime +\" AND \" + endTime"));
    }
}
