package others.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 20:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Write {
    public static void main(String[] args) {
        try{
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/Temp/test.txt")));
            bw.write("ttt");
            bw.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
