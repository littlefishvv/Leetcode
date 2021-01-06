package others.io;

import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 20:10
 * @description：
 * @modified By：
 * @version: $
 */
public class read {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("c:/Temp/sesvc_216.log")));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);

            }
        } catch (Exception e){
            e.printStackTrace();

        }

    }
}
