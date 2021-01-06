package others;

import java.util.regex.Pattern;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/23 16:32
 * @description：
 * @modified By：
 * @version: $
 */
public class Patterns {



    public static void main(String[] args) {
        String s="dogggs";
        String pattern="dog.+";
        String p2="\\\\";
        String s2="\\";

        boolean match=Pattern.matches(pattern,s2);
        boolean match2=Pattern.matches(p2,s2);
        System.out.println(match);
        System.out.println(match2);
    }
}
