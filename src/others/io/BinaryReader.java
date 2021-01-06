package others.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 20:45
 * @description：
 * @modified By：
 * @version: $
 */
public class BinaryReader {
    public static void main(String[] args) {
        try{
            //写文件流 全部都是output
            File zipFile=new File("C:/Temp/yutng.zip");
            DataOutputStream du=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("c:/Temp/yutingtest.JPG")));
            //读文件流  全部都是input
            DataInputStream dn=new DataInputStream(new BufferedInputStream(new FileInputStream("c:/Temp/yuting.JPG")));
            byte[] b=new byte[1024];
            ZipOutputStream zip=new ZipOutputStream(new FileOutputStream(zipFile));
            zip.putNextEntry(new ZipEntry("yuting.JPG"));
            while(dn.read(b)!=-1){
                du.write(b);
            }
            int temp=0;
            while(dn.read(b)!=-1){
               zip.write(b);
            }
            zip.close();
            dn.close();
            du.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
